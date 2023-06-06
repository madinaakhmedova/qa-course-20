package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextboxTests {

    @Test
    void successTest() {
        open("https://demoqa.com/text-box");

        $("#userName").setValue("Alex Egorov");
        $("#userEmail").setValue("alex@egorov.com");
        $("#currentAdress").setValue("Some address 1");
        $("#permanentAdress").setValue("Another some adrdres 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("Alex Egorov"));
        $("#output #email").shouldHave(text("Some address 1"));
        $("#output #currentAdress").shouldHave(text("Another some adrdres 1"));
        $("#permanentAdress").shouldHave(text(""));

    }
}
