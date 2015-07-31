package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница регистрации нового ТС в Личном Кабинете
 */
@At("#HOST/client_accounts/.*/vehicle/new")
public class LKNewVehiclePage extends PageObject {

    WebElementFacade vehicleDataField;
    WebElementFacade vehicleDocumentsCopiesField;

    public void enterVehicleData(String vehicleData) {
        enter(vehicleData).into(vehicleDataField);
    }

    public void uploadVehicleDocumentsCopies(String filename) {
        upload(filename).to(vehicleDocumentsCopiesField);
    }
}
