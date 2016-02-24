package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Шапка Личного Кабинета
 */
public class LKMainHeader extends PageObject {

    @FindBy(xpath = ".//*[text()='Баланс лицевого счета:']/span[@class='tab__value']")
    WebElementFacade accountBalanceField;

    WebElementFacade notificationsButton;
    WebElementFacade notificationsCounter;

    public String getsCurrentAccountBalance() {
        return accountBalanceField.getText();
    }

    public void clickToNotificationsButton() {
        notificationsButton.click();
    }

    public String getNotificationsCounter() {
        return notificationsCounter.getText();
    }
}
