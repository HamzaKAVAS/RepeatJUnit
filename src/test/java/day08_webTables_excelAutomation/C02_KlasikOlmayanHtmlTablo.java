package day08_webTables_excelAutomation;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusabilityMethods;
import utilities.TestBaseEach;

import java.util.List;

public class C02_KlasikOlmayanHtmlTablo extends TestBaseEach {

    // 1. “https://testotomasyonu.com/webtables2” sayfasina gidin
    // 2. Headers da bulunan basliklari yazdirin
    // 3. 3.sutunun basligini yazdirin
    // 4. Tablodaki tum datalari yazdirin
    // 5. Tabloda kac tane cell (data) oldugunu yazdirin
    // 6. Tablodaki satir sayisini yazdirin
    // 7. Tablodaki sutun sayisini yazdirin
    // 8. Tablodaki 3.kolonu yazdirin
    // 9. Bir method olusturun, Test method'undan satir ve sutun verildiginde datayi döndürsün
    // 10. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin

    @Test
    public void testing() {
        // 1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//div[@role='hdata']"));
        System.out.println("Basliklar Listesi: " + ReusabilityMethods.stringListeyeDonustur(baslikElementleriList));

        // 3. 3.sutunun basligini yazdirin
        System.out.println("3.sütunun başlığı: " + baslikElementleriList.get(2).getText());

        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> tumBodyElementleri = driver.findElements(By.xpath("//div[@role='trow']"));
        System.out.println("Tüm body: " + ReusabilityMethods.stringListeyeDonustur(tumBodyElementleri));

        // 5. Tabloda kac tane cell (data) oldugunu yazdirin
        List<WebElement> tumCell = driver.findElements(By.xpath("//*[@*='trow']/*[@*='tdata']"));
        System.out.println("Tablodaki cell(data) sayısı: " + tumCell.size());

        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//*[@role='trow']"));
        System.out.println("Tablodaki satır sayısı: " + satirElementleriList.size());

        // 7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sütun sayısı: " + baslikElementleriList.size());

        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuKolonElementleri = driver.findElements(By.xpath("//div[@role='trow']/div[@role='tdata'][3]"));
        System.out.println("Üçüncü kolon elementleri: " + ReusabilityMethods.stringListeyeDonustur(ucuncuKolonElementleri));

        // 9. Bir method olusturun, Test method'undan satir ve sutun verildiginde datayi döndürsün
        System.out.println(getHucreData(1, 1)); // DELL Core I3 11th Gen
        System.out.println(getHucreData(2, 2)); // Electronics
        System.out.println(getHucreData(3, 4)); // Go

        // 10. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
        for (int i = 1; i <= satirElementleriList.size(); i++) {
            String satirdakiCategoryDegeri = getHucreData(i, 2);
            String satirdakiUrunFiyati = getHucreData(i, 3);
            if (satirdakiCategoryDegeri.equalsIgnoreCase("Furniture")) {
                System.out.println(satirdakiUrunFiyati);
            }
        }
    }

    public String getHucreData(int satirNo, int sutunNo) {
        // //*[@role='trow'][2] /div[@role='tdata'][2]
        String dinamikXpath = "//*[@role='trow'][" + satirNo + "] /div[@role='tdata'][" + sutunNo + "]";
        WebElement hedefHucreElement = driver.findElement(By.xpath(dinamikXpath));
        return hedefHucreElement.getText();
    }
}
