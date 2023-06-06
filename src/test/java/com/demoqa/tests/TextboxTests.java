package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextboxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = CHROME;
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successTest() {
        open("/text-box");

        $("#userName").setValue("Alex Egorov");
        $("#userEmail").setValue("alex@egorov.com");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Another some address 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("Alex Egorov"));
        $("#output #email").shouldHave(text("Email:alex@egorov.com"));
        $("#output #currentAddress").shouldHave(text("Current Address :Some address 1"));
        $("#output #permanentAddress").shouldHave(text("Permananet Address :Another some address 1"));

    }
}
