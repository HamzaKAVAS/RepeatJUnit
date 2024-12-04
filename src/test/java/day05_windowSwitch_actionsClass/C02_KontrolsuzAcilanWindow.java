package day05_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBaseEach;

import java.util.Set;

public class C02_KontrolsuzAcilanWindow extends TestBaseEach {

    // ● https://the-internet.herokuapp.com/windows adresine gidin.
    // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    // ● Click Here butonuna basın.
    // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
    // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu test edin

    @Test
    public void test() {
        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedYazi = "Opening a new window";
        String actualYazi = driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals(expectedYazi, actualYazi);

        // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedYaziBaslik = "The Internet";
        String actualYaziBaslik = driver.getTitle();
        Assertions.assertEquals(expectedYaziBaslik, actualYaziBaslik);
        String ilkWindowWhd = driver.getWindowHandle();

        // ● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        System.out.println("Açılan yeni sayfanın title: " + driver.getTitle()); // The Internet
        // Böyle olunca yeni bir sayfaya gitti ama başlık New Window değil yani window handle değerini görmek için;
        Set<String> tumWhdSeti = driver.getWindowHandles();
        System.out.println(ilkWindowWhd);
        System.out.println(tumWhdSeti);
        String ikinciWindowWhd = "";
        for (String each : tumWhdSeti) {
            if (!each.equals(ilkWindowWhd)) {
                ikinciWindowWhd = each;
            }
        }
        driver.switchTo().window(ikinciWindowWhd);
        System.out.println("Yeni sayfanın title: " + driver.getTitle());

        // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        expectedYazi = "New Window";
        actualYazi = driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals(expectedYazi, actualYazi);

        // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu test edin
        driver.switchTo().window(ilkWindowWhd);
        expectedYaziBaslik = "The Internet";
        actualYaziBaslik = driver.getTitle();
        Assertions.assertEquals(expectedYaziBaslik, actualYaziBaslik);
    }
}
