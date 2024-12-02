package day03_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusabilityMethods;
import utilities.TestBaseEach;

import java.util.ArrayList;
import java.util.List;

public class C06_DropdownMenu extends TestBaseEach {

    // ● https://testotomasyonu.com/form adresine gidin.
    //	1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
    //	2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
    //	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
    //	4. Secilen değerleri konsolda yazdirin
    //	5. Ay dropdown menüdeki tum değerleri(value) yazdırın
    //	6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

    @Test
    public void test() {
        // ● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        //	1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        WebElement gunDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        Select selectGun = new Select(gunDdm);
        selectGun.selectByIndex(5);

        //	2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        WebElement ayDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDdm);
        selectAy.selectByValue("nisan");

        //	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yilDdm);
        selectYil.selectByVisibleText("1990");

        //	4. Secilen değerleri konsolda yazdirin
        System.out.println("Gün: " + selectGun.getFirstSelectedOption().getText()); // 5
        System.out.println("Ay: " + selectAy.getFirstSelectedOption().getText()); // Nisan
        System.out.println("Yıl: " + selectYil.getFirstSelectedOption().getText()); // 1990
        System.out.println("======================================================");

        //	5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> ayDdmOptionList = selectAy.getOptions();
        for (WebElement eachElement : ayDdmOptionList) {
            System.out.println(eachElement.getText());
        }

        // Ay dropdown menusunde "Ocak" değerinin bulunduğunu test edin
        String expectedAyIcerik = "Ocak";
        String actualAyIcerik = ayDdm.getText();
        Assertions.assertTrue(actualAyIcerik.contains(expectedAyIcerik));
        System.out.println("===========================================");
        List<String> aydropdownMenuMetinleri = ReusabilityMethods.stringListeyeDonustur(ayDdmOptionList);
        Assertions.assertTrue(aydropdownMenuMetinleri.contains("Ocak"));

        //	6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        int expectedDropdownMenuBoyut = 13;
        int actualDropdownMenuBoyut = ayDdmOptionList.size();
        Assertions.assertEquals(expectedDropdownMenuBoyut, actualDropdownMenuBoyut);
    }

}
