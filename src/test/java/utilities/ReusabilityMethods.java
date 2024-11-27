package utilities;

public class ReusabilityMethods {

    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep() method çalışmadı");
        }
    }
}
