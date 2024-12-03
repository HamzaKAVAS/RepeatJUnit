package day04_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusabilityMethods;
import utilities.TestBaseEach;

public class C02_JsAlerts extends TestBaseEach {

    //       Test method'u olusturup asagidaki gorevi tamamlayin
    // 1. Test
    //    -  https://testotomasyonu.com/javascriptAlert adresine gidin
    //    -  1.alert'e tiklayin
    //    -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
    //    -  OK tusuna basip alert'i kapatin
    // 2.Test
    //    - https://testotomasyonu.com/javascriptAlert adresine gidin
    //    - 2.alert'e tiklayalim
    //    - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
    // 3.Test
    //    - https://testotomasyonu.com/javascriptAlert adresine gidin
    //    - 3.alert'e tiklayalim
    //    - Cikan prompt ekranina "Abdullah" yazdiralim
    //    - OK tusuna basarak alert'i kapatalim
    //    - Cikan sonuc yazisinin Abdullah icerdigini test edelim

    @Test
    public void jSAlertTest() {
        // 1. Test
        //    -  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //    -  1.alert'e tiklayin
        driver.findElement(By.xpath("(//*[@class='j-button'])[1]")).click();

        //    -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assertions.assertEquals(expectedAlertYazisi, actualAlertYazisi);

        //    -  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
    }

    @Test
    public void jSConfirmTest() {
        // 2.Test
        //    - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //    - 2.alert'e tiklayalim
        driver.findElement(By.xpath("(//*[@class='j-button'])[2]")).click();

        //    - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        String expectedAlertYazisi = "You clicked: Cancel";
        String actualAlertYazisi = driver.findElement(By.id("result")).getText();
        Assertions.assertEquals(expectedAlertYazisi, actualAlertYazisi);
    }

    @Test
    public void jSPromptTest() {
        // 3.Test
        //    - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //    - 3.alert'e tiklayalim
        driver.findElement(By.xpath("(//*[@class='j-button'])[3]")).click();

        //    - Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");

        //    - OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        //    - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedSonucYazisi = "Abdullah";
        String actualSonucYazisi = driver.findElement(By.id("result")).getText();
        Assertions.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));
    }
}
