package com.github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class HomeWork52Test {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
//        Configuration.browser = CHROME;
    }


    @Test
    void clickHoverMenuSolution() {
        //открыть страницу
        open("/drag_and_drop");

        // Находим элемент, который нужно переместить (source)
        SelenideElement sourceElement = $("#column-a");

        // Находим элемент, куда нужно переместить исходный элемент (target)
        SelenideElement targetElement = $("#column-b");

        // Выполняем перемещение элемента drag and drop
        sourceElement.dragAndDropTo(targetElement);

//        способ 2
//        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
    }

}
