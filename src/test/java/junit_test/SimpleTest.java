package junit_test;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SimpleTest {

    @BeforeEach
    void setUp() {
        open("https://google.com");
    }

    //    @CsvSource({
//            "Allure testops, https://qameta.io",
//            "Selenide, https://selenide.org"
//    })
    // OR!!!
    @CsvFileSource(resources = "/testData.csv")
    @ParameterizedTest(name = "url {1} must be in google search by request {0}")
    //
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void selenideShouldBeInSearchResultTest(
            String productName, String url
    ) {
        $("[name=q]").setValue(productName).pressEnter();
        $("[id=search]").shouldHave(text(url));
    }

    @Disabled
    @ValueSource(
            strings = {"Allure testops", "Selenide"}
    )
    @ParameterizedTest(name = "url {1} must be in google search by request {0}")
    //
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void searchResultsCountTest(String productName) {
        $("[name=q]").setValue(productName).pressEnter();
        $$("div[class='g']").shouldHave(CollectionCondition.sizeGreaterThan(5));
    }
}
