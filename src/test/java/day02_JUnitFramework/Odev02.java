package day02_JUnitFramework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusabilityMethods;

import java.time.Duration;

public class Odev02 {

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void teardown() {
        ReusabilityMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void test01() {
        /* Exercise3... */
        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        ReusabilityMethods.bekle(2);
    }

    @Test
    public void test02() {
        // Click on  Calculater under Micro Apps
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//a[@id='calculatetest']")).click();
        ReusabilityMethods.bekle(2);
    }

    @Test
    public void test03() {
        // Type any number in the first input
        WebElement ilkYazimKutusu = driver.findElement(By.id("number1"));
        ilkYazimKutusu.sendKeys("23");
        ReusabilityMethods.bekle(2);
    }

    @Test
    public void test04() {
        // Type any number in the second input
        WebElement ikinciYazimKutusu = driver.findElement(By.id("number2"));
        ikinciYazimKutusu.sendKeys("56");
        ReusabilityMethods.bekle(2);
    }

    @Test
    public void test05() {
        // Click on Calculate
        driver.findElement(By.id("calculate")).click();
        ReusabilityMethods.bekle(2);
    }

    @Test
    public void test06() {
        // Get the result and print the result
        WebElement result = driver.findElement(By.id("answer"));
        System.out.println("Result: " + result.getText());
    }

}
