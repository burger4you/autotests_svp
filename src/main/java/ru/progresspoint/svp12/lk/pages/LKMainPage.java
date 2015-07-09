package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;

/**
 * Главная страница Личного Кабинета
 */
@At("#HOST")
public class LKMainPage extends PageObject {

    LKMainPageMenu menu;

    @FindBy(xpath = ".//*[@class='content dashboard']")
    WebElementFacade contentDashboard;

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
}
