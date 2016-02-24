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

    public void loading() {
        // при каждой загрузке страницы, дожидаемся исчезновения статусбара загрузки
        waitForAbsenceOf(".//*[@class='loader']");
        // и убеждаемся, что все пункты главного меню доступны пользователю
        mapsItem.expect("Маршрутные карты не доступны в главном меню").shouldBeEnabled();
        paymentsItem.expect("Платежи не доступны в главном меню").shouldBeEnabled();
        vehiclesItem.expect("ТС не доступны в главном меню").shouldBeEnabled();
        profileItem.expect("Профиль не доступен в главном меню").shouldBeEnabled();
        appealsItem.expect("Обращения не доступны в главном меню").shouldBeEnabled();
    }

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
