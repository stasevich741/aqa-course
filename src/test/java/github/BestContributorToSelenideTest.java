package github;


import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenideTest {
    @Test
    @DisplayName("solntsev should be the best contributor")
    void solntsevShouldBeTheBestContributor() {
        // open page
        open("https://github.com/selenide/selenide");

        // click on first contributor
        $("img.avatar.circle").click();
        // подвести мышь к первому аватару из блока contributors
        $(".BorderGrid").$(Selectors.byText("Contributors"))
                .ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();
        // проверка: в окне есть текст Andrei Solntsev
        $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
    }
}
