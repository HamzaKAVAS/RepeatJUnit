package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public static void tumSayfaScreenshotIsimli(WebDriver driver, String raporIsmi) {
        // 1.adım tss objesi oluşturalım
        TakesScreenshot tss = (TakesScreenshot) driver;
        // 2.adım resmi kaydedeceğimiz File'i oluşturalım
        File asilResim = new File("target/screenshots/" + raporIsmi + ".jpeg");
        // 3.adım screenshot alıp geçici bir dosya olarak kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        // 4.adım gecici dosyayı asıl dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi kaydedilemedi");
        }
    }

    public static void tumSayfaScreenshotTarihli(WebDriver driver) {
        // önce tarih etiketi oluşturalım
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyMMdd_HHmmss");
        String tarihEtiketi = ldt.format(format1);

        // 1.adım tss objesi oluşturalım
        TakesScreenshot tss = (TakesScreenshot) driver;
        // 2.adım resmi kaydedeceğimiz File'i oluşturalım
        File asilResim = new File("target/screenshots/TumSayfaSS" + tarihEtiketi + ".jpeg");
        // 3.adım screenshot alıp geçici bir dosya olarak kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        // 4.adım gecici dosyayı asıl dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi kaydedilemedi");
        }
    }

    public static void tumSayfaScreenshotIsimveTarihli(WebDriver driver, String isim) {
        // önce tarih etiketi oluşturalım
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyMMdd_HHmmss");
        String tarihEtiketi = ldt.format(format1);

        // 1.adım tss objesi oluşturalım
        TakesScreenshot tss = (TakesScreenshot) driver;
        // 2.adım resmi kaydedeceğimiz File'i oluşturalım
        File asilResim = new File("target/screenshots/" + isim + tarihEtiketi + ".jpeg");
        // 3.adım screenshot alıp geçici bir dosya olarak kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        // 4.adım gecici dosyayı asıl dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi kaydedilemedi");
        }
    }

    public static void webElementScreenshotIsimli(WebElement targetElement, String raporismi) {
        // 1.adim screenshot alacagimiz webelementi locate edip kaydedelim
        //        biz yukarda Logout butonunu locate ettik
        // 2.adim resmi kaydedecegimiz File'i olusturalim
        File asilResim = new File("target/screenshots/" + raporismi + ".jpeg");
        // 3.adim webElement'i kullanarak screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = targetElement.getScreenshotAs(OutputType.FILE);
        // 4.adim gecici dosyayi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Fotograf cekilemedi");
        }
    }

    public static void webElementScreenshotTarihli(WebElement targetElement) {

        // once tarih etiketi olusturalim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyMMdd_HHmmss");
        String tarihEtiketi = ldt.format(format1);


        // 1.adim screenshot alacagimiz webelementi locate edip kaydedelim
        //        biz yukarda Logout butonunu locate ettik
        // 2.adim resmi kaydedecegimiz File'i olusturalim
        File asilResim = new File("target/screenshots/Webelement" + tarihEtiketi + ".jpeg");
        // 3.adim webElement'i kullanarak screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = targetElement.getScreenshotAs(OutputType.FILE);
        // 4.adim gecici dosyayi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Fotograf cekilemedi");
        }
    }

    public static void webElementScreenshotTarihVeIsimli(WebElement targetElement, String raporIsmi) {

        // once tarih etiketi olusturalim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyMMdd_HHmmss");
        String tarihEtiketi = ldt.format(format1);

        // 1.adim screenshot alacagimiz webelementi locate edip kaydedelim
        //        biz yukarda Logout butonunu locate ettik
        // 2.adim resmi kaydedecegimiz File'i olusturalim
        File asilResim = new File("target/screenshots/" + raporIsmi + "_" + tarihEtiketi + ".jpeg");
        // 3.adim webElement'i kullanarak screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = targetElement.getScreenshotAs(OutputType.FILE);
        // 4.adim gecici dosyayi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Fotograf cekilemedi");
        }
    }

}
