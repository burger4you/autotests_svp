package ru.progresspoint.svp12.call_centre.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Главная страница АРМА Колл-Центра
 */
@At("#HOST")
public class CallCentreMainPage extends PageObject {

    @FindBy(xpath = ".//*[@class='abonent-services-popup-btn']")
    WebElementFacade abonentServicesPopUpButton;

    @FindBy(xpath = ".//*[@class='abonent-session-transfer-btn']")
    WebElementFacade abonentSessionTransferButton;

    @FindBy(xpath = ".//*[@class='abonent-session-close-btn']")
    WebElementFacade abonentSessionCloseButton;
}
