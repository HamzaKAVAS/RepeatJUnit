package day04_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseEach;

public class C03_IFrame extends TestBaseEach {

    // 1- https://testotomasyonu.com/discount adresine gidin
    // 2- Elektronics Products yazisinin gorunur olduğunu test edin
    // 3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
    // 4- Sale Up To 50% yazisinin gorunur oldugunu test edin
    // 5- Fashion bölümündeki ilk üründe "Men Slim Fit" yazının var olduğunu test ediniz

    @Test
    public void test(){
        // 1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        // 2- Elektronics Products yazisinin gorunur olduğunu test edin
        WebElement electronicsIframeElementi = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIframeElementi);
        WebElement electronicsProductYazisi = driver.findElement(By.xpath("//*[.='Electronics Products']"));
        Assertions.assertTrue(electronicsProductYazisi.isDisplayed());

        // 3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = driver.findElement(By.id("pictext1")).getText();
        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        // 4- Sale Up To 50% yazisinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();
        WebElement saleYazisi = driver.findElement(By.xpath("//*[text()='Sale Up To 50%']"));
        Assertions.assertTrue(saleYazisi.isDisplayed());

        // 5- Fashion bölümündeki ilk üründe "Men Slim Fit" yazının var olduğunu test ediniz
        WebElement fashionIframeElementi = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIframeElementi);
        String actualFashionUrunIsim = driver.findElement(By.id("pictext1")).getText();
        String expectedFashionUrunIsim = "Men Slim Fit";
        Assertions.assertTrue(actualFashionUrunIsim.contains(expectedFashionUrunIsim));

    }
}
