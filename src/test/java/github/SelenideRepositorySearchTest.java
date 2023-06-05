package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideRepositorySearchTest {
//    @FindBy(xpath = "//input[@name='q']")
//    @FindBy(css = "input[data-hotkey='s,/']")
//    @FindBy(name = "q")

    @Test
    @DisplayName("Should find selenium repository at the top")
    void shouldFindSeleniumRepositoryAtTheTop() {
        // open main page
        open("https://github.com");
        // inter in search field selenide and press enter
        $("input[data-hotkey='s,/']").setValue("selenide").pressEnter();
        // click first element from list
        $("ul.repo-list li a").click();
        // assert: header selenide/selenide
        $("#repository-container-header").shouldHave(Condition.text("selenide / selenide"));
    }
}
