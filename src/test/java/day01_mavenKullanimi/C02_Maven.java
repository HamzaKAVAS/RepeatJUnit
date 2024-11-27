package day01_mavenKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusabilityMethods;

import java.time.Duration;

public class C02_Maven {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // test otomasyonu sayfasına gidin
        driver.get("https://www.testotomasyonu.com");

        // phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusabilityMethods.bekle(2);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='lazy'])[1]")).click();
        ReusabilityMethods.bekle(2);

        // açılan ürün sayfasındaki ürün isminde
        // case sensitive olmadan "phone" geçtiğini test edin
        WebElement ilkUrunIsmi = driver.findElement(By.xpath("//*[.='APPLEL iPhone 13 (Starlight, 128 GB)']"));
        String expectedUrunIsimIcerik = "phone";
        String actualUrunIsimIcerik = ilkUrunIsmi.getText().toLowerCase();
        if (actualUrunIsimIcerik.contains(expectedUrunIsimIcerik)) {
            System.out.println("İlk ürün ismi testi PASSED");
        } else System.out.println("İlk ürün ismi testi FAILED");

        // sayfayı kapatın
        ReusabilityMethods.bekle(2);
        driver.quit();

    }
}
