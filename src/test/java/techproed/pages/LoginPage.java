package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class LoginPage {
    public LoginPage(){ // Constructor
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "formBasicEmail")
    public WebElement email;

    @FindBy(id = "formBasicPassword")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[text()='Bad credentials']")
    public WebElement passwordErrorMessage;

    @FindBy(xpath = "//div[.='email must be a valid email']")
    public WebElement emailErrorMessage;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement incorrectEmailAndPassword_ErrorMessage;


}
