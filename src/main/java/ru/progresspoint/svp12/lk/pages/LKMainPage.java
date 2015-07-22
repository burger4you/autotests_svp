package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

/**
 * Главная страница Личного Кабинета
 */
@DefaultUrl("http://lk-stage.progresspoint.ru")
public class LKMainPage extends PageObject {

    LKMainMenu menu;

    @FindBy(xpath = ".//*[@class='content dashboard']")
    WebElementFacade contentDashboard;

    @FindBy(xpath = ".//*[text()='Баланс лицевого счета:']/span[@class='tab__value']")
    WebElementFacade accountBalanceField;

    @WhenPageOpens
    public void loading() {
        contentDashboard.shouldBeVisible();
    }

    public void clickToMapsItemMenu() {
        menu.clickToMapsItem();
    }

    public void clickToPaymentsItemMenu() {
        menu.clickToPaymentsItem();
    }

    public void clickToVehiclesItemMenu() {
        menu.clickToVehiclesItem();
    }

    public void clickToProfileItemMenu() {
        menu.clickToProfileItem();
    }

    public void clickToAppealsItemMenu() {
        menu.clickToAppealsItem();
    }

    public String getsCurrentAccountBalance() {
        return accountBalanceField.getText();
    }
}
