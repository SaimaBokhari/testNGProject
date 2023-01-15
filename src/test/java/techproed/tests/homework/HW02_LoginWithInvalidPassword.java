package techproed.tests.homework;

import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class HW02_LoginWithInvalidPassword {

    /*
    Name:
Login screen error messages
Description:
User should see error message when user tries to login with incorrect credentials
Acceptance Criteria:
As admin or customer, I should be able to see error message,
when I provide a correct email address BUT incorrect password in a pop up window
Error Message: Bad credentials
https://www.bluerentalcars.com/
     */
    /*
    Given
         Go to https://www.bluerentalcars.com/
    When
        Click on login
    And
        Type in valid email "jack@gmail.com"
    And
       Type in invalid password "abcd"
    And
       Click on login button
    Then
       Verify Error Message: Bad credentials
     */

    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void loginWithInvalidPassword(){
        // Go to https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        // Click on login
        homePage= new HomePage(); // initiate
        homePage.homePageLoginButton.click();

        // Type in valid email "jack@gmail.com"
        loginPage=new LoginPage();// initiate
        loginPage.email.sendKeys("jack@gmail.com");

        // Type in invalid password "abcd"
        loginPage.password.sendKeys("abcd");

        // Click on login button
        loginPage.loginButton.click();

        // Verify Error Message: Bad credentials
        ReusableMethods.waitFor(3);
        ReusableMethods.verifyElementDisplayed(loginPage.passwordErrorMessage);

        // close driver
        Driver.closeDriver();

    }
}
