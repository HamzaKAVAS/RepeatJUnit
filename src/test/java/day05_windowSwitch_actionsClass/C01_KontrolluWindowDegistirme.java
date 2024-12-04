package day05_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.ReusabilityMethods;
import utilities.TestBaseEach;

public class C01_KontrolluWindowDegistirme extends TestBaseEach {

    // testotomasyonu sayfasına gidin
    // whd'ini kaydedin ve yazdırın
    // yeni bir tab açıp, yeni tab'da wisequarter sayfasına gidin
    // whd'ini kaydedin ve yazdırın
    // yeni bir window açarak, arabam.com sayfasına gidin
    // whd'ini kaydedin ve yazdırın
    // wisequarter'ın açık olduğu window'a donun ve url'in wisequarter içerdiğini test edin
    // testotomasyonu'nun açık olduğu window'a donun ve url'in testotomasyonu içerdiğini test edin

    @Test
    public void test() {
        // testotomasyonu sayfasına gidin
        driver.get("https://www.testotomasyonu.com");

        // whd'ini kaydedin ve yazdırın
        String testOtomasyonuWhd = driver.getWindowHandle();
        System.out.println("Testotomasyonu sitesinin window handle değeri: " + testOtomasyonuWhd);

        // yeni bir tab açıp, yeni tab'da wisequarter sayfasına gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        // whd'ini kaydedin ve yazdırın
        String wiseQuarterWhd = driver.getWindowHandle();
        System.out.println("Wisequarter sitesinin window handle değeri: " + wiseQuarterWhd);

        // yeni bir window açarak, arabam.com sayfasına gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.arabam.com");

        // whd'ini kaydedin ve yazdırın
        String arabamWhd = driver.getWindowHandle();
        System.out.println("Arabam.com sitesinin window handle değeri: " + arabamWhd);

        // wisequarter'ın açık olduğu window'a donun ve url'in wisequarter içerdiğini test edin
        driver.switchTo().window(wiseQuarterWhd);
        String expectedUrl = "wisequarter";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertTrue(actualUrl.contains(expectedUrl));

        // testotomasyonu'nun açık olduğu window'a donun ve url'in testotomasyonu içerdiğini test edin
        driver.switchTo().window(testOtomasyonuWhd);
        expectedUrl = "testotomasyonu";
        actualUrl = driver.getCurrentUrl();
        Assertions.assertTrue(actualUrl.contains(expectedUrl));
    }

}
