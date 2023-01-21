package techproed.tests.listeners;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;

public class ListenersTest02 {

    /*
    > without using @Listeners annotation
    > use xml file

     */
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
