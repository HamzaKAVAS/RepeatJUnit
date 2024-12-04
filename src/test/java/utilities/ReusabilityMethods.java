package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusabilityMethods {

    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep() method çalışmadı");
        }
    }

    public static List<String> stringListeyeDonustur(List<WebElement> webElementList) {
        List<String> tumListeStr = new ArrayList<>();
        for (WebElement eachBaslik : webElementList) {
            tumListeStr.add(eachBaslik.getText());
        }
        return tumListeStr;
    }

    public static void urlIleWindowDegistirme(WebDriver driver, String hedefUrl) {
        Set<String> tumWindowsWhd = driver.getWindowHandles();
        for (String eachWhd : tumWindowsWhd) {
            driver.switchTo().window(eachWhd);
            if (driver.getCurrentUrl().equals(hedefUrl)) {
                break;
            }
        }
    }

    public static void titleIleWindowDegistirme(WebDriver driver, String hedefTitle) {
        Set<String> tumWindowsWhd = driver.getWindowHandles();
        for (String eachWhd : tumWindowsWhd) {
            driver.switchTo().window(eachWhd);
            if (driver.getTitle().equals(hedefTitle)) {
                break;
            }
        }
    }

}
