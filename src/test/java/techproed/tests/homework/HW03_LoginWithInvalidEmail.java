package techproed.tests.homework;

import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class HW03_LoginWithInvalidEmail {
    /*
    Name:
Login screen error messages
Description:
User should see error message when an invalid email is entered
Acceptance Criteria:
As admin or customer, I should be able to see error message, when I do not provide a complete valid email address in email address box
Error Message: email must be a valid email
When I enter a valid email domain, then I should not see the error message
https://www.bluerentalcars.com/
     */
    /*
    Given
         Go to https://www.bluerentalcars.com/
    When
        Click on login
    And
        Type in invalid email "jac"
    Then
        Verify Error Message: "email must be a valid email"
    And
       Type in valid email "jack@gmail.com"

    Then
       Verify No Error Message
     */

    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void loginWithInvalidEmail(){

        // Go to https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        // Click on login
        homePage= new HomePage(); // initiate
        homePage.homePageLoginButton.click();

        // Type in invalid email "jack"
        loginPage=new LoginPage();// initiate
        loginPage.email.sendKeys("jack");
        ReusableMethods.waitFor(2);

        // Verify Error Message: "email must be a valid email"
        ReusableMethods.verifyElementDisplayed(loginPage.emailErrorMessage);
        ReusableMethods.waitFor(3);

        // Type in valid email "jack@gmail.com"
        Driver.getDriver().navigate().refresh();
        loginPage.email.sendKeys("jack@gmail.com");
        ReusableMethods.waitFor(2);

        // Verify No Error Message
        ReusableMethods.verifyElementNotDisplayed(loginPage.emailErrorMessage);

        // Close driver
        Driver.closeDriver();


    }
}
