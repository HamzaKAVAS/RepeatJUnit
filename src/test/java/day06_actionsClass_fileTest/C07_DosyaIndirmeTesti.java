package day06_actionsClass_fileTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusabilityMethods;
import utilities.TestBaseEach;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_DosyaIndirmeTesti extends TestBaseEach {

    // 1. https://the-internet.herokuapp.com/download adresine gidelim.
    // 2. Harish_Java.pdf dosyasını indirelim
    // 3. Dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void test(){
        // 1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        // 2. Harish_Java.pdf dosyasını indirelim
        driver.findElement(By.xpath("//*[.='Harish_Java.pdf']")).click();
        ReusabilityMethods.bekle(5);

        // 3. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dinamikDosyaYolu = System.getProperty("user.home") + "\\Downloads\\Harish_Java.pdf";
        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
