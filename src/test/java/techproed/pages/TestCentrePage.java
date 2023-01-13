package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TestCentrePage {

    public TestCentrePage(){ //  Constructor Used to instantiate the page objects
        PageFactory.initElements(Driver.getDriver(), this);
    }
    // Use any of the 8 locators to locate the WebElements
    @FindBy(id = "exampleInputEmail1")
    public WebElement userName;

    @FindBy(id="exampleInputPassword1")
    public WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement submitButton;


}
