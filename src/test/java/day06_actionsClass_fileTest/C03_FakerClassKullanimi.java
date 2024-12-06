package day06_actionsClass_fileTest;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class C03_FakerClassKullanimi {

    @Test
    public void test() {
        Faker faker = new Faker();
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().nameWithMiddle());
        System.out.println(faker.name().lastName());
        System.out.println(faker.name().fullName());
        System.out.println(faker.name().username());
        System.out.println("=================================");
        System.out.println(faker.internet().url());
        System.out.println(faker.internet().domainName());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().password());
        System.out.println(faker.internet().avatar());
        System.out.println("=================================");
        System.out.println(faker.address().cityName());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.address().zipCode());
        System.out.println(faker.address().city());
        System.out.println(faker.address().country());
        System.out.println(faker.address().firstName());
        System.out.println(faker.address().lastName());
        System.out.println("=================================");
        System.out.println(faker.lordOfTheRings().character());
        System.out.println(faker.harryPotter().character());
    }
}
