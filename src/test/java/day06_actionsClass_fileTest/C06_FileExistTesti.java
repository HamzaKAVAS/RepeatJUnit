package day06_actionsClass_fileTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C06_FileExistTesti {

    @Test
    public void test() {
        String dosyayolu = "src/test/java/day06_actionsClass_fileTest/dnm.txt";
        System.out.println(Files.exists(Paths.get(dosyayolu)));
        Assertions.assertTrue(Files.exists(Paths.get(dosyayolu)));

        // downloads klasorunde deneme.txt dosyasının var olduğunu test edin
        String downloadDosyaYolu = "C:\\Users\\Hamza\\Downloads\\dnm.txt";
        Assertions.assertTrue(Files.exists(Paths.get(downloadDosyaYolu)));

        String dinamikDosyaYolu = System.getProperty("user.home") + "\\Downloads\\deneme.txt";
        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

    }
}
