package techproed.homework;

import org.testng.annotations.Test;
import techproed.pages.TestCentrePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.*;

public class HW01 {
    /*
    HW Task:
    https://testcenter.techproeducation.com/index.php?page=form-authentication
    Login the application using page object model
     */

    @Test
    public void logIn(){
        TestCentrePage testCentrePage = new TestCentrePage();  // create the object from the page to have access to the elements located there already
        Driver.getDriver().get(ConfigReader.getProperty("testcentre_URL")); // get the URL from the ConfigReader

        testCentrePage.userName.sendKeys("techproed");
        testCentrePage.password.sendKeys("SuperSecretPassword");
        testCentrePage.submitButton.click();

        // Verify
        String expected = "Secure Area";
        assertEquals(expected,Driver.getDriver().getTitle());

    }

}
