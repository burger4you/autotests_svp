package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Страница авторизации пользователя в Личный Кабинет
 */
@DefaultUrl("http://lk-stage.progresspoint.ru/sign_in")
public class LKPasswordPage extends PageObject {

    WebElementFacade passwordField;

    public void enterPassword(String password) {
        enter(password).into(passwordField);
    }
}
