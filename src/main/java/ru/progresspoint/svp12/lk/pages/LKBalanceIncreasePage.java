package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница Пополнение баланса в Личном Кабинете
 */
@At("#HOST/client_accounts/.*/payments/new")
public class LKBalanceIncreasePage extends PageObject {

    @FindBy(name = "commit")
    WebElementFacade confirmButton;

    public void clickToConfirmButton() {
        confirmButton.click();
    }
}
