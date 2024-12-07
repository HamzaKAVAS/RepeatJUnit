package day06_actionsClass_fileTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusabilityMethods;
import utilities.TestBaseEach;

public class C05_Actions extends TestBaseEach {

    // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    // 2- Hover over Me First" kutusunun ustune gelin
    // 3- Link 1" e tiklayin
    // 4- Popup mesajini yazdirin
    // 5- Popup'i tamam diyerek kapatin
    // 6- “Click and hold" kutusuna basili tutun
    // 7- “Click and hold" kutusunda cikan yaziyi yazdirin
    // 8- “Double click me" butonunu cift tiklayin ve cift tıkladığını test edin
    // 9- Çift tiklandigini test edin

    @Test
    public void test(){
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverKutusu = driver.findElement(By.xpath("(//*[@*='dropbtn'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverKutusu).perform();

        // 3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@*='list-alert'])[1]")).click();

        // 4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        // 5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // 6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHoldKutusu = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHoldKutusu).perform();
        ReusabilityMethods.bekle(2);

        // 7- “Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldKutusu.getText());

        // 8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickMeButton = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickMeButton).perform();

        // 9- Çift tiklandigini test edin
        String expectedClickAttribute = "div-double-click double";
        String actualClickAttribute = doubleClickMeButton.getAttribute("class");
        Assertions.assertEquals(expectedClickAttribute,actualClickAttribute);
    }
}
