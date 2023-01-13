package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class XYZBankCustomerPage {

    public XYZBankCustomerPage() { // Constructor
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="userSelect")
    public WebElement yourNameDropdown;

    @FindBy(xpath="//button[.='Login']")
    public WebElement loginButton;

    @FindBy(xpath="//button[@ng-class='btnClass2']")
    public WebElement depositButton;

    @FindBy(xpath="//input[@placeholder='amount']")
    public WebElement amountToBeDeposited;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement depositSubmitButton;
    @FindBy(xpath="//span[@ng-show='message']")
    public WebElement successMessage;

    @FindBy(xpath="//button[@ng-class='btnClass3']")
    public WebElement withdrawalButton;

    @FindBy(xpath="//input[@placeholder='amount']")
    public WebElement amountToBeWithdrawnInput;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement withdrawSubmitButton;

    @FindBy(xpath="//span[.='Transaction successful']")
    public WebElement transactionSuccessMessage;

    @FindBy(xpath="//button[.='Logout']")
    public WebElement logOutButton;




}
