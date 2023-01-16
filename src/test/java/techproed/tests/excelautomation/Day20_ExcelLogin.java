package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class Day20_ExcelLogin {

    HomePage homePage;
    LoginPage loginPage;

    ExcelUtils excelUtils;
    List<Map<String, String>> allTestData;  // This will store all data from Excel file


    // Create a login method
    public void login() {
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        ReusableMethods.waitFor(1);  // Hard wait

        try {
            homePage.homePageLoginButton.click();
        }catch (Exception e){
        }
        // in order to login each user, we need to logout each, one by one, so we include the following steps:
        try{
            ReusableMethods.waitFor(1);
            homePage.userId.click();
            ReusableMethods.waitFor(1);
            homePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            homePage.OK.click();
            ReusableMethods.waitFor(1);
            homePage.homePageLoginButton.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){

        }
        ReusableMethods.waitFor(1);
        // We'll send the credentials using Excel file
        // We need to use multiple credentials

    }



    @Test
    public void customerLoginTest() {
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";

        excelUtils = new ExcelUtils(path, sheetName); // instantiate it .. needs 2 parameters as Constructor is parameterised

        // getDataList() returns all Excel data and then we store it in allTestData variable.
        allTestData = excelUtils.getDataList();

//        System.out.println("allTestData = " + allTestData); // List of Map will print the data in random order
//        System.out.println(excelUtils.getColumnsNames());
//        System.out.println(excelUtils.getCellData(2,1));

        // Using LOOP get the values from the map one by one and send them to the UI

        for (Map<String,String> eachData: allTestData){
            // Takes us to the homepage
            login();  // the method we created above ( before this test)
            loginPage.email.sendKeys(eachData.get("username"));
            ReusableMethods.waitFor(2);
            loginPage.password.sendKeys(eachData.get("password"));
            ReusableMethods.waitFor(2);
            loginPage.loginButton.click();
            ReusableMethods.waitFor(2);

            // Verify if login is successful (if userId is displayed, then it's successful)
            ReusableMethods.verifyElementDisplayed(homePage.userId);

        }

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}

/*
    Login Credentials for Manual Testing

    sam.walker@bluerentalcars.com	c!fas_art
    kate.brown@bluerentalcars.com	tad1$Fas
    raj.khan@bluerentalcars.com	v7Hg_va^
    pam.raymond@bluerentalcars.com	Nga^g6!

  Whenever you're sending multiple credentials, you need to understand the
  FLOW first and then automate accordingly.

   Do manual testing always to understand the Test FLow like below

           LOGIN FLOW
        click on login LINK          ------>>>>>>  homePage.homePageLoginLink.click(); --->> TRY WHEN LINK IS THERE---> 1st TRY CATCH--> logIn
        send username
        send password                 ----->>>>> DONE
        click on login BUTTON
        I AM ON HOME PAGE
        **********PATTERN 1**********
        click on user id
        click on log out             ----->>>>>>2nd TRY CATCH -> logIn
        click on ok
        I AM ON HOME PAGE AGAIN
        click on login LINK
        *********PATTERN 2***********
        send username
        send password           ----->>>>>>>>>>>>>>>>>@Test Method is used to send credentials and verification
        click on login Button
        I AM ON HOME PAGE AGAIN
        *****************
         click on user id
        click on log out
        click on ok                     ----->>>>>>2nd TRY CATCH -> logIn
        I AM ON HOME PAGE AGAIN
        click on login LINK
         ********************
        send username
        send password       ----->>>>>>>>>>>>>>>>>@Test Method is used to send credentials and verification
        click on login Button
        I AM ON HOME PAGE AGAIN

            NOTE: in the first loop, the user will login, when the loop will send
                  the credentials for the 2nd user, system will throw NoSuchElementException,
                  so we use Try/catch in the login() ..
                  But the first user is still signed in, we need to log the first user out,
                  so we create second try/catch block in the login().

                  This type of tests can be part of Regression Test Suite
     */

/*
Excel Automation:

> Apache poi library is used to work with Microsoft Files (put it in your pom.xml)
> Workbook > Sheet > Row > Cell

Excel Utils
> Reusable Methods (Recommended)
> Getting the list of data as List or Map or Array
> Getting the number of rows, columns, or writing on the Excel file
> That data will be used in the test classes
> This type of testing is called DATA DRIVEN TESTING. (Testing the application with multiple external data (coming from Excel)
> Coz Data generates new test cases

Test Data:
> Where do you get your testing data?
  BA(through FRD,BRD) , Test Lead, Tech Lead, Manual Tester, Developers
> How do you use the data in test cases?
  I always try to use data dynamically. Some data sources are:
     > External Files (Excel, Config.properties, Json, Xml etc.)
     > Database
     > API
     > Faker

Remember Config.properties sheet should only store most important data.

 */
