package ru.progresspoint.svp12.tso.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Экран личного кабинета ВТС АРМа ТСО
 */
@At("#HOST/cab/")
public class TSOCabinetPage extends PageObject {

    @FindBy(xpath = ".//*[@href='/create_mk/']")
    WebElementFacade createRouteMapButton;

    @FindBy(xpath = ".//*[@href='/mk_list/']")
    WebElementFacade payRouteMapButton;

    @FindBy(xpath = ".//*[@href='/mk_list_cancel/confirm/']")
    WebElementFacade cancelRouteMapButton;

    @FindBy(xpath = ".//*[@href='/cab/balance/confirm/']")
    WebElementFacade checkAccountBalanceButton;

    @FindBy(xpath = ".//*[@href='/cab/refill/']")
    WebElementFacade addAccountBalanceButton;

    public void loading() {
        createRouteMapButton.shouldBeEnabled();
        payRouteMapButton.shouldBeEnabled();
        cancelRouteMapButton.shouldBeEnabled();
        checkAccountBalanceButton.shouldBeEnabled();
        addAccountBalanceButton.shouldBeEnabled();
    }
}
