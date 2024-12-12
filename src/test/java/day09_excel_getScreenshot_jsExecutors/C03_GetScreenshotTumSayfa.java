package day09_excel_getScreenshot_jsExecutors;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.TestBaseEach;

import java.io.File;
import java.io.IOException;

public class C03_GetScreenshotTumSayfa extends TestBaseEach {

    // testotomasyonu anasayfaya gidin
    // phone için arama yapın
    // arama sonucunda urun bulunabildiğini test edin
    // tüm sayfanın screenshot'ini alın

    @Test
    public void testing() throws IOException {
        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone için arama yapın
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildiğini test edin
        String unExpectedItemNumbers = "0 Products Found";
        String actualItemNumbers = driver.findElement(By.className("product-count-text")).getText();
        Assertions.assertNotEquals(unExpectedItemNumbers, actualItemNumbers);

        // tüm sayfanın screenshot'ini alın
        TakesScreenshot tss = (TakesScreenshot) driver;
        File asilResim = new File("target/screenshot/tumSayfa241212_2154.jpeg");
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya, asilResim);
    }
}
