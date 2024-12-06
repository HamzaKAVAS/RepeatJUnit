package day06_actionsClass_fileTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusabilityMethods;
import utilities.TestBaseEach;

public class C02_FormDoldurma extends TestBaseEach {

    // 1- https://www.testotomasyonu.com adresine gidelim
    // 2- Account linkine tiklayin
    // 3- Sign Up linkine basalim
    // 4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
    // 5- Kaydin olusturuldugunu test edin

    @Test
    public void test() {
        // 1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
        ReusabilityMethods.bekle(2);

        // 2- Account linkine tiklayin
        driver.findElement(By.xpath("(//*[@*='menu-icon-text'])[1]")).click();
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
        WebElement firstNameKutusu = driver.findElement(By.id("firstName"));
        actions.sendKeys(firstNameKutusu)
                .sendKeys("Hayri")
                .sendKeys(Keys.TAB)
                .sendKeys("KORU")
                .sendKeys(Keys.TAB)
                .sendKeys("HayriKoruu@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("123456789")
                .sendKeys(Keys.TAB)
                .sendKeys("123456789").perform();
        ReusabilityMethods.bekle(2);
        driver.findElement(By.id("btn-submit-form")).click();

        // 5- Kaydin olusturuldugunu test edin
        WebElement emailAdressKutusu = driver.findElement(By.id("email"));
        emailAdressKutusu.sendKeys("HayriKoruu@gmail.com");
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys("123456789");
        WebElement signInButton = driver.findElement(By.id("submitlogin"));
        signInButton.click();
        ReusabilityMethods.bekle(2);

        WebElement logoutButton = driver.findElement(By.xpath("//span[.='Logout']"));
        Assertions.assertTrue(logoutButton.isDisplayed());
        logoutButton.click();
    }
}
