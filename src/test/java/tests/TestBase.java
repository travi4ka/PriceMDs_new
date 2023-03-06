package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.MainPage;

import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static configuration.Configuration.*;

public class TestBase {

    public MainPage mainPage = new MainPage();


    @BeforeEach
    public void beforeAll() {
        Configuration.baseUrl = System.getProperty("baseUrl", BASE_URL);
        Configuration.remote = System.getProperty("remote", null);
        Configuration.browser = System.getProperty("browser", BROWSER);
        Configuration.browserSize = System.getProperty("browserSize", BROWSER_SIZE);
        Configuration.timeout = TIMEOUT;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", false));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        screenshotAs();

        WebDriverRunner.clearBrowserCache();
        Selenide.clearBrowserCookies();
        Selenide.sessionStorage().clear();
        Selenide.localStorage().clear();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] screenshotAs() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
