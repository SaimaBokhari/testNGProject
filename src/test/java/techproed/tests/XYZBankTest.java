package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.XYZBankCustomerPage;
import techproed.pages.XYZBankHomePage;
import techproed.pages.XYZBankManagerPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class XYZBankTest {
    /* Open 5 new Accounts, deposit 100 USD and withdraw 100 USD from
     any account and delete all accounts you created.
     https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
     */

    /*
    Given
    Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
When
    Click on "Bank Manager Login" button
And
    Click on "Add Customer" button
And
    Fill inputs and click on "Add Customer" submit button
And
    Accept alert
And
    Add 4 more customers
And
    Click on "Open Account"  button
And
    Click on "Customer" dropdown
And
    Select customer name
And
    Click on "Currency" dropdown
And
    Select "Dollar"
And
    Click on "Process" button
And
    Accept alert
And
    Open 4 more accounts
And
    Click on "Customers" button
And
    Count table number of rows
Then
    Assert that you created 5 customers
When
    Click on "Home" button
And
    Click on "Customer Login" button
And
    Click on "Your Name" dropdown
And
    Select the any name you created
And
    Click on "Login" button
And
    Click on "Deposit" button
And
    Type 100 into "Amount to be Deposited" input
And
    Click on 'Deposit' submit
Then
    Assert that "Deposit Successful" is displayed
And
    Click on "Deposit"(Submit) button
And
    Click on "Withdrawal" button
And
    Type 100 into "Amount to be Withdrawn" input
And
    Click on "Withdraw"(Submit) button
Then
    Assert that "Transaction  Successful" is displayed
When
    Click on "Logout" button
And
    Click on "Home" button
And
    Click on "Bank Manager Login" button
And
    Click on "Customers" button
And
    Click on each "Delete" button
And
    Count table row numbers
Then
    Assert that number of customers is 0
     */

    @Test
    public void xyzBankTest(){

        //    Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        Driver.getDriver().get(ConfigReader.getProperty("xyz_bank_url"));

        //    Click on "Bank Manager Login" button
        XYZBankHomePage xyzBankHomePage = new XYZBankHomePage(); // Create object for the home page
        xyzBankHomePage.bankManagerLoginButton.click();

        //    Click on "Add Customer" button
        XYZBankManagerPage xyzBankManagerPage = new XYZBankManagerPage(); // Create object
        xyzBankManagerPage.addCustomerButton.click();

        //    Fill inputs and click on "Add Customer" submit button
        // Create Faker object first
        Faker faker = new Faker();

        for (int i=0; i<5; i++) {
            xyzBankManagerPage.firstNameInput.sendKeys(faker.name().firstName());  // ( we can also use static method from Faker (no need to create object)  => Faker.instance().name().firstName();
            xyzBankManagerPage.lastNameInput.sendKeys(faker.name().lastName());
            xyzBankManagerPage.postCodeInput.sendKeys(faker.address().zipCode());
            xyzBankManagerPage.addCustomerSubmitButton.click();

            //    Accept alert
            try {
                Driver.getDriver().switchTo().alert().accept();
            } catch (Exception ignored) {
            }
        }


        //    Add 4 more customers
        // To avoid repetition, we put it in the for loop above

        //    Click on "Open Account"  button
        xyzBankManagerPage.openAccountButton.click();

        //    Click on "Customer" dropdown
        //    Select customer name
        Select select1 = new Select(xyzBankManagerPage.customerDropdown);
        Select select2 = new Select(xyzBankManagerPage.currencyDropdown);

        for (int i=6; i<11;i++) { // we start from 6 coz first 5 customers are there by default
            select1.selectByIndex(i);

            //    Click on "Currency" dropdown
            //    Select "Dollar"
            select2.selectByIndex(1);

            //    Click on "Process" button
            xyzBankManagerPage.processSubmitButton.click();

            //    Accept alert
            try {
                Driver.getDriver().switchTo().alert().accept();
            } catch (Exception ignored) {
            }
        }

        //    Open 4 more accounts
        // To avoid repetition, we put the whole process in a for loop

        //    Click on "Customers" button
        xyzBankManagerPage.customersButton.click();

        //    Count table number of rows
        int numberOfRows = xyzBankManagerPage.numbOfRows.size();

        //    Assert that you created 5 customers
        assertEquals(10, numberOfRows );

        //    Click on "Home" button
        xyzBankManagerPage.homeButton.click();

        //    Click on "Customer Login" button
        xyzBankHomePage.customerLoginButton.click();

        //    Click on "Your Name" dropdown
        //    Select any name you created
        XYZBankCustomerPage xyzBankCustomerPage = new XYZBankCustomerPage(); // Create object from Customer Page
        Select select3 = new Select(xyzBankCustomerPage.yourNameDropdown);
        select3.selectByIndex(6); // First 5 customers are there by default. we need to click the one we created

        //    Click on "Login" button
        xyzBankCustomerPage.loginButton.click();

        //    Click on "Deposit" button
        xyzBankCustomerPage.depositButton.click();

        //    Type 100 into "Amount to be Deposited" input
        xyzBankCustomerPage.amountToBeDeposited.sendKeys("100");

        //    Click on 'Deposit' submit
        xyzBankCustomerPage.depositSubmitButton.click();

        //    Assert that "Deposit Successful" is displayed
        assertTrue(xyzBankCustomerPage.successMessage.isDisplayed());

        //        Click on "Withdrawal" button
        xyzBankCustomerPage.withdrawalButton.click();

//        Type 100 into "Amount to be Withdrawn" input

        ReusableMethods.waitFor(2);
        xyzBankCustomerPage.amountToBeWithdrawnInput.sendKeys("100");
        ReusableMethods.waitFor(2);

//        Click on "Withdraw"(Submit) button
        xyzBankCustomerPage.withdrawSubmitButton.click(); //==> Selenium Click is not working, so we add wait before and after click
        ReusableMethods.waitFor(2);

//        Assert that "Transaction  Successful" is displayed
        ReusableMethods.verifyElementDisplayed(xyzBankCustomerPage.transactionSuccessMessage);

//        Click on "Logout" button
        xyzBankCustomerPage.logOutButton.click();

//        Click on "Home" button
        xyzBankManagerPage.homeButton.click();

//        Click on "Bank Manager Login" button
        xyzBankHomePage.bankManagerLoginButton.click();

//        Click on "Customers" button
        xyzBankManagerPage.customersButton.click();
        //    Click on each "Delete" button
        for (WebElement w : xyzBankManagerPage.deleteButton){
            w.click();
        }

        //    Count table row numbers
        int numbOfRowsAfterDelete = xyzBankManagerPage.deleteButton.size();

        //    Assert that number of customers is 0
        assertEquals(0, numbOfRowsAfterDelete);

    }
}
