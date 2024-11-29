package day02_JUnitFramework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusabilityMethods;

import java.time.Duration;

public class C02_SetupVeTeardownMethodlari {

    WebDriver driver;

    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void teardown() {
        ReusabilityMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void Test01() {

        setup();

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu içerdiğini test edin
        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Testotomasyonu Url Test PASSED");
        } else System.out.println("Testotomasyonu Url Test FAILED");

        teardown();

    }

}
