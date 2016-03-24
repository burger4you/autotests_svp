package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import org.openqa.selenium.WebElement;

/**
 * Страница Регистрации ВТС - индивидуальный предприниматель
 */
@At("#HOST/clients/draft")
public class CPPIPRegistrationPage extends CPPSelectizePageObject {

    //ДАННЫЕ ИНДИВИДУАЛЬНОГО ПРЕДПРИНИМАТЕЛЯ
    private static final String ipDocumentTypeField = "client_ip_persons_attributes_0_certify_doc_attributes_doc_type_id_or_name";
    private static final String ipRoleField = "client_ip_persons_attributes_0_contact_role";
    private static final String ipLanguageField = "client_language_id";

    @FindBy(id = "client_ogrn")
    WebElementFacade ipOGRNField;

    @FindBy(id = "client_inn")
    WebElementFacade ipINNField;

    @FindBy(id = "client_kpp")
    WebElementFacade ipKPPField;

    @FindBy(id = "client_ip_persons_attributes_0_surname")
    WebElementFacade ipSurnameField;

    @FindBy(id = "client_ip_persons_attributes_0_name")
    WebElementFacade ipNameField;

    @FindBy(id = "client_ip_persons_attributes_0_patronymic")
    WebElementFacade ipPatronymicField;

    @FindBy(id = "client_short_name")
    WebElementFacade ipShortNameField;

    @FindBy(id = "client_ip_persons_attributes_0_certify_doc_attributes_passport_ser_and_num")
    WebElementFacade ipDocumentNumberField;

    @FindBy(id = "client_ip_persons_attributes_0_certify_doc_attributes_issued")
    WebElementFacade ipDocumentIssuedByField;

    @FindBy(id = "client_ip_persons_attributes_0_certify_doc_attributes_issue_date")
    WebElementFacade ipDocumentIssuedDateField;

    @FindBy(id = "client_ip_persons_attributes_0_certify_doc_attributes_issue_code")
    WebElementFacade ipDocumentIssuedCodeField;

    @FindBy(id = "client_ip_persons_attributes_0_main_email_attributes_name")
    WebElementFacade ipMainEmailField;

    @FindBy(id = "client_ip_persons_attributes_0_main_phone_attributes_name")
    WebElementFacade ipMainPhoneField;

    public void enterIPOGRN(String ipOGRN) {
        enter(ipOGRN).into(ipOGRNField);
    }

    public void enterIPINN(String ipINN) {
        enter(ipINN).into(ipINNField);
    }

    public void enterIPKPP(String ipKPP) {
        enter(ipKPP).into(ipKPPField);
    }

    public void enterIPSurname(String ipSurname) {
        enter(ipSurname).into(ipSurnameField);
    }

    public void enterIPName(String ipName) {
        enter(ipName).into(ipNameField);
    }

    public void enterIPPatronymic(String ipPatronymic) {
        enter(ipPatronymic).into(ipPatronymicField);
    }

    public void enterIPShortName(String ipShortName) {
        enter(ipShortName).into(ipShortNameField);
    }

    public void selectIPDocumentType(String ipDocumentType) {
        selectForSelectizePlugin(ipDocumentTypeField, ipDocumentType);
    }

    public void enterIPDocumentNumber(String ipDocumentNumber) {
        enter(ipDocumentNumber).into(ipDocumentNumberField);
    }

    public void enterIPDocumentIssuedBy(String ipDocumentIssuedBy) {
        enter(ipDocumentIssuedBy).into(ipDocumentIssuedByField);
    }

    public void enterIPDocumentIssuedDate(String ipDocumentIssuedDate) {
        enter(ipDocumentIssuedDate).into(ipDocumentIssuedDateField);
    }

    public void enterIPDocumentIssuedCode(String ipDocumentIssuedCode) {
        enter(ipDocumentIssuedCode).into(ipDocumentIssuedCodeField);
    }

    public void enterIPMainEmail(String ipMainEmail) {
        enter(ipMainEmail).into(ipMainEmailField);
    }

    public void enterIPMainPhone(String ipMainPhone) {
        enter(ipMainPhone).into(ipMainPhoneField);
    }

    public void selectIPRole(String ipRole) {
        selectForSelectizePlugin(ipRoleField, ipRole);
    }

    public void selectIPLanguage(String ipLanguage) {
        selectForSelectizePlugin(ipLanguageField, ipLanguage);
    }
    
    //АДРЕС РЕГИСТРАЦИИ
    private static final String clientAddressRegionField = "client_ip_persons_attributes_0_reg_address_attributes_region";
    private static final String clientAddressDistrictField = "client_ip_persons_attributes_0_reg_address_attributes_district";
    private static final String clientAddressCityField = "client_ip_persons_attributes_0_reg_address_attributes_city";
    private static final String clientAddressSettlementField = "client_ip_persons_attributes_0_reg_address_attributes_settlement";
    private static final String clientAddressStreetField = "client_ip_persons_attributes_0_reg_address_attributes_street";

    @FindBy(id = "client_ip_persons_attributes_0_reg_address_attributes_house")
    WebElementFacade clientAddressHouseField;

    @FindBy(id = "client_ip_persons_attributes_0_reg_address_attributes_housing")
    WebElementFacade clientAddressHousingField;

    @FindBy(id = "client_ip_persons_attributes_0_reg_address_attributes_building")
    WebElementFacade clientAddressBuildingField;

    @FindBy(id = "client_ip_persons_attributes_0_reg_address_attributes_room")
    WebElementFacade clientAddressRoomField;

    @FindBy(id = "client_ip_persons_attributes_0_reg_address_attributes_index")
    WebElementFacade clientAddressIndexField;

    public void selectClientRegistrationAddressRegion(String clientAddressRegion) {
        if (!clientAddressRegion.isEmpty()) enterForSelectizePlugin(clientAddressRegionField, clientAddressRegion);
    }

    public void selectClientRegistrationAddressDistrict(String clientAddressDistrict) {
        if (!clientAddressDistrict.isEmpty())enterForSelectizePlugin(clientAddressDistrictField, clientAddressDistrict);
    }

    public void selectClientRegistrationAddressCity(String clientAddressCity) {
        if (!clientAddressCity.isEmpty())enterForSelectizePlugin(clientAddressCityField, clientAddressCity);
    }

    public void selectClientRegistrationAddressSettlement(String clientAddressSettlement) {
        if (!clientAddressSettlement.isEmpty())enterForSelectizePlugin(clientAddressSettlementField, clientAddressSettlement);
    }

    public void selectClientRegistrationAddressStreet(String clientAddressStreet) {
        if (!clientAddressStreet.isEmpty()) {
//            enterForSelectizePlugin(clientAddressStreetField, clientAddressStreet);
            //TODO: Костыль, пока не сделают нормальное поле для улицы.
            enter(clientAddressStreet).into(findBy(String.format(INPUT_XPATH, clientAddressStreetField)));
            waitABit(3000);
            clickOnInvisibleElement(findBy(String.format(INPUT_ITEM_XPATH, clientAddressStreetField)));
        }
    }

    public void enterClientRegistrationAddressHouse(String clientAddressHouse) {
        enter(clientAddressHouse).into(clientAddressHouseField);
    }

    public void enterClientRegistrationAddressHousing(String clientAddressHousing) {
        enter(clientAddressHousing).into(clientAddressHousingField);
    }

    public void enterClientRegistrationAddressBuilding(String clientAddressBuilding) {
        enter(clientAddressBuilding).into(clientAddressBuildingField);
    }

    public void enterClientRegistrationAddressRoom(String clientAddressRoom) {
        enter(clientAddressRoom).into(clientAddressRoomField);
    }

    public void enterClientRegistrationAddressIndex(String clientAddressIndex) {
        enter(clientAddressIndex).into(clientAddressIndexField);
    }

    //АДРЕС МЕСТОНАХОЖДЕНИЯ
    @FindBy(xpath = ".//*[@for='client_ip_persons_attributes_0_location_address_attributes_same_as_reg']/div")
    WebElementFacade locationAddressSameAsRegistrationCheckBox;

    private static final String locationAddressRegionField = "client_ip_persons_attributes_0_location_address_attributes_region";
    private static final String locationAddressDistrictField = "client_ip_persons_attributes_0_location_address_attributes_district";
    private static final String locationAddressCityField = "client_ip_persons_attributes_0_location_address_attributes_city";
    private static final String locationAddressSettlementField = "client_ip_persons_attributes_0_location_address_attributes_settlement";
    private static final String locationAddressStreetField = "client_ip_persons_attributes_0_location_address_attributes_street";

    @FindBy(id = "client_ip_persons_attributes_0_location_address_attributes_house")
    WebElementFacade locationAddressHouseField;

    @FindBy(id = "client_ip_persons_attributes_0_location_address_attributes_housing")
    WebElementFacade locationAddressHousingField;

    @FindBy(id = "client_ip_persons_attributes_0_location_address_attributes_building")
    WebElementFacade locationAddressBuildingField;

    @FindBy(id = "client_ip_persons_attributes_0_location_address_attributes_room")
    WebElementFacade locationAddressRoomField;

    @FindBy(id = "client_ip_persons_attributes_0_location_address_attributes_post_index")
    WebElementFacade locationAddressIndexField;

    public void clickToLocationAddressSameAsRegistrationCheckBox() {
        locationAddressSameAsRegistrationCheckBox.click();
    }

    public void selectClientLocationAddressRegion(String locationAddressRegion) {
        if (!locationAddressRegion.isEmpty()) enterForSelectizePlugin(locationAddressRegionField, locationAddressRegion);
    }

    public void selectClientLocationAddressDistrict(String locationAddressDistrict) {
        if (!locationAddressDistrict.isEmpty()) enterForSelectizePlugin(locationAddressDistrictField, locationAddressDistrict);
    }

    public void selectClientLocationAddressCity(String locationAddressCity) {
        if (!locationAddressCity.isEmpty()) enterForSelectizePlugin(locationAddressCityField, locationAddressCity);
    }

    public void selectClientLocationAddressSettlement(String locationAddressSettlement) {
        if (!locationAddressSettlement.isEmpty()) enterForSelectizePlugin(locationAddressSettlementField, locationAddressSettlement);
    }

    public void selectClientLocationAddressStreet(String locationAddressStreet) {
        if (!locationAddressStreet.isEmpty()) enterForSelectizePlugin(locationAddressStreetField, locationAddressStreet);
    }

    public void enterClientLocationAddressHouse(String locationAddressHouse) {
        enter(locationAddressHouse).into(locationAddressHouseField);
    }

    public void enterClientLocationAddressHousing(String locationAddressHousing) {
        enter(locationAddressHousing).into(locationAddressHousingField);
    }

    public void enterClientLocationAddressBuilding(String locationAddressBuilding) {
        enter(locationAddressBuilding).into(locationAddressBuildingField);
    }

    public void enterClientLocationAddressRoom(String locationAddressRoom) {
        enter(locationAddressRoom).into(locationAddressRoomField);
    }

    public void enterClientLocationAddressIndex(String locationAddressIndex) {
        enter(locationAddressIndex).into(locationAddressIndexField);
    }

    private void clickOnInvisibleElement(WebElement element) {
        String script = "var object = arguments[0];"
                + "var theEvent = document.createEvent(\"MouseEvent\");"
                + "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "object.dispatchEvent(theEvent);";
        getJavascriptExecutorFacade().executeScript(script, element);
    }
}
