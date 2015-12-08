package ru.progresspoint.svp12.treasury.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;

/**
 * Главная страница пользователя с правом второй подписи АРМа Казначейства
 */
@At("#HOST/second_signature_docs/fb")
public class TreasurySecondSignMainPage extends PageObject {

    @FindBy(xpath = ".//h1[text()[contains(.,'sorry, but something went wrong')]]")
    WebElementFacade errorMessage;

    @WhenPageOpens
    public void loading() {
        errorMessage.expect("Простите, но что-то пошло не так...").shouldNotBePresent();
    }
}