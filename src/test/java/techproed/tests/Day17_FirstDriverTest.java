package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Day17_FirstDriverTest {
    @Test
    public void firstDriverTest(){

        // We don't need to extend the test class anymore .. we just call the Driver class -> Driver.getDriver()
        Driver.getDriver().get("https://www.techproeducation.com");

        // to close
        Driver.closeDriver();
    }
}
