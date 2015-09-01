package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница Регистрация ТС в ЦИПП
 */
@At("#HOST/vehicles/new?from_clients=1")
public class CPPVehicleRegistrationPage extends CPPSelectizePageObject {

    //ДАННЫЕ О ТРАНСПОРТНОМ СРЕДСТВЕ
    private static final String vehicleCountryField = "vehicle_grnz_country_id";

    @FindBy(xpath = ".//input[@id='vehicle_sts_attributes_number']")
    WebElementFacade vehicleDocumentNumberField;

    @FindBy(xpath = ".//input[@id='vehicle_sts_attributes_issue_date']")
    WebElementFacade vehicleDocumentDateIssueField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_certify_doc_attributes_issue_date']")
    WebElementFacade vehicleDocumentDateField;

    @FindBy(xpath = ".//input[@id='vehicle_grnz']")
    WebElementFacade vehicleGRNZField;

    private static final String vehicleTypeField = "vehicle_vehicle_type_id";

    @FindBy(xpath = ".//input[@id='vehicle_vin']")
    WebElementFacade vehicleVINField;

    private static final String vehicleBasisTypeField = "vehicle_vehicle_basis_type_id";

    private static final String vehicleMarkField = "vehicle_vehicle_mark_id";

    @FindBy(xpath = ".//input[@id='vehicle_max_mass']")
    WebElementFacade vehicleMassField;

    private static final String vehicleAccountField = "vehicle_account_id";

    private static final String vehicleGroupField = "vehicle_vehicle_group_id";

    @FindBy(xpath = "//*[@id='CreateVehicleFinishModal']//*[text()='OK']")
    WebElementFacade confirmVehicleRegistrationDialogButton;

    public void selectVehicleCountry(String vehicleCountry) {
        selectForSelectizePlugin(vehicleCountryField, vehicleCountry);
    }

    public void enterVehicleDocumentNumber(String vehicleDocumentNumber) {
        enter(vehicleDocumentNumber).into(vehicleDocumentNumberField);
    }

    public void enterVehicleDocumentDateIssue(String vehicleDocumentDateIssue) {
        enter(vehicleDocumentDateIssue).into(vehicleDocumentDateIssueField);
    }

    public void enterVehicleDocumentDate(String vehicleDocumentDate) {
        enter(vehicleDocumentDate).into(vehicleDocumentDateField);
    }

    public void enterVehicleGRNZ(String vehicleGRNZ) {
        enter(vehicleGRNZ).into(vehicleGRNZField);
    }

    public void selectVehicleType(String vehicleType) {
        selectForSelectizePlugin(vehicleTypeField, vehicleType);
    }

    public void enterVehicleVIN(String vehicleVIN) {
        enter(vehicleVIN).into(vehicleVINField);
    }

    public void selectVehicleBasisType(String vehicleBasisType) {
        selectForSelectizePlugin(vehicleBasisTypeField, vehicleBasisType);
    }

    public void selectVehicleMark(String vehicleMark) {
        selectForSelectizePlugin(vehicleMarkField, vehicleMark);
    }

    public void enterVehicleMass(String vehicleMass) {
        enter(vehicleMass).into(vehicleMassField);
    }

    public void selectVehicleAccount(String vehicleAccount) {
        selectForSelectizePlugin(vehicleAccountField, vehicleAccount);
    }

    public void selectVehicleGrope(String vehicleGroup) {
        selectForSelectizePlugin(vehicleGroupField, vehicleGroup);
    }

    public void clickToConfirmVehicleRegistrationDialogButton() {
        confirmVehicleRegistrationDialogButton.click();
    }
}