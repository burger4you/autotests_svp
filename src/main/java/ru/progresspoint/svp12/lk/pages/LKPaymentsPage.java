package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.thucydides.core.pages.components.HtmlTable.filterRows;

/**
 * Страница Платежи в Личном Кабинете
 */
@At("#HOST/client_accounts/.*")
public class LKPaymentsPage extends LKSelectizePageObject {

    // Управление счетом
    @FindBy(linkText = " Пополнить счет")
    WebElementFacade addsFundsLink;

    @FindBy(linkText = "Получить счет на оплату")
    WebElementFacade getBillLink;

    @FindBy(linkText = "Включить автоплатеж")
    WebElementFacade turnInAutoPayLink;

    public void clickToAddsFundsLink() {
        addsFundsLink.click();
    }

    public void clickToGetBillLink() {
        getBillLink.click();
    }

    public void clickToTurnInAutoPayLink() {
        turnInAutoPayLink.click();
    }
    //

    // Попап Пополнение счета
    @FindBy(xpath = ".//*[text()='Баланс:']/../p[2]")
    WebElementFacade accountBalancePopUpField;

    @FindBy(id = "payment_amount")
    WebElementFacade fundsAmountPopUpField;

    @FindBy(linkText = "Оплатить")
    WebElementFacade payPopUpLink;

    public void shouldBeDisplayedAddFundsPopUp() {
        waitFor("//h2[.='Пополнение счета']");
    }

    public void enterFundsAmount(String fundsAmount) {
        enter(fundsAmount).into(fundsAmountPopUpField);
    }

    public String getCurrentAccountBalance() {
        return accountBalancePopUpField.getText();
    }

    public void clickToPayPopUpLink() {
        payPopUpLink.click();
    }
    //

    // Фильтр операций
    final static String VEHICLE_GROUP_DROP_DOWN_ID = "vehicle_groups";

    @FindBy(id = "transactions_search_form_start_date")
    WebElementFacade startTransactionsDateField;

    @FindBy(id = "transactions_search_form_end_date")
    WebElementFacade endTransactionsDateField;

    final static String TRANSACTIONS_TYPE_DROP_DOWN_ID = "transactions_search_form_transaction_type";

    public void setVehicleGroupTransactions(String vehicleGroup) {
        selectForSelectizePlugin(VEHICLE_GROUP_DROP_DOWN_ID, vehicleGroup);
    }

    public void enterStartTransactionsDate(String startDate) {
        enter(startDate).into(startTransactionsDateField);
    }

    public void enterEndTransactionsDate(String endDate) {
        enter(endDate).into(endTransactionsDateField);
    }

    public void setTypeTransactions(String transactionsType) {
        selectForSelectizePlugin(TRANSACTIONS_TYPE_DROP_DOWN_ID, transactionsType);
    }
    //

    // Таблица операций
    @FindBy(xpath = ".//*[@id='transactions']/table")
    WebElement transactionsTable;

    public List<WebElement> getFilteredTransactions() {
        return filterRows(transactionsTable);
    }
    //

    // История транзакций
    @FindBy(linkText = " Запросить историю")
    WebElementFacade getHistoryLink;

    public void clickToGetHistoryLink() {
        getHistoryLink.click();
    }

    // Печать выписки
    @FindBy(linkText = " Печатать выписку")
    WebElementFacade printStatementLink;

    public void clickToPrintStatementLink() {
        printStatementLink.click();
    }
    //

    // Попап Операция
    @FindBy (xpath = ".//div[@class='modal-body']")
    WebElementFacade transactionDetailPopUp;

    @FindBy(linkText = " Закрыть")
    WebElementFacade closeTransactionDetailPopUpLink;

    public void clickToCloseTransactionDetailPopUpLink() {
        closeTransactionDetailPopUpLink.click();
    }
    //











}
