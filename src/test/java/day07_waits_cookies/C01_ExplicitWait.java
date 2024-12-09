package day07_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusabilityMethods;

import java.time.Duration;

public class C01_ExplicitWait {

    // Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    // Iki metod icin de asagidaki adimlari test edin.
    // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 2. Textbox’in etkin olmadigini(enabled) dogrulayın
    // 3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    // 4. Textbox’in etkin oldugunu(enabled) dogrulayın.
    // 5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

    WebDriver driver;

    @Test
    public void implicitlyWaitTesting() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement invisibleTextBox = driver.findElement(By.xpath("//*[@*='text']"));
        Assertions.assertFalse(invisibleTextBox.isEnabled());

        // 3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[@*='swapInput()']")).click();
        ReusabilityMethods.bekle(4); // Very important substance

        // 4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        WebElement visibleTextBox = driver.findElement(By.xpath("//*[@*='text']"));
        Assertions.assertTrue(visibleTextBox.isEnabled());

        // 5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement visibleMessage = driver.findElement(By.id("message"));
        Assertions.assertTrue(visibleMessage.isDisplayed());
        ReusabilityMethods.bekle(1);
        driver.quit();
    }

    @Test
    public void explicitlyWaitTesting() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1)); // I did it on purpose.

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement invisibleTextBox = driver.findElement(By.xpath("//*[@*='text']"));
        Assertions.assertFalse(invisibleTextBox.isEnabled());

        // 3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[@*='swapInput()']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(invisibleTextBox));

        // 4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(invisibleTextBox.isEnabled());

        // 5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement visibleMessage = driver.findElement(By.id("message"));
        Assertions.assertTrue(visibleMessage.isDisplayed());
        ReusabilityMethods.bekle(1);
        driver.quit();
    }
}
