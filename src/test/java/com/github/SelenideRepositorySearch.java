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
//        открыть страницу Selenide в Github
        open("/selenide/selenide");

//        перейти в раздел Wiki проекта
        $("#wiki-tab").click();

//       убкдиться, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(byAttribute("data-filterable-for", "wiki-pages-filter")).shouldHave(text("SoftAssertions"));

//        отурыть страницу SoftAssertions,
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();

//        проверить, что внутри есть пример кода для JUnit5
        // что на странице есть текст `3. Using JUnit5 extend test class`
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class"));
        // что ниже этого заголовка есть элемент с тэгом <pre>
        $("#wiki-content").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """));


        sleep(3000);
    }
}
