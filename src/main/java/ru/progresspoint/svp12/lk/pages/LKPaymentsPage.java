package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница Платежи в Личном Кабинете
 */
@At("#HOST/client_accounts/.*")
public class LKPaymentsPage extends PageObject {

    @FindBy(linkText = " Пополнить счет")
    WebElementFacade addsFundsLink;

    @FindBy(linkText = "Получить счет на оплату")
    WebElementFacade getBillLink;

    @FindBy(linkText = "Включить автоплатеж")
    WebElementFacade turnInAutoPayLink;

    @FindBy(linkText = " Запросить историю")
    WebElementFacade getHistoryLink;

    @FindBy(linkText = " Печатать выписку")
    WebElementFacade printStatementLink;


    // Попап Пополнение счета
    @FindBy(xpath = ".//*[text()='Баланс:']/../p[2]")
    WebElementFacade accountBalancePopUpField;

    @FindBy(id = "payment_amount")
    WebElementFacade fundsAmountPopUpField;

    @FindBy(linkText = "Оплатить")
    WebElementFacade payPopUpLink;
    //

    public void clickToAddsFundsLink() {
        addsFundsLink.click();
    }

    public void clickToGetBillLink() {
        getBillLink.click();
    }

    public void clickToTurnInAutoPayLink() {
        turnInAutoPayLink.click();
    }

    public void clickToGetHistoryLink() {
        getHistoryLink.click();
    }

    public void clickToPrintStatementLink() {
        printStatementLink.click();
    }

    public void shouldDisplayAddFundsPopUp() {
        payPopUpLink
                .expect("Не доступна кнопка Оплатить в окне Пополнение счета")
                .shouldBeEnabled();
    }

    public void enterFundsAmount(String fundsAmount) {
        enter(fundsAmount).into(fundsAmountPopUpField);
    }

    public void clickToPayPopUpLink() {
        payPopUpLink.click();
    }

    public String getsCurrentAccountBalance() {
        return accountBalancePopUpField.getText();
    }
}
