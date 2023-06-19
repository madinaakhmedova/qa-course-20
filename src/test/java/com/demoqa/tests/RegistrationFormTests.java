package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.browser = CHROME;
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove();$('#adplus-anchor').remove();$('footer').remove();");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("alex@egorov.com");
        $("#genterWrapper").$(byAttribute("for", "gender-radio-1")).click();
        $("#userNumber").setValue("89670495773");



        $("#subjectsContainer").find("input").setValue("english");
        $("#react-select-2-option-0").click();
        $("#subjectsContainer").find("input").setValue("sc");
        $("#react-select-2-option-0").click();
        $("#currentAddress").setValue("111");

        $("#state").find("input").setValue("NCR");
        $("#react-select-3-option-0").click();

        $("#city").find("input").setValue("Delhi");
        $("#react-select-4-option-0").click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/img/111.jpeg"));


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2000");
//
//        // <div class="react-datepicker__day--030 react-datepicker__day--outside-month">30</div>
//        // <div class="react-datepicker__day--030                                      >30</div>
        $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month)").click();


        $("#subjectsContainer").find("input").pressEnter(); // Отправляем форму нажатием Enter на поле subject


        $(".modal-body").shouldHave(text("Alex"));
        $(".modal-body").shouldHave(text("Egorov"));
        $(".modal-body").shouldHave(text("alex@egorov.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8967049577"));
        //$(".modal-body").shouldHave(text("12 June,2023"));
        $(".modal-body").shouldHave(text("Computer Science"));
        $(".modal-body").shouldHave(text("111"));
        $(".modal-body").shouldHave(text("NCR"));
        $(".modal-body").shouldHave(text("Delhi"));
        $(".modal-body").shouldHave(text("111.jpeg"));
        $(".modal-body").shouldHave(text("29 July,2000"));


        $("#subjectsContainer").find("input").pressEscape(); // Закрываем модальное окно
        $(".modal-body").shouldNotBe(visible);

    }
}
