package day08_webTables_excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C05_ReadExcel {

    // Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin
    // 1.satirdaki 2.hucreye gidin ve yazdirin
    // 1.satirdaki 2.hucreyi bir string degiskene atayin ve degerinin “Başkent (İngilizce)” oldugunu test edin
    // 2.satir 4.cell’in afganistan’in baskenti “Kabil” oldugunu test edin
    // Ulke sayisinin 190 oldugunu test edin
    // Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin
    // Ingilizce ismi Netherland olan ulkenin baskentinin turkce Amsterdam oldugunu test edin
    // Turkce baskent isimlerinde Ankara bulundugunu test edin

    @Test
    public void testing() throws IOException {
        // Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin
        String dosyaYolu = "src/test/java/day08_webTables_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1obj = workbook.getSheet("Sayfa1");

        // 1.satirdaki 2.hucreye gidin ve yazdirin
        System.out.println("1.satır 2.sütun: " + sayfa1obj.getRow(0).getCell(1)); // Başkent (İngilizce)

        // 1.satirdaki 2.hucreyi bir string degiskene atayin ve degerinin “Başkent (İngilizce)” oldugunu test edin
        String expectedHucreDegeri = "Başkent (İngilizce)";
        String actualHucreDegeri = sayfa1obj.getRow(0).getCell(1).getStringCellValue();
        Assertions.assertEquals(expectedHucreDegeri,actualHucreDegeri);

        // 2.satir 4.cell’in afganistan’in baskenti “Kabil” oldugunu test edin
        expectedHucreDegeri = "Kabil";
        actualHucreDegeri = sayfa1obj.getRow(1).getCell(3).getStringCellValue();
        Assertions.assertEquals(expectedHucreDegeri,actualHucreDegeri);

        // Ulke sayisinin 190 oldugunu test edin
        int expectedCountryNumbers = 190;
        int actualCountryNumbers = sayfa1obj.getPhysicalNumberOfRows()-1;
        Assertions.assertEquals(expectedCountryNumbers,actualCountryNumbers);

        // Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin
        int expectedPhysicallyRowNumbers = 191;
        int actualPhysicallyRowNumbers = sayfa1obj.getPhysicalNumberOfRows();
        Assertions.assertEquals(expectedPhysicallyRowNumbers,actualPhysicallyRowNumbers);

        // Ingilizce ismi Netherland olan ulkenin baskentinin turkce Amsterdam oldugunu test edin
        String expectedNetherlandCapitol = "Amsterdam";
        String actualNetherlandCapitol = sayfa1obj.getRow(122).getCell(3).getStringCellValue();
        Assertions.assertEquals(expectedNetherlandCapitol,actualNetherlandCapitol);

        // Turkce baskent isimlerinde Ankara bulundugunu test edin
        for (int i = 0; i <= sayfa1obj.getPhysicalNumberOfRows()-1; i++) {
            String actualCapitolNames = sayfa1obj.getRow( i ).getCell(3).getStringCellValue();
            String expectedCapitolName = "Ankara";
            Assertions.assertTrue(actualCapitolNames.contains(expectedCapitolName));
        }
    }
}
