package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationTest {
    RegistrationPage registrationPage = new RegistrationPage();
    public String
            userName = "Egor",
            userLastName = "Egorov",
            userEmail = "Egor@mail.ru";

    @Test
    void successFullRegistrationTest() {
        registrationPage.openPage().
                setFullNameAndEmail(userName, userLastName, userEmail).
//        setEmail(userEmail).
//                setFirstName(userName).
//                setLastName(userLastName).
        setGender("Other").
                setPhoneNumber("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
//        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOption("2008");
// <div class="react-datepicker__day--030 react-datepicker__day--outside-month">30</div>
// <div class="react-datepicker__day--030"                                     >30</div>
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//        $x("//*[@class='react-datepicker__day--030'][not(contains(@class, 'react-datepicker__day--outside-month'))]").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text("Egorov"),
                text("alex@egorov.com"), text("1234567890"));
    }

//    void anotherSuccessFullRegistrationTest() {
//        openPage();
//        setFullNameAndEmail(userName, userLastName, userEmail);
//
//        setGender("Other");
//        $(labelMaleGender).click();
//        $(labelFemaleGender).click();
//
//        setPhoneNumber("1234567890");
//
//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOption("July");
////        $(".react-datepicker__month-select").selectOptionByValue("6");
//        $(".react-datepicker__year-select").selectOption("2008");
//// <div class="react-datepicker__day--030 react-datepicker__day--outside-month">30</div>
//// <div class="react-datepicker__day--030"                                     >30</div>
//        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
////        $x("//*[@class='react-datepicker__day--030'][not(contains(@class, 'react-datepicker__day--outside-month'))]").click();
//        $("#subjectsInput").setValue("Math").pressEnter();
//        $("#hobbiesWrapper").$(byText("Sports")).click();
//        $("#uploadPicture").uploadFromClasspath("img/1.png");
////        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
//        $("#currentAddress").setValue("Some address 1");
//        $("#state").click();
//        $("#stateCity-wrapper").$(byText("NCR")).click();
////        $("#react-select-3-option-0").click();
//        $("#city").click();
//        $("#stateCity-wrapper").$(byText("Delhi")).click();
//        $("#submit").click();
//
//        $(".modal-dialog").should(appear);
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $(".table-responsive").shouldHave(text(userName), text("Egorov"),
//                text("alex@egorov.com"), text("1234567890"));
//    }
}
