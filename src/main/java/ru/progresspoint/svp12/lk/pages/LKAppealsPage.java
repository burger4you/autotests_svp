package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница обращений в Личном Кабинете
 */
@At("#HOST/appeals")
public class LKAppealsPage extends PageObject {

    WebElementFacade startAppealsDateField;

    WebElementFacade endAppealsDateField;

    public void enterStartAppealsDate(String startDate) {
        enter(startDate).into(startAppealsDateField);
    }

    public void enterEndAppealsDate(String endDate) {
        enter(endDate).into(endAppealsDateField);
    }
}