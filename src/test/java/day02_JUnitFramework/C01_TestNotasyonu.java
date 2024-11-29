package day02_JUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusabilityMethods;

import java.time.Duration;

public class C01_TestNotasyonu {

    @Test
    public void Test01() {
        // Webdriver olusturup ayarları yapın
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu içerdiğini test edin
        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Testotomasyon Url Test PASSED");
        } else System.out.println("Testotomasyon Url Test FAILED");

        ReusabilityMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void Test02() {
        // Webdriver olusturup ayarları yapın
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com.tr");

        // url'in youtube içerdiğini test edin
        String expectedUrl = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Youtube Url Test PASSED");
        } else System.out.println("Youtube Url Test FAILED");

        ReusabilityMethods.bekle(2);
        driver.quit();
    }

}
