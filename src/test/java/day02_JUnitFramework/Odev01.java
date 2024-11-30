package day02_JUnitFramework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusabilityMethods;

import java.time.Duration;

public class Odev01 {

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void teardown() {
        ReusabilityMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void test() {

        // 1-https://babayigit.net/test/index.html adresine gidin
        driver.get("https://babayigit.net/test/index.html");
        ReusabilityMethods.bekle(2);

        // 2-Arama kutusuna 12 Kızgın yazıp saerch butonuna tıklayın
        WebElement aramaKutusu = driver.findElement(By.id("search"));
        aramaKutusu.sendKeys("12 Kızgın" + Keys.ENTER);
        ReusabilityMethods.bekle(2);


        // 3-Arama sonuçlarında sonuç sayısını kaydedip yazdırın
        driver.findElement(By.id("hdtb-tls")).click();
        ReusabilityMethods.bekle(2);
        WebElement sonucSayisiYazisi = driver.findElement(By.id("result-stats"));
        System.out.println("Bulunan sonuç sayısı: " + sonucSayisiYazisi.getText());

    }
}
