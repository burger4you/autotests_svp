package ru.progresspoint.svp12.tso.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Класс расширяющий PageObject для работы с терминалом ТСО
 */
public class TSOScreenObject extends PageObject {

    public void switchToEnglishKeyboard() {
        element(".//*[@id='switch_eng']").click();
    }

    public void switchToRussianKeyboard() {
        element(".//*[@id='switch_rus']").click();
    }

    public void typeFromKeyboard(String word, WebElementFacade field) {
        field.click();
        for (int i = 0; i < word.length(); i++) {
            element(String.format(".//*[@data-keyvalue='%s']", word.charAt(i))).click();
        }
    }
}