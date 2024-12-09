package day07_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseEach;

import java.util.Set;

public class C04_Cookies extends TestBaseEach {

    @Test
    public void testing() {
        // google'a gidelim cookies çıkarsa kabul edin
        driver.get("https://www.google.com");
        // sayfada kaç adet cookies bulunduğunu yazdırın
        Set<Cookie> tumCookieSeti = driver.manage().getCookies();
        System.out.println("Sayfadaki cookie adeti: " + tumCookieSeti.size());

        // derli toplu yazdıralım
        int sayi = 1;
        for (Cookie eachCookie : tumCookieSeti) {
            System.out.println(sayi + ". cookie: " + eachCookie);
            sayi++;
        }
        System.out.println("===================================");
        // cookie'lerin isimlerini yazdırın
        sayi = 1;
        for (Cookie eachCookie : tumCookieSeti) {
            System.out.println(sayi + ". cookie ismi: " + eachCookie.getName());
            sayi++;
        }
        // ismi OGPC olan cookie'nin değerinin 19037049-1: oldugunu test edin
        String expectedValue = "19037049-1:";
        String actualValue = driver.manage().getCookieNamed("OGPC").getValue();
        Assertions.assertEquals(expectedValue, actualValue);

        // ismi enSevdigimCookie, degeri cikolataliCookie olan bir cookie olusturup sayfaya ekleyin
        Cookie benimCookie = new Cookie("enSevdigimCookie", "cikolataliCookie");
        driver.manage().addCookie(benimCookie);
        System.out.println("===================================");
        tumCookieSeti = driver.manage().getCookies();
        sayi = 1;
        for (Cookie eachCookie : tumCookieSeti) {
            System.out.println(sayi + ". cookie: " + eachCookie);
            sayi++;
        }

        // cookie'yi ekleyebildiğimizi test edin
        Assertions.assertTrue(tumCookieSeti.contains(benimCookie));

        // ismi OGPC olan cookie'yi silin
        driver.manage().deleteCookieNamed("OGPC");
        System.out.println("===================================");
        tumCookieSeti = driver.manage().getCookies();
        sayi = 1;
        for (Cookie eachCookie : tumCookieSeti) {
            System.out.println(sayi + ". cookie: " + eachCookie);
            sayi++;
        }

        // silindiğini test edin
        boolean ogpcVarMi = false;
        for (Cookie eachCookie : tumCookieSeti) {
            if (eachCookie.getName().equals("OGPC")) {
                ogpcVarMi = true;
            }
        }
        Assertions.assertFalse(ogpcVarMi);

        System.out.println("===================================");
        // tüm cookie'leri silin
        driver.manage().deleteAllCookies();

        // ve silindiğini test edin
        tumCookieSeti = driver.manage().getCookies();
        Assertions.assertEquals(0, tumCookieSeti.size());
        System.out.println(tumCookieSeti);
    }
}
