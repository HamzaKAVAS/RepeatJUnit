package day03_assertions_dropdownMenu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusabilityMethods;

import java.time.Duration;

public class C03_CheckBoxTest {

    // a. Verilen https://testotomasyonu.com/form web sayfasına gidin.
    // b. Sirt Agrisi ve Carpinti checkbox’larini secin
    // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
    // d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown() {
        ReusabilityMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void test() {
        // a. Verilen https://testotomasyonu.com/form web sayfasına gidin.
        driver.get("https://testotomasyonu.com/form");

        // b. Sirt Agrisi ve Carpinti checkbox’larini secin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement sirtAgrisiCheckBox = driver.findElement(By.id("gridCheck5"));
        sirtAgrisiCheckBox.click();
        WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));
        carpintiCheckBox.click();
        ReusabilityMethods.bekle(2);

        // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        Assertions.assertTrue(sirtAgrisiCheckBox.isSelected());
        Assertions.assertTrue(carpintiCheckBox.isSelected());

        // d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement sekerCheckBox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckBox = driver.findElement(By.id("hastalikCheck7"));

        Assertions.assertFalse(sekerCheckBox.isSelected());
        Assertions.assertFalse(epilepsiCheckBox.isSelected());
    }

}
