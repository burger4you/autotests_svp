package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница оплаты банковской картой
 */
@At("https://wpay.uniteller.ru/pay/")
public class UnitellerPaymentsPage extends PageObject {

    @FindBy(id = "Cvc2")
    WebElementFacade cvc2Field;

    @FindBy(id = "pay")
    WebElementFacade payButton;

    @FindBy(id = "btn_back")
    WebElementFacade comesBackButton;

    public void entersCardData(String cardData) {
        enter(cardData).into(cvc2Field);
    }

    public void clickToPayButton() {
        payButton.click();
    }

    public void clickToComesBackButton() {
        comesBackButton.click();
    }
}
