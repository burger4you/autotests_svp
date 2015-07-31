package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Страница учетной записи личного кабинета
 */
@DefaultUrl("http://lk-stage.progresspoint.ru")
public class LKAccountPage extends PageObject {

    WebElementFacade accountDataField;
    WebElementFacade captchaField;

    public void enterAccountData(String accountData) {
        enter(accountData).into(accountDataField);
    }

    public void selectOwnerType(String ownerType) {
    }

    public void selectOwnerCountry(String ownerCountry) {

    }

    public void enterCaptcha(String captcha) {
        enter(captcha).into(captchaField);
    }
}
