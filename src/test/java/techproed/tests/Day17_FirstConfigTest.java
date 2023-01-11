package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Day17_FirstConfigTest {
    @Test
    public void firstConfigTest(){
       //  Driver.getDriver().get("https://www.techproeducation.com");  // used previously

        Driver.getDriver().get(ConfigReader.getProperty("url_prod_techproed"));

        // Verify the title contains TechPro Education

//        String actualTitle = Driver.getDriver().getTitle();
//         assertTrue(actualTitle.contains(ConfigReader.getProperty("app_title")));  HARD CODING

        assertEquals(ConfigReader.getProperty("app_title"), Driver.getDriver().getTitle());

    }
}
// I need to download browsers other than chrome if I'm using other browsers in properties file