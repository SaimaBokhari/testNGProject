package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class HomePage {
    public HomePage(){  // Constructor
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Locate elements by any locators
    @FindBy(partialLinkText = "Login")  // it's got <a which means anchor/link
    public WebElement homePageLoginButton;

    @FindBy(id="dropdown-basic-button")
    public WebElement userId;
}
