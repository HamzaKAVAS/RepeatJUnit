package day05_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusabilityMethods;
import utilities.TestBaseEach;

public class C05_WindowDegistirme extends TestBaseEach {

    // ● https://the-internet.herokuapp.com/windows adresine gidin.
    // sayfadaki elemental selenium linkini tıklayın
    // açılan yeni window'da büyük başlığın "Elemental Selenium" olduğunu test edin
    // ilk window'a geri dönün
    // "Opening a new window" yazısının görünür olduğunu test edin
    // Click here'a basın
    // açılan yeni window'a geçip oradaki yazının "New Window" olduğunu test edin
    // Elemental selenium'un açık olduğu window'a geçip, Tips linkinin erişilebilir olduğunu test edin


    @Test
    public void test() {
        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // sayfadaki elemental selenium linkini tıklayın
        driver.findElement(By.xpath("//*[.='Elemental Selenium']")).click();

        // açılan yeni window'da büyük başlığın "Elemental Selenium" olduğunu test edin
        ReusabilityMethods.urlIleWindowDegistirme(driver, "https://elementalselenium.com/");
        WebElement buyukBaslikElementi = driver.findElement(By.tagName("h1"));
        String expectedBaslikYazisi = "Elemental Selenium";
        String actualBaslikYazisi = buyukBaslikElementi.getText();

        // ilk window'a geri dönün
        ReusabilityMethods.titleIleWindowDegistirme(driver, "The Internet");

        // "Opening a new window" yazısının görünür olduğunu test edin
        WebElement yaziElementi = driver.findElement(By.tagName("h3"));
        String expectedYazi = "Opening a new window";
        String actualYazi = yaziElementi.getText();
        Assertions.assertEquals(expectedYazi, actualYazi);

        // Click here'a basın
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        // açılan yeni window'a geçip oradaki yazının "New Window" olduğunu test edin
        ReusabilityMethods.titleIleWindowDegistirme(driver, "New Window");
        yaziElementi = driver.findElement(By.tagName("h3"));
        expectedYazi = "New Window";
        actualYazi = yaziElementi.getText();
        Assertions.assertEquals(expectedYazi, actualYazi);

        // Elemental selenium'un açık olduğu window'a geçip, Tips linkinin erişilebilir olduğunu test edin
        ReusabilityMethods.urlIleWindowDegistirme(driver, "https://elementalselenium.com/");
        WebElement tipLinkElement = driver.findElement(By.xpath("//a[.='Tips']"));
        Assertions.assertTrue(tipLinkElement.isEnabled());
    }
}
