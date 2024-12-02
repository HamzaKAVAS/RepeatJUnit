package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReusabilityMethods {

    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep() method çalışmadı");
        }
    }

    public static List<String> stringListeyeDonustur(List<WebElement> webElementList ){
        List<String> tumListeStr = new ArrayList<>();
        for ( WebElement eachBaslik : webElementList ){
            tumListeStr.add(eachBaslik.getText());
        }
        return tumListeStr;
    }

}
