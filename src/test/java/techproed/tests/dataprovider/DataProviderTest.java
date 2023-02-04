package techproed.tests.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class DataProviderTest {

    @DataProvider
    public Object[][] urunler(){
        String urunListesi[][]={
                {"tesla"},
                {"bmw"},
                {"mercedes"},
                {"honda"},
                {"toyota"}
        };
        return urunListesi;
    }

    @Test(dataProvider = "urunler")
    public void aramaTesti(String data){
        System.out.println(data);
    }
    @Test(dataProvider = "urunler")
    public void googleArama(String data){
        Driver.getDriver().get("https://www.google.com");
        Driver.getDriver().findElement(By.name("q")).sendKeys(data+ Keys.ENTER);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(data));
        Driver.closeDriver();
    }
}