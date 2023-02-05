package techproed.tests.smoketest.logintests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;


public class Day18_PositiveLoginTest {
    /*
User Story 1
Name: US100201_Admin_Login
Description:
User should be able login as admin
Acceptance Criteria:
As admin, I should be able to log in the application
https://www.bluerentalcars.com/
Admin email: jack@gmail.com
Admin password: 12345
     */

    /*
    Given
         Go to https://www.bluerentalcars.com/
    When
         Click on login button
     And
         Type "jack@gmail.com" into email input
     And
         Type "12345 into password input
     And
         Click on login button
     Then
         Verify user logged in
     */

    HomePage homePage;  // at class level
    LoginPage loginPage;
    @Test(groups = "minor-regression-group", retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void admin_Login(){
        Reporter.log("Going to the application URL");
        // Go to https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        // Click on login button  (Create the HomePage first and create object)
        homePage= new HomePage(); // instantiate it
        ReusableMethods.waitFor(2);
        homePage.homePageLoginButton.click();

        // We land on the next page logIn page,so we create another Page to locate and store email and password
        loginPage = new LoginPage(); // instantiate it

        // Type "jack@gmail.com" into email input
        loginPage.email.sendKeys("jack@gmail.com");

        // Type "12345 into password input
        loginPage.password.sendKeys("12345");

        // Click on login button
        ReusableMethods.waitFor(2);
        loginPage.loginButton.click();

        // Verify user logged in
        // assertTrue(homePage.userId.isDisplayed()); // OLD WAY
        ReusableMethods.verifyElementDisplayed(homePage.userId); // REUSABLE METHOD .. RECOMMENDED

        // Close driver
        Driver.closeDriver();
        Reporter.log("Test is complete!");

        /*
         There are 3 main parts for testing: UI, Database and API .. Also called End to End Testing
         Smoke test is for UI (front-end) using Selenium
         API and Database are backend testing.
         Postman is used for Manual Testing of API.

         Smoke Test:
         Critical functionalities
         Every day at least once ... preferably in the morning
         about 20 cases .. lasts about 15 mins

         Regression Test:
         Major functionalities
         After major BUG FIX and Before every release of the application (new version)...
         Every 4-6 months
         Can have 500+ tests .. can last for 4-5 hours (depends on the size of the company)
         Regression test is comprehensive
         Tests unintended side effects of updates/bug fixes

         */


    }

}
