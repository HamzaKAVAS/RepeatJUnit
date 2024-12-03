package day04_jsAlerts_iFrame;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusabilityMethods;
import utilities.TestBaseEach;

public class C01_HTML_Alerts extends TestBaseEach {

    // youtube anasayfaya gidin
    // cookies kabul edin

    @Test
    public void youtubeTest(){
        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com.tr");

        // cookies kabul edin (çıkmıyordu) bende hayalhaneme gittim :)
        WebElement aramaKutusu = driver.findElement(By.name("search_query"));
        aramaKutusu.sendKeys("Hayalhanem" + Keys.ENTER);
    }
}
