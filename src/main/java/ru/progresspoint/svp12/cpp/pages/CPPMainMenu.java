package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Главное меню АРМа ЦИПП
 */
@At("#HOST")
public class CPPMainMenu extends PageObject {

    @FindBy(xpath = ".//*[@href='/wiki']")
    WebElementFacade wikiTab;

    @FindBy(xpath = ".//*[@href='/clients/new']")
    WebElementFacade registrationTab;

    @FindBy(xpath = ".//*[@href='/vehicle_devices/given_show']")
    WebElementFacade devicesTab;

    @FindBy(xpath = ".//*[@href='/payments/balance']")
    WebElementFacade paymentsTab;

    @FindBy(xpath = ".//*[@href='/route_cards']")
    WebElementFacade routeMapsTab;

    @FindBy(xpath = ".//*[@href='/appeals']")
    WebElementFacade appealsTab;

    public void clickToWikiTab() {
        wikiTab.click();
    }

    public void clickToRegistrationTab() {
        registrationTab.click();
    }

    public void clickToPaymentsTab() {
        paymentsTab.click();
    }

    public void clickToDevicesTab() {
        devicesTab.click();
    }

    public void clickToRouteMapsTab() {
        routeMapsTab.click();
    }

    public void clickToAppealsTab() {
        appealsTab.click();
    }
}