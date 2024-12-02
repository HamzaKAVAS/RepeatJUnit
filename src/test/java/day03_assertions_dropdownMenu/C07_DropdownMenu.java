package day03_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseEach;

import java.util.ArrayList;
import java.util.List;

public class C07_DropdownMenu extends TestBaseEach {

    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 4.Tüm dropdown değerleri(value) yazdırın
    // 5. Dropdown’un boyutunun 4 olduğunu test edin

    @Test
    public void test() {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.id("dropdown"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        System.out.println("Seçenek 1 : " + select.getFirstSelectedOption().getText()); // Option 1

        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println("Seçenek 2 : " + select.getFirstSelectedOption().getText()); // Option 2

        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println("Seçenek 1 : " + select.getFirstSelectedOption().getText()); // Option 1

        // 4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> ddmAllValue = select.getOptions();
        for (WebElement eachElement : ddmAllValue) {
            System.out.println(eachElement.getText()); // Please select an option
                                                       // Option 1
                                                       // Option 2
        }

        System.out.println(ddm.getText()); // Yukarıdakini verir yine

        List<String> ddmAllStr = new ArrayList<>();
        for (WebElement eachElement : ddmAllValue) {
            ddmAllStr.add(eachElement.getText());
        }
        System.out.println(ddmAllStr); // [Please select an option, Option 1, Option 2]

        // 5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedDropdownMenuBoyutu = 4;
        int actualDropdownMenuBoyutu = ddmAllValue.size();
        Assertions.assertEquals(expectedDropdownMenuBoyutu, actualDropdownMenuBoyutu);
        // Expected :4
        // Actual   :3
    }

}
