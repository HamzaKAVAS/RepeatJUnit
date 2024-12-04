package day05_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusabilityMethods;
import utilities.TestBaseEach;

public class C06_Actions_Context extends TestBaseEach {

    // 1- https://testotomasyonu.com/click sitesine gidin
    // 2- “DGI Drones” uzerinde sag click yapin
    // 3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
    // 4- Tamam diyerek alert’i kapatalim

    @Test
    public void test() {
        // 1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");

        // 2- “DGI Drones” uzerinde sag click yapin
        Actions actions = new Actions(driver);
        ReusabilityMethods.bekle(2);
        WebElement dgiDronesElement = driver.findElement(By.id("pic2_thumb"));
        actions.contextClick(dgiDronesElement).perform();

        // 3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        String actualAlertYazisi = driver.switchTo().alert().getText();
        String expectedAlertYazisi = "Tebrikler!... Sağ click yaptınız.";
        Assertions.assertEquals(expectedAlertYazisi, actualAlertYazisi);

        // 4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
    }
}
