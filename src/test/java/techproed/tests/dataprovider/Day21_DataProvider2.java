package techproed.tests.dataprovider;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day21_DataProvider2 {
    HomePage homePage;
    LoginPage loginPage;


    // DATA PROVIDER METHOD
    @DataProvider
    public Object[][] customerData(){
        // Test Data
        Object [][] customersCredentials = {
                {"sam.walker@bluerentalcars.com","c!fas_art"},
                {"kate.brown@bluerentalcars.com","tad1$Fas"},
                {"raj.khan@bluerentalcars.com","v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com","Nga^g6!"}
        };
        return customersCredentials;
    }

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

    }


    @Test(dataProvider = "customerData")
    public void customerLoginTest(String username, String password){

        login();
        loginPage.email.sendKeys(username);
        ReusableMethods.waitFor(1);
        loginPage.password.sendKeys(password);
        ReusableMethods.waitFor(2);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(2);

        // Verify if login is successful (if userId is displayed, then it's successful)
        ReusableMethods.verifyElementDisplayed(homePage.userId);
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
// Data Driven Testing