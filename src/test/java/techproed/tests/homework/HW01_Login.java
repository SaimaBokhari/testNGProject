package techproed.tests.homework;

import org.testng.annotations.Test;
import techproed.pages.TestCentrePage;
import techproed.pages.TestCentre_HomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import static org.testng.AssertJUnit.*;

public class HW01_Login {
    /*
    HW Task:
    https://testcenter.techproeducation.com/index.php?page=form-authentication
    Login the application using page object model
     */

    /*
    Given
         Go to  https://testcenter.techproeducation.com/index.php?page=form-authentication
    When
         Type 'techproed' into userName input
     And
         Type 'SuperSecretPassword' into password input
     And
         Click on submit button
     Then
         Verify user signed in
     */

    @Test
    public void logInTest(){

        // Go to  https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testcentre_URL")); // get the URL from the ConfigReader which will bring the data from configuration.properties file

        // Create Pages where we store the webElements and then create object from those pages so we can access the webElements there
        TestCentrePage testCentrePage = new TestCentrePage();  // create the object from the page to have access to the elements located there already

        // Type 'techproed' into userName input
        testCentrePage.userName.sendKeys(ConfigReader.getProperty("testcentre_userName"));

        // Type 'SuperSecretPassword' into password input
        testCentrePage.password.sendKeys(ConfigReader.getProperty("testcentre_password"));

        //  Click on submit button
        testCentrePage.submitButton.click();

        // Verify user signed in
        TestCentre_HomePage testCentreHomePage = new TestCentre_HomePage();

        // Many ways to verify
//        String expected = "Secure Area";
//        assertEquals(expected,Driver.getDriver().getTitle());

        // Create a separate Page class for HomePage
        // assertTrue(testCentreHomePage.loginMessage.isDisplayed());

        ReusableMethods.verifyElementDisplayed(testCentreHomePage.loginMessage); // Done with REUSABLE METHOD .. RECOMMENDED

        // close the driver
        Driver.closeDriver();

    }

}
