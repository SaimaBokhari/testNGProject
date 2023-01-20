package techproed.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.MedunnaHomePage;
import techproed.pages.MedunnaLoginPage;
import techproed.pages.MedunnaPatientPage;
import techproed.utilities.*;

public class MedunnaPatient {

    // User story:
    // Admin can create patients  https://medunna.com/

    /*
    Test case:
    Given
         Go to https://medunna.com/
    When
         Click on "user icon"
     And
         Click on "sign in" option
     And
         Enter username into "Username" input
     And
         Enter password into "Password" input
     And
         Click on "Remember me" checkbox
     And
         Click on "Sign in" submit button
     And
         Click on "Items&Titles" menu
     And
         Click on "Patient" option
     And
         Click on "Create a new Patient" button
     And
         Enter firstname into "First Name" input
     And
         Enter lastname into "Last Name" input
     And
         Enter email into "Email" input
     And
         Enter phone number into "Phone" input
     And
         Click on "save" button

     */


    @DataProvider
    public Object [][] medunnaCredentials(){

        String path = "./src/test/java/resources/MedunnaCredentials.xlsx";
        String sheetName = "medunna01";

        ExcelUtils excelUtils = new ExcelUtils(path, sheetName);  // create page object

        Object [][] arr = excelUtils.getDataArrayWithoutFirstRow();  // using DataProvider to get data from Excel sheet ... RECOMMENDED

//        {
//                {"john_doe11", "John.123", "Mary", "Goldsmith", "abc@gmail.com", "0123456789"},
//                {"john_doe12", "John.123", "Mary", "Goldsmith", "abc@gmail.com", "0123456789"},
//                {"john_doe13", "John.123", "Mary", "Goldsmith", "abc@gmail.com", "0123456789"},
//                {"john_doe14", "John.123", "Mary", "Goldsmith", "abc@gmail.com", "0123456789"},
//                {"john_doe15", "John.123", "Mary", "Goldsmith", "abc@gmail.com", "0123456789"}
//
//        };
        return arr;
    }


    @Test (dataProvider = "medunnaCredentials", groups = "smoke-test")
    public void createPatient(String userName, String password, String patientFN, String patientLN, String patientEmail, String patientPhone){

        //         Go to https://medunna.com/
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));

        //         Click on "user icon"
        MedunnaHomePage medunnaHomePage = new MedunnaHomePage(); // create page object
        medunnaHomePage.userIcon.click();

        //         Click on "sign in" option
        medunnaHomePage.signInOption.click();

        //         Enter username into "Username" input
        MedunnaLoginPage medunnaLoginPage = new MedunnaLoginPage(); // create page object
        medunnaLoginPage.userNameInput.sendKeys(userName);
        //         Enter password into "Password" input
        medunnaLoginPage.passwordInput.sendKeys(password);

        //         Click on "Remember me" checkbox
        medunnaLoginPage.rememberMeCheckbox.click();

        //         Click on "Sign in" submit button
        medunnaLoginPage.signInButton.click();

        //         Click on "Items&Titles" menu
        medunnaHomePage.itemsAndTitlesMenu.click();

        //         Click on "Patient" option
        medunnaHomePage.patientOption.click();

        //         Click on "Create a new Patient" button
        MedunnaPatientPage medunnaPatientPage = new MedunnaPatientPage(); // create page object
        medunnaPatientPage.createNewPatientButton.click();

        //         Enter firstname into "First Name" input
        medunnaPatientPage.patientFirstNameInput.sendKeys(patientFN);

        //         Enter lastname into "Last Name" input
        medunnaPatientPage.patientLastNameInput.sendKeys(patientLN);

        //         Enter email into "Email" input
        medunnaPatientPage.patientEmailInput.sendKeys(patientEmail);

        //         Enter phone number into "Phone" input
        medunnaPatientPage.patientPhoneInput.sendKeys(patientPhone);

        //         Click on "save" button
        //  medunnaPatientPage.saveSubmitButton.click(); // was not clickable

        JSUtils.clickElementByJS(medunnaPatientPage.saveSubmitButton);

        // close driver
        Driver.closeDriver();
    }

    // close driver
//    @AfterMethod
//    public void closeDriver(){
//        ReusableMethods.waitFor(2);
//        Driver.closeDriver();
//    }

}
