package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import org.openqa.selenium.By;

/**
 * Страница пополнения баланса ЛС ВТС АРМа ЦИПП
 */
@At("#HOST/payments/new")
public class CPPNewPaymentPage extends PageObject {

    @FindBy(xpath = ".//*[@id='pos-terminal-amount']")
    WebElementFacade amountPaymentField;

    public void enterAmountOfNewPayment(String amountPayment) {
        enter(amountPayment).into(amountPaymentField);
    }
}