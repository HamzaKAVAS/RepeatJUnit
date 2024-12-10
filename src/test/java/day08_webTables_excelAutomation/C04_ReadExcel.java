package day08_webTables_excelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {

    // Gerekli ayarlamalari yapip, ulkeler excel'indeki sayfa2'ye gidin
    // Kullanilan son satirin 20.satir oldugunu test edin
    // Kullanilan (bos birakilmayan) satir sayisinin 8 oldugunu test edin
    // 17.satir 5.hucredeki bilgiyi yazdirin
    // 5.satir 3.hucredeki bilgiyi yazdirin
    // 5.satir 5.hucredeki bilgiyi yazdirin

    @Test
    public void testing() throws IOException {
        // Gerekli ayarlamalari yapip, ulkeler excel'indeki sayfa2'ye gidin
        String dosyaYolu = "src/test/java/day08_webTables_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa2obj = workbook.getSheet("Sayfa2");

        // Kullanilan son satirin 20.satir oldugunu test edin
        int expectedSatirSayisi = 20;
        int actualSatirSayisi = sayfa2obj.getLastRowNum()+1;
        Assertions.assertEquals(expectedSatirSayisi,actualSatirSayisi); // PASSED

        // Kullanilan (bos birakilmayan) satir sayisinin 8 oldugunu test edin
        int expectedKullanilanSatir = 8;
        int actualKullanilanSatir = sayfa2obj.getPhysicalNumberOfRows();
        Assertions.assertEquals(expectedKullanilanSatir,actualKullanilanSatir); // PASSED

        // 17.satir 5.hucredeki bilgiyi yazdirin
        System.out.println("17.satır 5.hücre: " + workbook.getSheet("Sayfa2").getRow(16).getCell(4)); // null

        // 5.satir 3.hucredeki bilgiyi yazdirin
        System.out.println("5.satır 3.hücre: " + sayfa2obj.getRow(4).getCell(2)); //

        // 5.satir 5.hucredeki bilgiyi yazdirin
    }
}
