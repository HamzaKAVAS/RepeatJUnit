package day07_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusabilityMethods;
import utilities.TestBaseEach;

import java.time.Duration;

public class C03_OlmayanElementiTestEtme extends TestBaseEach {

    // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 2. Remove butonuna basin.
    // 3. checkbox'ın görünür olmadığını test edin
    // 4. Add butonuna basın
    // 5. checkbox'ın görünür olduğunu test edin

    @Test
    public void testing() {
        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Remove butonuna basin.
        WebElement checkboxButonu = driver.findElement(By.id("checkbox"));
        driver.findElement(By.xpath("//*[@*='swapCheckbox()']")).click();

        // 3. checkbox'ın görünür olmadığını test edin
        try {
            checkboxButonu.click();
            Assertions.assertTrue(false, "checkbox is visible");
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }

        // 4. Add butonuna basın
        driver.findElement(By.xpath("//*[@*='swapCheckbox()']")).click();

        // 5. checkbox'ın görünür olduğunu test edin
        Assertions.assertTrue(checkboxButonu.isDisplayed());
    }
}
