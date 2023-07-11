package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
//        Configuration.browser = CHROME;
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {

        //открыть первую страницу
        open("/");
        $(byAttribute("data-target", "qbsearch-input.inputButton")).click();
        $("#query-builder-test").setValue("Madina super");




        //ввести в поле поиска selenide и нажать enter
        //кликнуть на первый репозиторий из списка найденных
        //проверка: заголовка selenide/selenide

    }
}
