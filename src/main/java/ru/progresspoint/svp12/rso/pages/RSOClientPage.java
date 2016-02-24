package ru.progresspoint.svp12.rso.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;
import ru.progresspoint.svp12.cpp.pages.CPPSelectizePageObject;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Страница просмотра ВТС в АРМ РСО
 */
@At("#HOST/clients")
public class RSOClientPage extends CPPSelectizePageObject {

    private static final String searchClientField = "client_id";
    private static final String searchAccountField = "account_id";

    @FindBy(xpath = ".//h1[text()[contains(.,'sorry, but something went wrong')]]")
    WebElementFacade errorMessage;

    @WhenPageOpens
    public void loading() {
        errorMessage.expect("Простите, но что-то пошло не так...").shouldNotBePresent();
    }

    public void enterSearchClient(String client) {
        enterForSelectizePlugin(searchClientField, client);
    }

    public void enterSearchAccount(String account) {
        enterForSelectizePlugin(searchAccountField, account);
    }

    public boolean hasClientInfo() {
        return !(withTimeoutOf(15, SECONDS).findAll(".nav-tabs").size() == 0);
    }
}