package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TestCentre_HomePage {
    public TestCentre_HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // locate the message to prove successful login
    @FindBy(xpath = "//*[contains(text(),'You logged into a secure area!')]")
    public WebElement loginMessage;
}
