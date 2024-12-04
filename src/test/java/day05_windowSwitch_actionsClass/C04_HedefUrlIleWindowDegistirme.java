package day05_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseEach;

import java.util.Set;

public class C04_HedefUrlIleWindowDegistirme extends TestBaseEach {

    // ● https://the-internet.herokuapp.com/windows adresine gidin.
    // sayfadaki elemental selenium linkini tıklayın
    // açılan yeni window'a geçip
    // açık olan tüm window'ların whd'lerini kaydedelim
    // büyük başlığın "Elemental Selenium" olduğunu test edin

    @Test
    public void test(){
        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // sayfadaki elemental selenium linkini tıklayın
        driver.findElement(By.xpath("//*[.='Elemental Selenium']")).click();

        // açılan yeni window'a geçip
        String hedefUrl = "https://elementalselenium.com/";

        // açık olan tüm window'ların whd'lerini kaydedelim
        Set<String> tumWindowsWhd = driver.getWindowHandles();
        for ( String eachWhd : tumWindowsWhd ){
            driver.switchTo().window(eachWhd);
            if ( driver.getCurrentUrl().equals(hedefUrl) ){
                break;
            }
        }

        // büyük başlığın "Elemental Selenium" olduğunu test edin
        WebElement buyukBaslikElement = driver.findElement(By.tagName("h1"));
        String expectedBaslikYazisi = "Elemental Selenium";
        String actualBaslikYazisi = buyukBaslikElement.getText();
        Assertions.assertEquals(expectedBaslikYazisi,actualBaslikYazisi);
    }
}
