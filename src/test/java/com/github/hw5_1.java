package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

import java.nio.channels.ConnectionPendingException;

public class hw5_1 {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
//        Configuration.browser = CHROME;
    }

    @Test
    void clickHoverMenuSolution() {
        // открыть страницу /
        open("/");
        //навести в меню на пункт Solutions

        //в выпадающем меню Solutions найти элемент Enterprize и кликнуть на него
        //убедиться, что есть заголовок"Build like the best."



    }


}
