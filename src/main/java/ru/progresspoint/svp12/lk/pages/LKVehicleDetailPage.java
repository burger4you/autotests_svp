package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница открытого ТС в Личном Кабинете
 */
@At("#HOST/accounts/.*/vehicles/.*")
public class LKVehicleDetailPage extends PageObject {

    @FindBy(id = "grnz")
    WebElementFacade vehicleGRNZField;

    @FindBy(xpath = ".//*[@for='vehicle_grnz_country_id']/..//*[@class='item']")
    WebElementFacade vehicleCountryField;

    @FindBy(xpath = ".//*[@for='vehicle_vehicle_basis_type_id']/..//*[@class='item']")
    WebElementFacade vehicleBasisTypeField;

    public String getVehicleGRNZ() {
        return vehicleGRNZField.getValue();
    }

    public String getVehicleCountry() {
        return vehicleCountryField.getText();
    }

    public String getVehicleBasisType() {
        return vehicleBasisTypeField.getText();
    }
}