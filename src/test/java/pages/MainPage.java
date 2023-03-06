package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static configuration.Configuration.*;

public class MainPage {
    final String url = BASE_URL + "authentication/login";
    final String title = "Admin Pro Vuetify - Vue3 Typescript based Admin Dashboard Template";

    final SelenideElement emailInput = $("input#input-1");
    final SelenideElement passwordInput = $("input#input-3");
    final SelenideElement sigInButton = $(byText("Sign In"));
    final SelenideElement forgotPasswordLink = $(byText("Forgot pwd?"));
    final SelenideElement logo = $("img[src='/assets/images/logos/logo-horizontal.png']");
    final SelenideElement rememberMeCheckbox = $(byText("Remember me?")).parent().$("input#checkbox-5");
    final SelenideElement pageDescription_1 = $(byText("REDUCING HEALTHCARE COSTS AND IMPROVING OUTCOMES"));
    final SelenideElement pageDescription_2 = $(byText("For self-insured plans and their members."));
    final SelenideElement learnMoreButton = $(byText("Learn More"));

    @Step("Page is open")
    public MainPage openPage() {
        open("");
        sigInButton.shouldBe(visible);
        return this;
    }

    @Step("Check title")
    public MainPage checkTitle() {
        Assertions.assertEquals(title, title());
        return this;
    }

    @Step("Check url")
    public MainPage checkUrl() {
        Assertions.assertEquals(url, webdriver().driver().url());
        return this;
    }

    @Step("Elements on the page")
    public MainPage checkElementsOnThePage() {
        emailInput.shouldBe(editable);
        passwordInput.shouldBe(editable);
        sigInButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        logo.shouldBe(visible);
        rememberMeCheckbox.shouldBe(editable);
        pageDescription_1.shouldBe(visible);
        pageDescription_2.shouldBe(visible);
        learnMoreButton.shouldBe(visible);
        return this;
    }

    @Step("Type email")
    public MainPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Type password")
    public MainPage typePassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    @Step("Click sign in")
    public MainPage clickSignIn() {
        sigInButton.click();
        return this;
    }

    @Step("Log in as Main_Admin")
    public MainPage logInAsMainAdmin() {
        typeEmail(MAIN_ADMIN_EMAIL);
        typePassword(MAIN_ADMIN_PASSWORD);
        clickSignIn();
        return this;
    }
}
