package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {
    public OpenSourcePage(){  // Constructor Used to instantiate the page objects

        PageFactory.initElements(Driver.getDriver(),this);

    }
    // same as WebElement userName = driver.findElement(By.name("username)); // TRADITIONAL
    // Use any of the 8 locator
    @FindBy(name = "username")
    public WebElement userName;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;




}
