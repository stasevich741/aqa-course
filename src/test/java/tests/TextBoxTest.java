package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTest extends MainPage {

    @Test
    void fillFormTest() {

        open("/text-box");

        $("#userName").setValue(userName);
        $("#userEmail").setValue("Egor@egor.com");
        $("#currentAddress").setValue("Sticky Street 126, Valley Center, Finland, 075191");
        $("#permanentAddress").setValue("Domain Street 4264, Kempton, Angola, 788446");
        $("#submit").click();

        $("#output").shouldBe(Condition.visible);
        $("#output #name").shouldHave(text(userName));
        $("#output #email").shouldHave(text("Egor@egor.com"));
        // todo check addresses
    }
}
