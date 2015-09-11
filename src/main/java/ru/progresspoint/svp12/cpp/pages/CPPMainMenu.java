package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Главное меню АРМа ЦИПП
 */
@At("#HOST")
public class CPPMainMenu extends PageObject {

    @FindBy(linkText = "Расчеты")
    WebElementFacade paymentsTab;

    public void clickToPaymentsTab() {
        paymentsTab.click();
    }
}