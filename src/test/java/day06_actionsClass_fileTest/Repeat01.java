package day06_actionsClass_fileTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseEach;

import java.util.Set;

public class Repeat01 extends TestBaseEach {
    // ● https://testotomasyonu.com/addremove/ adresine gidin.
    // ● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
    // ● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
    // ● ’Please click for Electronics Products’ linkine tiklayin.
    // ● Electronics sayfasinin acildigini test edin
    // ● Bulunan urun sayisinin 16 olduğunu test edin
    // ● Ilk actiginiz addremove sayfasina donun
    // ● Url’in addremove icerdigini test edin

    @Test
    public void test() {
        // ● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        // ● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement textElement = driver.findElement(By.tagName("h2"));
        String expectedYazi = "Add/Remove Elements";
        String actualYazi = textElement.getText();
        Assertions.assertEquals(expectedYazi, actualYazi);

        // ● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle = "Test Otomasyonu";
        String actaulTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actaulTitle);
        String ilkWindowWhd = driver.getWindowHandle();

        // ● ’Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.xpath("//*[.='Electronics Products']")).click();

        // ● Electronics sayfasinin acildigini test edin
        String ikinciWindowWhd = "";
        Set<String> tumWindowWHd = driver.getWindowHandles();
        for (String eachWhd : tumWindowWHd) {
            if (!eachWhd.equals(ilkWindowWhd)) {
                ikinciWindowWhd = eachWhd;
            }
        }
        driver.switchTo().window(ikinciWindowWhd);
        String expectedUrl = "https://testotomasyonu.com/category/7/products";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);

        // ● Bulunan urun sayisinin 16 olduğunu test edin
        WebElement urunSayisiElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));
        String urunSayisiElementiText = urunSayisiElementi.getText(); // 16 Products Found
        urunSayisiElementiText = urunSayisiElementiText.replaceAll("\\D", ""); // 16
        int actualSayi = Integer.parseInt(urunSayisiElementiText); // int 16
        int expectedSayi = 16;
        Assertions.assertEquals(expectedSayi, actualSayi);

        // ● Ilk actiginiz addremove sayfasina donun
        driver.switchTo().window(ilkWindowWhd);

        // ● Url’in addremove icerdigini test edin
        expectedUrl = "addremove";
        actualUrl = driver.getCurrentUrl();
        Assertions.assertTrue(actualUrl.contains(expectedUrl));
    }
}
