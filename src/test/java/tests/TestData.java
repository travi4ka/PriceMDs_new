package tests;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    public String aqaPreset() {
        return "AQA_" + faker.random().nextInt(1, 99) + "_";
    }

    public String getRandomEmail() {
        return aqaPreset() + faker.internet().emailAddress();
    }

    public String getRandomFirstName() {
        return aqaPreset() + faker.name().firstName();
    }

    public String getRandomLastName() {
        return aqaPreset() + faker.name().lastName();
    }

    public String getRandomFullName() {
        return aqaPreset() + faker.name().fullName();
    }
}
