package day08_webTables_excelAutomation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseEach;

import java.util.List;

public class C01_KlasikHtmlTablo extends TestBaseEach {

    // 1) "https://testotomasyonu.com/webtables" adresine gidin
    // 2) Web table tum body’sini yazdirin
    // 3) Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
    // 4) Web table’daki satir sayisinin 5 oldugunu test edin
    // 5) Tum satirlari yazdirin
    // 6) Web table’daki sutun sayisinin 4 olduğunu test edin
    // 7) 3.sutunu yazdirin
    // 8) Tablodaki basliklari yazdirin
    // 9) Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
    // 10) 4.satirdaki category degerinin "Furniture" oldugunu test edin

    @Test
    public void test() {
        // 1) "https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        // 2) Web table tum body’sini yazdirin
        WebElement tumBodyElementi = driver.findElement(By.tagName("tbody"));
        System.out.println("Tüm Body: " + tumBodyElementi.getText());
        System.out.println("=============================================================");

        // 3) Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedUrun = "Comfortable Gaming Chair";
        String actualBodyUruns = tumBodyElementi.getText();
        Assertions.assertTrue(actualBodyUruns.contains(expectedUrun));

        // 4) Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirElementList = driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirElementList.size();
        Assertions.assertEquals(expectedSatirSayisi, actualSatirSayisi);

        // 5) Tum satirlari yazdirin
        int satirNo = 1;
        for (WebElement eachElement : satirElementList) {
            System.out.println(satirNo + ".satır: " + eachElement.getText());
            satirNo++;
        }
        System.out.println("=============================================================");

        // 6) Web table’daki sutun sayisinin 4 olduğunu test edin
        List<WebElement> birinciSatirDataElementleri = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int expectedSutunSayisi = 4;
        int actualSutunSayisi = birinciSatirDataElementleri.size();
        Assertions.assertEquals(expectedSutunSayisi, actualSutunSayisi);

        // 7) 3.sutunu yazdirin
        List<WebElement> ucuncuSutunElementleri = driver.findElements(By.xpath("//tbody/tr[*]/td[3]"));
        satirNo = 1;
        for (WebElement eachElement : ucuncuSutunElementleri) {
            System.out.println(satirNo + ".satırdaki 3.sütun değeri: " + eachElement.getText());
            satirNo++;
        }
        System.out.println("=============================================================");

        // 8) Tablodaki basliklari yazdirin
        List<WebElement> tabloBasliklari = driver.findElements(By.tagName("th"));
        int baslikNo = 1;
        for (WebElement eachBaslik : tabloBasliklari) {
            System.out.println(baslikNo + ".baslık ismi: " + eachBaslik.getText());
            baslikNo++;
        }
        System.out.println("=============================================================");

        // 9) Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println(getHucreData(2, 2));
        System.out.println(getHucreData(3, 1));
        System.out.println("=============================================================");

        // 10) 4.satirdaki category degerinin "Furniture" oldugunu test edin
        String expectedCategoryDegeri = "Furniture";
        String actualCategoryDegeri = getHucreData(4, 2);
        Assertions.assertEquals(expectedCategoryDegeri, actualCategoryDegeri);
    }

    public String getHucreData(int satirNo, int sutunNo) {
        // //tbody/tr[*]/td[.]
        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";
        WebElement hedefHucreElementi = driver.findElement(By.xpath(dinamikXpath));
        return hedefHucreElementi.getText();
    }
}
