package ru.progresspoint.svp12.rso.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;
import ru.progresspoint.svp12.cpp.pages.CPPSelectizePageObject;

/**
 * Страница поиска платежей ВТС в АРМ РСО
 */
@At("#HOST/payments/report_params")
public class RSOPaymentsPage extends CPPSelectizePageObject {

    private static final String searchField = "client_id";
    private static final String searchAccount = "account_id";

    @FindBy(xpath = ".//h1[text()[contains(.,'sorry, but something went wrong')]]")
    WebElementFacade errorMessage;

    @WhenPageOpens
    public void loading() {
        errorMessage.expect("Простите, но что-то пошло не так...").shouldNotBePresent();
    }

    public void enterSearchQuery(String query) {
        enterForSelectizePlugin(searchField, query);
    }

    public void enterSearchAccount(String account) {
        enterForSelectizePlugin(searchAccount, account);
    }
}