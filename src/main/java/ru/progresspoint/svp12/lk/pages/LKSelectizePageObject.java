package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.pages.PageObject;

/**
 * Класс расширяющий PageObject для работы с плагином selectize
 */
public class LKSelectizePageObject extends PageObject {
    static final String DROP_DOWN_XPATH = ".//*[@id='%s']/..//input";
    static final String DROP_DOWN_ITEM_XPATH = ".//*[@class='selectize-dropdown-content']/*[text() = '%s']";

    static final String INPUT_XPATH = ".//*[@id='%s']/..//input";
    static final String INPUT_ITEM_XPATH = ".//*[@id='%s']/..//div[@class='selectize-dropdown-content']/div[2]";

    public void selectForSelectizePlugin(String selectId, String selectingValue) {
        findBy(String.format(DROP_DOWN_XPATH, selectId)).click();
        waitFor(String.format(DROP_DOWN_ITEM_XPATH, selectingValue));
        findBy(String.format(DROP_DOWN_ITEM_XPATH, selectingValue)).click();
    }

    public void enterForSelectizePlugin(String inputId, String inputtingValue) {
        enter(inputtingValue).into(findBy(String.format(INPUT_XPATH, inputId)));
        waitFor(String.format(INPUT_ITEM_XPATH, inputId));
        waitABit(500);
        findBy(String.format(INPUT_ITEM_XPATH, inputId)).click();
    }
}
