package day06_actionsClass_fileTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusabilityMethods;
import utilities.TestBaseEach;

public class C04_FakerIleFormDoldurma extends TestBaseEach {

    // 1- https://www.testotomasyonu.com adresine gidelim
    // 2- Account linkine tiklayin
    // 3- Sign Up linkine basalim
    // 4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
    // 5- Kaydin olusturuldugunu test edin

    @Test
    public void test(){
        // 1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        // 2- Account linkine tiklayin
        driver.findElement(By.xpath("(//*[.='Account'])[1]")).click();
        ReusabilityMethods.bekle(2);

        // 3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[@*='sign-up ']")).click();
        ReusabilityMethods.bekle(2);

        // 4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        ReusabilityMethods.bekle(2);

        // 5- Kaydin olusturuldugunu test edin
    }
}
