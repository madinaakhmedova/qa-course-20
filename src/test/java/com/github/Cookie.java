package com.github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class Cookie {
    @Test
    void closeCookiePopup(){
        open("https://www.otpbank.ru/");
    }
}
