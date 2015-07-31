package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Шапка Личного Кабинета
 */
public class LKMainHeader extends PageObject {

    WebElementFacade notificationsButton;
    WebElementFacade notificationsCounter;

    public void clickToNotificationsButton() {
        notificationsButton.click();
    }

    public String getNotificationsCounter() {
        return notificationsCounter.getText();
    }
}
