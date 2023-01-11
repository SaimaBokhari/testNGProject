package techproed.tests;

import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day17_OpenSourceLogIn {
//    Create a test case to logIn the https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//    using page object model

    /*
    POM:
    1. Locate the page object in the pages package
    -username
    -password
    -button
    Note: Use constructor to instantiate page objects
    2. In test class, create page object to access the objects in the page class
     */


    @Test
    public void logIn(){
        Driver.getDriver().get(ConfigReader.getProperty("open_source_URL"));  // get the URL from the ConfigReader

        OpenSourcePage openSourcePage = new OpenSourcePage();  // create the object from the page to have access to the elements located there already

        openSourcePage.userName.sendKeys(ConfigReader.getProperty("open_source_admin_userName"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("open_source_admin_password"));
        openSourcePage.submitButton.click();

        // close the driver
        Driver.closeDriver();

    }
}
