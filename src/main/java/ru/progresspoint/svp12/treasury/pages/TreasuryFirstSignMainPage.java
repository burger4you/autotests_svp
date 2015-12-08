package ru.progresspoint.svp12.treasury.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;

/**
 * Главная страница пользователя с правом первой подписи АРМа Казначейства
 */
@At("#HOST/first_signature_docs/fb")
public class TreasuryFirstSignMainPage extends PageObject {

    @FindBy(xpath = ".//h1[text()[contains(.,'sorry, but something went wrong')]]")
    WebElementFacade errorMessage;

    @WhenPageOpens
    public void loading() {
        errorMessage.shouldNotBePresent();
    }
}