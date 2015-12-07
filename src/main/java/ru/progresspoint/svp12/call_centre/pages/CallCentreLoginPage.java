package ru.progresspoint.svp12.call_centre.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;

/**
 * Страница авторизации АРМа Колл Центра
 */
@At("#HOST/manager/sign_in")
public class CallCentreLoginPage extends PageObject {

    @FindBy(id = "session_login")
    WebElementFacade loginField;

    @FindBy(id = "session_password")
    WebElementFacade passwordField;

    @WhenPageOpens
    public void loading() {
        loginField.shouldBeEnabled();
        passwordField.shouldBeEnabled();
    }

    public void enterLogin(String login) {
        enter(login).into(loginField);
    }

    public void enterPassword(String password) {
        enter(password).into(passwordField);
    }
}
