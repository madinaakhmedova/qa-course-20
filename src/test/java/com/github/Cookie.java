package com.github;

import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class Cookie {
    @Test
    void closeCookiePopup(){
        open("https://www.otpbank.ru/");
        $(Selectors.byTagAndText("strong","Закрыть")).click();
        sleep(500);
    }
}


