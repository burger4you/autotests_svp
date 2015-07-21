package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.pages.PageObject;

/**
 * Класс расширяющих PageObject для работы с плагином selectize
 */
public class LKSelectizePageObject extends PageObject {
    static final String DROP_DOWN_XPATH = ".//*[@id='%s']/..//*[@class='item']";
    static final String DROP_DOWN_ITEM_XPATH = ".//*[@class='selectize-dropdown-content']/*[contains(text(), '%s']";

    public void selectForSelectizePlugin(String selectId, String selectingValue) {
        findBy(String.format(DROP_DOWN_XPATH, selectId)).click();
        waitFor(String.format(DROP_DOWN_ITEM_XPATH, selectingValue));
        findBy(String.format(DROP_DOWN_ITEM_XPATH, selectingValue)).click();
    }
}
