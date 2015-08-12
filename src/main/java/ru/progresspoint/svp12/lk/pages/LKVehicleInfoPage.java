package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.By.id;

/**
 * Страница ввода информации о ТС при регистрации
 */
@DefaultUrl("http://lk-stage.progresspoint.ru/registration")
public class LKVehicleInfoPage extends LKSelectizePageObject {

    private static final String vehicleRegistrationCountryField = "vehicle_grnz_country_id";

    @FindBy(id = "vehicle_grnz")
    WebElementFacade vehicleRegistrationGRNZField;

    private static final String vehicleBasisTypeField = "vehicle_vehicle_basis_type_id";

    @FindBy(id = "vehicle_doc_number")
    WebElementFacade vehicleRegistrationDocumentNumberField;

    private static final String vehicleMarkField = "vehicle_vehicle_mark_id";

    @FindBy(id = "vehicle_vin")
    WebElementFacade vehicleVINField;

    private static final String vehicleMassField = "vehicle_vehicle_mass_id";

    public void loading() {
        withTimeoutOf(15, SECONDS).waitForPresenceOf(id(vehicleRegistrationCountryField));
        vehicleRegistrationGRNZField.shouldBeEnabled();
    }

    public void selectVehicleRegistrationCountry(String vehicleRegistrationCountry) {
        selectForSelectizePlugin(vehicleRegistrationCountryField, vehicleRegistrationCountry);
    }

    public void enterVehicleRegistrationGRNZ(String vehicleRegistrationGRNZ) {
        enter(vehicleRegistrationGRNZ).into(vehicleRegistrationGRNZField);
    }

    public void selectVehicleBasisType(String vehicleBasisType) {
        selectForSelectizePlugin(vehicleBasisTypeField, vehicleBasisType);
    }

    public void enterVehicleRegistrationDocumentNumber(String vehicleRegistrationDocumentNumber) {
        enter(vehicleRegistrationDocumentNumber).into(vehicleRegistrationDocumentNumberField);
    }

    public void selectVehicleMark(String vehicleMark) {
        selectForSelectizePlugin(vehicleMarkField, vehicleMark);
    }

    public void enterVehicleVIN(String vehicleVIN) {
        enter(vehicleVIN).into(vehicleVINField);
    }

    public void selectVehicleMass(String vehicleMass) {
        selectForSelectizePlugin(vehicleMassField, vehicleMass);
    }

    //Скан-копии свидетельства о регистрации ТС

    @FindBy(xpath = ".//div[1]/input[@name='vehicle[sts_files][]']")
    WebElementFacade vehicleDocumentFirstCopyField;

    @FindBy(xpath = ".//div[2]/input[@name='vehicle[sts_files][]']")
    WebElementFacade vehicleDocumentSecondCopyField;

    public void uploadVehicleDocumentsCopies(String filename1, String filename2) {
        // Меняем атрибут display у инпута, для возможности загружать файлы
        evaluateJavascript("document.getElementsByName('vehicle[sts_files][]')[0].setAttribute('Style','display:block');");
        upload(filename1).to(vehicleDocumentFirstCopyField);
        upload(filename2).to(vehicleDocumentSecondCopyField);
    }
}