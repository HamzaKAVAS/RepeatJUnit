package day03_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C01_Assertions {

    int a = 10;
    int b = 20;
    int c = 30;
    String url1 = "https:/www.testotomasyonu.com";
    String url2 = "https:/www.testotomasyonu.com/";

    @Test
    public void test01() {
        // c'nin a ile b'nin toplamına eşit olduğunu test edin
        Assertions.assertEquals(c, a + b);
        Assertions.assertTrue(c == a + b); // Her ikiside PASSED olduğundan aynıdır
    }

    @Test
    public void test02() {
        // b'nin a ile c'nin toplamına eşit olduğunu test edin
        Assertions.assertEquals(b, a + c);
        // Expected :20
        // Actual   :40
    }

    @Test
    public void test03() {
        // b'nin a ile c'nin toplamına eşit olduğunu test edin
        Assertions.assertTrue(b == a + c);
        // Expected :true
        // Actual   :false
    }

    @Test
    public void test04() {
        // url1 ile url2'nin aynı olduğunu test edin
        Assertions.assertEquals(url1, url2);
        // Expected :https:/www.testotomasyonu.com
        // Actual   :https:/www.testotomasyonu.com/
    }

    @Test
    public void test05() {
        // url1 ile url2'nin aynı olduğunu test edin
        Assertions.assertTrue(url1.equals(url2));
        // Expected :true
        // Actual   :false
    }

    @Test
    public void test06() {
        // url1'in "best" kelimesi içermediğini test edin
        Assertions.assertFalse(url1.contains("best"));
    }

}
