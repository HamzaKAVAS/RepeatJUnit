package day01_mavenKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusabilityMethods;

import java.time.Duration;

public class C01_MavenIlkTestOtomasyonu {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        ReusabilityMethods.bekle(2);

        // phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusabilityMethods.bekle(2);

        // arama sonucunda ürün bulanabildiğini test edin
        WebElement aramaSonucText = driver.findElement(By.xpath("//span[.='4 Products Found']"));
        String expectedUrunSonuc = "4 Products Found";
        String actualUrunSonuc = aramaSonucText.getText();
        if (actualUrunSonuc.contains(expectedUrunSonuc)) {
            System.out.println("Ürün bulunabilme testi PASSED");
        } else System.out.println("Ürün bulunabilme testi FAILED");

        // ve sayfayı kapatın
        ReusabilityMethods.bekle(2);
        driver.quit();

    }
}
