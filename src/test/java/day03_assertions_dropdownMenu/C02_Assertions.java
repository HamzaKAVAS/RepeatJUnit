package day03_assertions_dropdownMenu;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusabilityMethods;

import java.time.Duration;

public class C02_Assertions {

    // https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    // ○ logoTest => BestBuy logosunun görüntülendigini test edin
    // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterAll
    public static void teardown() {
        ReusabilityMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void test01() {
        // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void test02() {
        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String unexpectedTitle = "Rest";
        String actualTitle = driver.getTitle();
        Assertions.assertFalse(actualTitle.contains(unexpectedTitle));
    }

    @Test
    public void test03() {
        // ○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement bestBuyLogo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assertions.assertTrue(bestBuyLogo.isDisplayed());
    }

    @Test
    public void test04() {
        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement franciaLink = driver.findElement(By.xpath("//button[@lang='fr']"));
        Assertions.assertTrue(franciaLink.isDisplayed());
    }

}
