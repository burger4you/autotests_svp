package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Главное меню Личного Кабинета
 */
public class LKMainMenu extends PageObject {

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

    public void clickToRouteMapsItem() {
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
