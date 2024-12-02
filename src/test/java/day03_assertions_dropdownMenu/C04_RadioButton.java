package day03_assertions_dropdownMenu;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusabilityMethods;

import java.time.Duration;

public class C04_RadioButton {

    // a. Verilen https://testotomasyonu.com/form web sayfasına gidin.
    // b. Cinsiyet Radio button elementlerini locate edin
    // c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
    // d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

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
    public void yazidanSecimTest() {
        // a. Verilen https://testotomasyonu.com/form web sayfasına gidin.
        driver.get("https://testotomasyonu.com/form");

        // b. Cinsiyet Radio button elementlerini locate edin
        WebElement kadinButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerButton = driver.findElement(By.id("inlineRadio3"));

        WebElement erkekButtonYazisi = driver.findElement(By.xpath("//*[.='Erkek']"));

        // c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
        erkekButtonYazisi.click();

        // d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assertions.assertTrue(erkekButton.isSelected());
        Assertions.assertFalse(kadinButton.isSelected());
        Assertions.assertFalse(digerButton.isSelected());
        ReusabilityMethods.bekle(2);
    }

    @Test
    public void butondanSecimTest() {
        // a. Verilen https://testotomasyonu.com/form web sayfasına gidin.
        driver.get("https://testotomasyonu.com/form");

        // b. Cinsiyet Radio button elementlerini locate edin
        WebElement kadinButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerButton = driver.findElement(By.id("inlineRadio3"));

        // c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
        erkekButton.click();

        // d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assertions.assertTrue(erkekButton.isSelected());
        Assertions.assertFalse(kadinButton.isSelected());
        Assertions.assertFalse(digerButton.isSelected());
    }

}
