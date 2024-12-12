package day09_excel_getScreenshot_jsExecutors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    // 1) Adimlari takip ederek Sayfa1’e kadar gidelim
    // 2) 1.satır 5.hucreye yeni bir cell olusturalim
    // 3) Olusturdugumuz hucreye “Nufus” yazdiralim
    // 4) 2.satir nufus kolonuna 1500000 yazdiralim
    // 5) 10.satir nufus kolonuna 250000 yazdiralim
    // 6) 15.satir nufus kolonuna 54000 yazdiralim
    // 7) boş olan ilk satıra ingilizce ülke ismi JavaRepublic ingilizce başkent olarak Selenium yazdıralım
    // 8) Dosyayi kaydedelim
    // 9) Dosyayi kapatalim

    @Test
    public void testing() throws IOException {
        // 1) Adimlari takip ederek Sayfa1’e kadar gidelim
        String dosyaYolu = "src/test/java/day08_webTables_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // 2) 1.satır 5.hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(4);

        // 3) Olusturdugumuz hucreye “Nufus” yazdiralim
        sayfa1.getRow(0).getCell(4).setCellValue("Nufus");

        // 4) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).createCell(4).setCellValue("1.500.000");

        // 5) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).createCell(4).setCellValue("250.000");

        // 6) 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).createCell(4).setCellValue("54.000");

        // 7) boş olan ilk satıra ingilizce ülke ismi JavaRepublic ingilizce başkent olarak Selenium yazdıralım
        int ilkBosSatirIndex = sayfa1.getLastRowNum() + 1;
        sayfa1.createRow(ilkBosSatirIndex);
        sayfa1.getRow(ilkBosSatirIndex).createCell(0).setCellValue("JAVAREPUBLIC");
        sayfa1.getRow(ilkBosSatirIndex).createCell(1).setCellValue("SELENIUM");

        // 8) Dosyayi kaydedelim
        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);
        workbook.write(fileOutputStream);

        // 9) Dosyayi kapatalim
        fileOutputStream.close();
        fileInputStream.close();
        workbook.close();
    }
}
