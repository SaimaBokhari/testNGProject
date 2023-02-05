package techproed.tests.smoketest.logintests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class Day19_NegativeLoginTest {
    /*
    Name:
US100208_Negative_Login
Description:
User should not be able login with incorrect credentials
Acceptance Criteria:
As customer, I should not be able to log in the application
Customer email: fake@bluerentalcars.com
Customer password: fakepass
Error: User with fake@bluerentalcars.com not found
     */
    HomePage homePage;
    LoginPage loginPage;
    Faker faker;

    @Test(groups = "minor-regression-group", retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void incorrectEmailAndPassword() throws IOException {
        // Go to https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        // Click on login button  (Create the HomePage first and create object)
        homePage= new HomePage(); // instantiate it

        try {

            homePage.userId.click();
            homePage.logoutLink.click();
            homePage.OK.click();

        }catch (Exception e){

        }

        homePage.homePageLoginButton.click();

        // We land on the next page logIn page,so we create another Page to locate and store email and password
        loginPage = new LoginPage(); // instantiate it

        // Type "fake@bluerentalcars.com" into email input
        loginPage.email.sendKeys("fake@bluerentalcars.com");

        // Type "fakepass" into password input
        loginPage.password.sendKeys("fakepass");

        // Click on login button
        ReusableMethods.waitFor(2);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(2);
        // Verify the Error message: User with email fake@bluerentalcars.com not found
        String errorMessage = loginPage.incorrectEmailAndPassword_ErrorMessage.getText();
        assertEquals(errorMessage,"User with email fake@bluerentalcars.com not found");

        // Take screenshot
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");
        // Close driver
        Driver.closeDriver();

    }


    // Dynamic fake data by using FAKER
    @Test (groups = "minor-regression-group")
    public void invalidCredentialsTest() throws IOException {
        // Go to https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        // Click on login button  (Create the HomePage first and create object)
        homePage= new HomePage(); // instantiate it

        try {

            homePage.userId.click();
            homePage.logoutLink.click();
            homePage.OK.click();

        }catch (Exception e){

        }

        homePage.homePageLoginButton.click();

        // We land on the next page logIn page,so we create another Page to locate and store email and password
        loginPage = new LoginPage(); // instantiate it

        // Type fake data by instantiating faker
        faker= new Faker();
        String fakeEmail = faker.internet().emailAddress();
        loginPage.email.sendKeys(fakeEmail);

        // fake password
        loginPage.password.sendKeys(faker.internet().password(4,6));  // fake password upto 4-6 digits

        // Click on login button
        ReusableMethods.waitFor(2);
        loginPage.loginButton.click();

        // Verify the Error message
        ReusableMethods.waitFor(2);
        String errorMessage = loginPage.incorrectEmailAndPassword_ErrorMessage.getText();
        assertEquals(errorMessage,"User with email "+fakeEmail+" not found");

        // Take screenshot
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");

        // Close driver
        Driver.closeDriver();

    }
}
