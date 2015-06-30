package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница авторизации пользователя АРМа ЦИПП
 */
@At("#HOST/sign_in")
public class CPPLoginPage extends PageObject {

    @FindBy(id = "session_login")
    WebElementFacade loginField;

    @FindBy(id = "session_password")
    WebElementFacade passwordField;

    @FindBy(name = "commit")
    WebElementFacade confirmButton;

    public void enterLogin(String login) {
        enter(login).into(loginField);
    }

    public void enterPassword(String password) {
        enter(password).into(passwordField);
    }

    public void clickConfirmButton() {
        confirmButton.click();
    }
}
