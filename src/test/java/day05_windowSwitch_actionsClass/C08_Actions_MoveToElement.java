package day05_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseEach;

public class C08_Actions_MoveToElement extends TestBaseEach {

    // 1- https://www.testotomasyonu.com/ adresine gidin
    // 2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
    // 3- “Boys” linkine basin
    // 4- Acilan sayfadaki ilk urunu tiklayin
    // 4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin

    @Test
    public void test() {
        // 1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        // 2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        WebElement kidsWearElementi = driver.findElement(By.xpath("(//li[@class='has-sub'])[7]"));
        actions.moveToElement(kidsWearElementi).perform();

        // 3- “Boys” linkine basin
        driver.findElement(By.xpath("//*[.='Boys']")).click();

        // 4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("//a[@class='prod-title mb-3 ']")).click();

        // 4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        WebElement urunIsmiElementi = driver.findElement(By.xpath("//*[@*=' heading-sm mb-4']"));
        String expectedUrunIsim = "Boys Shirt White Color";
        String actualUrunIsim = urunIsmiElementi.getText();
        Assertions.assertEquals(expectedUrunIsim, actualUrunIsim);
    }
}
