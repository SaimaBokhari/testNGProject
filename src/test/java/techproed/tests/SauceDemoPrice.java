package techproed.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.pages.SauceDemoHomePage;
import techproed.pages.SauceDemoProductsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;

import static org.testng.AssertJUnit.assertEquals;

public class SauceDemoPrice {
    /*
  Given
    Go to  https://www.saucedemo.com/
  When
    Enter the username  as "standard_user"
  And
    Enter the password as "secret_sauce"
  And
    Click on login button
  Then
    Assert that total price of all products is 129.94 dollars
  And
    Flash each web element you used
   */

    @Test(groups = "smoke-test")
    public void totalPrice(){
        // Go to  https://www.saucedemo.com/
        Driver.getDriver().get(ConfigReader.getProperty("sauce_demo_url"));
        //    Enter the username  as "standard_user"
        SauceDemoHomePage sauceDemoHomePage = new SauceDemoHomePage(); // create page object
        JSUtils.flash(sauceDemoHomePage.userName);
        sauceDemoHomePage.userName.sendKeys(ConfigReader.getProperty("sauce_demo_username"));

        //    Enter the password as "secret_sauce"
        JSUtils.flash(sauceDemoHomePage.password);
        sauceDemoHomePage.password.sendKeys(ConfigReader.getProperty("sauce_demo_password"));

        //    Click on login button
        JSUtils.flash(sauceDemoHomePage.loginButton);
        sauceDemoHomePage.loginButton.click();

        //    Assert that total price of all products is 129.94 dollars
        SauceDemoProductsPage sauceDemoProductsPage = new SauceDemoProductsPage(); // create object from products page

        double sum = 0;
        for (WebElement w : sauceDemoProductsPage.priceList){
            JSUtils.flash(w);
            sum += Double.valueOf(w.getText().replaceAll("\\$",""));
        }
        //System.out.println("sum = " + sum);

        // now assert
        assertEquals(129.94, sum);


        //    Flash each web element you used
        //  Use flash() from JSUtils class


        // Close driver
         Driver.closeDriver();


    }

}
