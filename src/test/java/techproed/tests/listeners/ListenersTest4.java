package techproed.tests.listeners;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;

public class ListenersTest4 {

    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test1(){
        Driver.getDriver().get("https://www.techproeducation.com/");

        assertTrue(false);
    }
}
