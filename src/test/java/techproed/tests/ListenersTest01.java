package techproed.tests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.*;
/*
  Use @Listeners to create a connection between test class and the Listeners class from Utilities package.

  Use path like (techproed.utilities.Listeners.class) to tell Listeners which path to follow.

 */
@Listeners(techproed.utilities.Listeners.class)
public class ListenersTest01 {

    @Test
    public void test1(){
        System.out.println("Test case 1 PASS ");
        assertTrue(true);  // pass
    }

    @Test
    public void test2(){
        System.out.println("Test case 2 FAIL ");
        assertTrue(false); // fail
    }

    @Test
    public void test3(){
        System.out.println("Test case 3 SKIPPED ");
        throw new SkipException("Skip this test case");
    }

    @Test
    public void test4(){
        System.out.println("Test case 4 throws No Such Element Exception ");
        Driver.getDriver().get("https://techproeducation.com/");
        Driver.getDriver().findElement(By.id("abcd"));
    }

}
