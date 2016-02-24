package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Страница подтверждения регистрации в АРМ ЛК
 */
@DefaultUrl("http://lk-stage.progresspoint.ru/registration/confirm")
public class LKPasswordPage extends PageObject {

    @FindBy(id = "user_password")
    WebElementFacade passwordField;

    @FindBy(id = "user_password_confirmation")
    WebElementFacade confirmPasswordField;

    public void enterPassword(String password) {
        enter(password).into(passwordField);
    }

    public void enterConfirmPassword(String password) {
        enter(password).into(confirmPasswordField);
    }
}
