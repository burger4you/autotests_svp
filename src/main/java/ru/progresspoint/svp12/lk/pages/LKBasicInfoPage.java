package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Страница основной информации пользователя личного кабинета
 */
@DefaultUrl("http://lk-stage.progresspoint.ru")
public class LKBasicInfoPage extends PageObject {

    WebElementFacade ownerDataField;
    WebElementFacade ownerDocumentsCopiesField;
    WebElementFacade vehicleDataField;
    WebElementFacade vehicleDocumentsCopiesField;

    public void enterOwnerData(String ownerData) {
        enter(ownerData).into(ownerDataField);
    }

    public void uploadOwnerDocumentsCopies(String filename) {
        upload(filename).to(ownerDocumentsCopiesField);
    }

    public void enterVehicleData(String vehicleData) {
        enter(vehicleData).into(vehicleDataField);
    }

    public void uploadVehicleDocumentsCopies(String filename) {
        upload(filename).to(vehicleDocumentsCopiesField);
    }
}
