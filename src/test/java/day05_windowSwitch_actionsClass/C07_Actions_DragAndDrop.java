package day05_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusabilityMethods;
import utilities.TestBaseEach;

public class C07_Actions_DragAndDrop extends TestBaseEach {

    // 1- https://testotomasyonu.com/droppable adresine gidelim
    // 2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
    // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
    // 4- Sayfayi yenileyin
    // 5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
    // 6- “Drop Here” yazisinin degismedigini test edin

    @Test
    public void test() {
        // 1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        // 2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        ReusabilityMethods.bekle(1);
        WebElement acceptableButtonElementi = driver.findElement(By.id("draggable2"));
        WebElement dropHereKutusuElementi = driver.findElement(By.id("droppable2"));
        actions.dragAndDrop(acceptableButtonElementi, dropHereKutusuElementi).perform();

        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedYazisi = driver.findElement(By.id("droppable2"));
        String expectedYazi = "Dropped!";
        String actualYazi = droppedYazisi.getText();
        Assertions.assertEquals(expectedYazi, actualYazi);

        // 4- Sayfayi yenileyin
        driver.navigate().refresh();
        ReusabilityMethods.bekle(1);

        // 5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptableButtonElementi = driver.findElement(By.id("draggable-nonvalid2"));
        dropHereKutusuElementi = driver.findElement(By.id("droppable2"));
        actions.dragAndDrop(notAcceptableButtonElementi, dropHereKutusuElementi).perform();
        ReusabilityMethods.bekle(1);

        // 6- “Drop Here” yazisinin degismedigini test edin
        droppedYazisi = driver.findElement(By.id("droppable2"));
        expectedYazi = "Drop Here";
        actualYazi = droppedYazisi.getText();
        Assertions.assertEquals(expectedYazi, actualYazi);
    }
}
