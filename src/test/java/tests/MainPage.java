package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement labelMale = $x("//label[@for='gender-radio-1']");

    public SelenideElement labelFemale = $("label[for='gender-radio-2']");

    String userName = "Egor";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        //browser window stays open after running tests
        Configuration.holdBrowserOpen = true;
    }
}
