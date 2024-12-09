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

public class C02_ExplicitWait {

    // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 2. Remove butonuna basin.
    // 3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    // 4. Add buttonuna basin
    // 5. It’s back mesajinin gorundugunu test edin

    WebDriver driver;

    @Test
    public void implicitlyWaitTesting() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@*='swapCheckbox()']")).click();

        // 3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneTextElement = driver.findElement(By.id("message"));
        Assertions.assertTrue(itsGoneTextElement.isDisplayed()); // it waits here because it can't locate.

        // 4. Add buttonuna basin
        driver.findElement(By.xpath("//*[@*='swapCheckbox()']")).click();

        // 5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackTextElement = driver.findElement(By.id("message"));
        Assertions.assertTrue(itsBackTextElement.isDisplayed());
        ReusabilityMethods.bekle(1);
        driver.quit();
    }

    @Test
    public void explicitlyWaitTesting() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Remove butonuna basin.
        WebElement removeAndAddButton = driver.findElement(By.xpath("//*[@*='swapCheckbox()']"));
        removeAndAddButton.click();

        // 3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGoneTextElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));
        Assertions.assertTrue(itsGoneTextElement.isDisplayed());

        // 4. Add buttonuna basin
        removeAndAddButton.click();

        // 5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackTextElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));
        Assertions.assertTrue(itsBackTextElement.isDisplayed());
        ReusabilityMethods.bekle(1);
        driver.quit();
    }
}
