package day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusabilityMethods;
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
        Assertions.assertNotEquals(ilkWindowWhd, ikinciWindowWhd);

        // ● Bulunan urun sayisinin 16 olduğunu test edin
        WebElement urunSayisiElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));
        String urunSayisiElementiText = urunSayisiElementi.getText(); // 16 Products Found
        String urunSayisiElementiTextReplace = urunSayisiElementiText.replaceAll("\\D", ""); // 16
        int actualSayi = Integer.parseInt(urunSayisiElementiTextReplace); // int 16
        int expectedSayi = 16;
        Assertions.assertEquals(expectedSayi, actualSayi);

        // ● Ilk actiginiz addremove sayfasina donun
        driver.switchTo().window(ilkWindowWhd);

        // ● Url’in addremove icerdigini test edin
        String expectedUrl = "addremove";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertTrue(actualUrl.contains(expectedUrl));
    }
}
