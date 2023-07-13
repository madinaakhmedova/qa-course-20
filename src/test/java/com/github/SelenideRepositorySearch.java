package com.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
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

        //ввести в поле поиска selenide и нажать enter
        $(byAttribute("data-target", "qbsearch-input.inputButton")).click();
        $("#query-builder-test").setValue("selenide").pressEnter();

        //кликнуть на первый репозиторий из списка найденных
        $(byAttribute("data-testid", "results-list")).$$("a").first().click();

        //проверка: заголовка selenide/selenide
        $("#repository-container-header").shouldHave(Condition.text("selenide / selenide"));
        sleep(5000);
    }

    @Test
    void shouldFindSoftAssertionOnTheWikiPage() {
//        Откройте страницу Selenide в Github
        open("/selenide/selenide");

//        Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

//       Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(byAttribute("data-filterable-for", "wiki-pages-filter")).shouldHave(text("SoftAssertions"));

//        Откройте страницу SoftAssertions,
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();

//        проверьте что внутри есть пример кода для JUnit5

        sleep(3000);
    }
}
