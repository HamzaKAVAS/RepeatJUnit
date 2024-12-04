package day05_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseEach;

import java.util.Set;

public class C03_KontrolsuzAcilanWindow extends TestBaseEach {

    // ● https://the-internet.herokuapp.com/windows adresine gidin.
    // sayfadaki elemental selenium linkini tıklayın
    // açılan yeni window'a geçip
    // büyük başlığın "Elemental Selenium" olduğunu test edin

    @Test
    public void test() {
        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkWindowWhd = driver.getWindowHandle();
        System.out.println("İlk window'un window handle değeri: " + ilkWindowWhd);

        // sayfadaki elemental selenium linkini tıklayın
        driver.findElement(By.xpath("//*[.='Elemental Selenium']")).click();

        // açılan yeni window'a geçip
        String ikinciWindowWhd = "";
        Set<String> tumWindowWhd = driver.getWindowHandles();
        for (String eachWhd : tumWindowWhd) {
            if (!eachWhd.equals(ilkWindowWhd)) {
                ikinciWindowWhd = eachWhd;
            }
        }
        driver.switchTo().window(ikinciWindowWhd);
        System.out.println("İkinci window'un window handle değeri: " + ikinciWindowWhd);

        // büyük başlığın "Elemental Selenium" olduğunu test edin
        WebElement buyukBaslikElementi = driver.findElement(By.tagName("h1"));
        String expectedBaslikYazisi = "Elemental Selenium";
        String actualBaslikYazisi = buyukBaslikElementi.getText();
        Assertions.assertEquals(expectedBaslikYazisi, actualBaslikYazisi);
    }
}
