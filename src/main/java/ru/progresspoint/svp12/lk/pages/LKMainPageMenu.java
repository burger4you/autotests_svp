package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Меню на главной странице Личного Кабинета
 */
public class LKMainPageMenu extends PageObject {

    @FindBy(linkText = "Маршрутные карты")
    WebElementFacade mapsItem;

    @FindBy(linkText = "Платежи")
    WebElementFacade paymentsItem;

    @FindBy(linkText = "Транспортные средства")
    WebElementFacade vehiclesItem;

    @FindBy(linkText = "Профиль")
    WebElementFacade profileItem;

    @FindBy(linkText = "Обращения")
    WebElementFacade appealsItem;

    public void clickToMapsItem() {
        mapsItem.click();
    }

    public void clickToPaymentsItem() {
        paymentsItem.click();
    }

    public void clickToVehiclesItem() {
        vehiclesItem.click();
    }

    public void clickToProfileItem() {
        profileItem.click();
    }

    public void clickToAppealsItem() {
        appealsItem.click();
    }
}
