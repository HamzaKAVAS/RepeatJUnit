package day09_excel_getScreenshot_jsExecutors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_MapKullanimi {

    // Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin
    // Ingilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin
    // Turkce baskent isimlerinde Ankara bulundugunu test edin
    // Ülkeler excel'inde Ghana var mı test edin

    @Test
    public void test01() throws IOException {
        // Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin
        String dosyaYolu = "src/test/java/day08_webTables_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // Ingilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin
        Map<String, String> ulkelerBaskentlerMapi = new TreeMap<>();
        for (int i = 1; i <= sayfa1.getLastRowNum(); i++) {
            String ingilizceUlkeIsmi = sayfa1.getRow(i).getCell(0).getStringCellValue();
            String baskentTurkceIsmi = sayfa1.getRow(i).getCell(3).getStringCellValue();
            ulkelerBaskentlerMapi.put(ingilizceUlkeIsmi, baskentTurkceIsmi);
        }
        String expected = "Amsterdam";
        String actual = ulkelerBaskentlerMapi.get("Netherlands");
        Assertions.assertEquals(expected, actual);

        // Turkce baskent isimlerinde Ankara bulundugunu test edin
        Assertions.assertTrue(ulkelerBaskentlerMapi.containsValue("Ankara"));

        // Ülkeler excel'inde Ghana var mı test edin
        Assertions.assertTrue(ulkelerBaskentlerMapi.containsKey("Ghana"));
    }
}
