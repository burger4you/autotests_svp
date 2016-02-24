package ru.progresspoint.svp12.smk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;

/**
 * Страница авторизации пользователя АРМа СМК
 */
@At("#HOST/sign_in")
public class SMKLoginPage extends PageObject {

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