package day08_webTables_excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void testing() throws IOException {

        String dosyaYolu = "src/test/java/day08_webTables_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // 5.satir icin index==>4, 3.hucre icin index==>2 secilmelidir
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(4);
        Cell cell = row.getCell(2);
        System.out.println("5.satır 3.sütun: " + cell); // Andorra

        // Sayfa1'deki 15.satir, 2.hucrede olan bilgiyi yazdirin
        System.out.println("15.satır 2.sütun: " + workbook.getSheet("Sayfa1").getRow(14).getCell(1)); // Dhaka
        System.out.println("19.satır 3.sütun: " + workbook.getSheet("Sayfa1").getRow(18).getCell(2)); // Belize

        // son satir numarasini yazdirin
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum()); // 190 bu son satırın index'i o halde
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum() + 1); // 191

        // Kullanilan satir sayisini yazdirin
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows()); // 191
    }
}
