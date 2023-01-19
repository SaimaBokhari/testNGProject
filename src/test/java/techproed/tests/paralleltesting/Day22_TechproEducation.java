package techproed.tests.paralleltesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class Day22_TechproEducation {

    @Test
    public void lmsPageNavigation() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.techproeducation.com");
        Thread.sleep(2000);
        driver.findElement(By.linkText("LMS LOGIN")).click();
        Thread.sleep(2000);
        boolean isDisplayed = driver.findElement(By.xpath("//span[.='Login/Register']")).isDisplayed();
        assertTrue(isDisplayed);
        driver.quit();
    }
}
