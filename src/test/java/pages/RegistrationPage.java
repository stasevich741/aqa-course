package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private String titleText = "Student Registration Form";
    public SelenideElement labelMaleGender = $x("//label[@for='gender-radio-1']");

    public SelenideElement labelFemaleGender = $("label[for='gender-radio-2']");

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber");

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        //browser window stays open after running tests
        Configuration.holdBrowserOpen = true;
    }

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(titleText));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFullNameAndEmail(String userName, String userLastName, String userEmail) {
        setFirstName(userName);
        setLastName(userLastName);
        setEmail(userEmail);
        return this;
    }


    public RegistrationPage setFirstName(String userName) {
        firstNameInput.setValue(userName);
        return this;
    }

    public RegistrationPage setLastName(String userLastName) {
        lastNameInput.setValue(userLastName);
        return this;
    }

    public RegistrationPage setEmail(String userEmail) {
        emailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.$(byText(phoneNumber)).click();
        return this;
    }


}
