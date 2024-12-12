package day00_questions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusabilityMethods;

import java.time.Duration;

public class C02_HandleWindows {

    // ● https://testotomasyonu.com/addremove/ adresine gidin.
    // ● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
    // ● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
    // ● ’Please click for Electronics Products’ linkine tiklayin.
    // ● Electronics sayfasinin acildigini test edin
    // ● Bulunan urun sayisinin 16 olduğunu test edin
    // ● Ilk actiginiz addremove sayfasina donun
    // ● Url’in addremove icerdigini test edin

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testotomasyonu.com/addremove/");
    }

    @AfterEach
    public void teardown(){
        ReusabilityMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void testing(){
        // ● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement baslikTextElementi = driver.findElement(By.tagName("h2"));
        String expectedText = "Add/Remove Elements";
        String actualText = baslikTextElementi.getText();
        Assertions.assertEquals(expectedText,actualText);

        // ● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle);

        // ● ’Please click for Electronics Products’ linkine tiklayin.
        String ilkWindowWhd = driver.getWindowHandle();
        System.out.println("İlk window handle değeri: " + ilkWindowWhd);
        driver.findElement(By.xpath("(//*[@*='has-sub'])[1]")).click();

        // ● Electronics sayfasinin acildigini test edin
        String ikinciWindowWhd = driver.getWindowHandle();
        System.out.println("İkinci window handle değeri: " + ikinciWindowWhd);
        String expectedUrl = "https://testotomasyonu.com/category/7/products";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);

        // ● Bulunan urun sayisinin 16 olduğunu test edin
        WebElement urunSayisiTextElementi = driver.findElement(By.className("product-count-text")); // 16 Products Found
        String sayiText = urunSayisiTextElementi.getText().replaceAll("\\D",""); // 16
        int expectedUrun = 16;
        int actualUrun = Integer.parseInt(sayiText);
        Assertions.assertEquals(expectedUrun,actualUrun);

        // ● Ilk actiginiz addremove sayfasina donun
        driver.navigate().back();

        // ● Url’in addremove icerdigini test edin
        String expectedUrlIcerigi = "addremove";
        String actualUrlIcerik = driver.getCurrentUrl();
        Assertions.assertTrue(actualUrlIcerik.contains(expectedUrlIcerigi));
    }
}
