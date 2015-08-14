package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница регистрации нового ТС в Личном Кабинете
 */
@At("#HOST/client_accounts/.*/vehicle/new")
public class LKNewVehiclePage extends LKSelectizePageObject {

    //Данные о ТС

    @FindBy(id = "grnz")
    WebElementFacade vehicleGRNZField;

    private static final String vehicleCountryField = "vehicle_grnz_country_id";

    private static final String vehicleBasisTypeField = "vehicle_vehicle_basis_type_id";

    @FindBy(id = "vehicle_sts_attributes_number")
    WebElementFacade vehicleDocumentNumberField;

    private static final String vehicleMarkField = "vehicle_vehicle_mark_id";

    @FindBy(id = "vin")
    WebElementFacade vehicleVINField;

    @FindBy(id = "vehicle_max_mass")
    WebElementFacade vehicleMassField;

    private static final String vehicleAccountField = "vehicle_account_id";

    private static final String vehicleGroupField = "vehicle_vehicle_group_id";

    public void selectVehicleCountry(String vehicleCountry) {
        selectForSelectizePlugin(vehicleCountryField, vehicleCountry);
    }

    public void enterVehicleGRNZ(String vehicleGRNZ) {
        enter(vehicleGRNZ).into(vehicleGRNZField);
    }

    public void selectVehicleBasisType(String vehicleBasisType) {
        selectForSelectizePlugin(vehicleBasisTypeField, vehicleBasisType);
    }

    public void enterVehicleDocumentNumber(String vehicleDocumentNumber) {
        enter(vehicleDocumentNumber).into(vehicleDocumentNumberField);
    }

    public void selectVehicleMark(String vehicleMark) {
        selectForSelectizePlugin(vehicleMarkField, vehicleMark);
    }

    public void enterVehicleVIN(String vehicleVIN) {
        enter(vehicleVIN).into(vehicleVINField);
    }

    public void selectVehicleMass(String vehicleMass) {
        enter(vehicleMass).into(vehicleMassField);
    }

    public void selectAccountId(String vehicleAccount) {
        selectForSelectizePlugin(vehicleAccountField, vehicleAccount);
    }

    public void selectVehicleGroup(String vehicleGroup) {
        if (!vehicleGroup.isEmpty()) {
            selectForSelectizePlugin(vehicleGroupField, vehicleGroup);
        }
    }

    //Скан-копии свидетельства о регистрации ТС

    @FindBy(id = "vehicle_sts_files_attributes_1_file_link")
    WebElementFacade vehicleDocumentFirstCopyField;

    @FindBy(xpath = ".//div[2]/*[@id='vehicle_sts_files_attributes_0_file_link']")
    WebElementFacade vehicleDocumentSecondCopyField;

    public void uploadVehicleDocumentsCopies(String filename1, String filename2) {
        // Меняем атрибут display у инпута, для возможности загружать файлы
        evaluateJavascript("document.getElementById('vehicle_sts_files_attributes_1_file_link').setAttribute('Style','display:block');");
        upload(filename1).to(vehicleDocumentFirstCopyField);

//        evaluateJavascript("document.getElementsByName('vehicle[sts_files_attributes][1438961438639][file_link]')[0].setAttribute('Style','display:block');");
//        upload(filename2).to(vehicleDocumentSecondCopyField);
    }
}