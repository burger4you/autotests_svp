package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница Регистрации ВТС - индивидуальный предприниматель
 */
@At("#HOST/clients/draft")
public class CPPIPRegistrationPage extends CPPSelectizePageObject {

    //ДАННЫЕ ИНДИВИДУАЛЬНОГО ПРЕДПРИНИМАТЕЛЯ
    @FindBy(id = "client_ogrn")
    WebElementFacade ipOGRNField;

    @FindBy(id = "client_inn")
    WebElementFacade ipINNField;

    @FindBy(id = "client_ip_persons_attributes_0_surname")
    WebElementFacade ipSurnameField;

    @FindBy(id = "client_ip_persons_attributes_0_name")
    WebElementFacade ipNameField;

    @FindBy(id = "client_ip_persons_attributes_0_patronymic")
    WebElementFacade ipPatronymicField;

    @FindBy(id = "client_short_name")
    WebElementFacade ipShortNameField;

    private static final String ipDocumentTypeField = "client_ip_persons_attributes_0_certify_doc_attributes_doc_type_id_or_name";

    @FindBy(id = "client_ip_persons_attributes_0_certify_doc_attributes_passport_ser_and_num")
    WebElementFacade ipDocumentNumberField;

    @FindBy(id = "client_ip_persons_attributes_0_certify_doc_attributes_issued")
    WebElementFacade ipDocumentIssuedByField;

    @FindBy(id = "client_ip_persons_attributes_0_certify_doc_attributes_issue_date")
    WebElementFacade ipDocumentIssuedDateField;

    @FindBy(id = "client_ip_persons_attributes_0_main_phone_attributes_name")
    WebElementFacade ipMainPhoneField;

    @FindBy(id = "client_ip_persons_attributes_0_main_email_attributes_name")
    WebElementFacade ipMainEmailField;

    private static final String ipRoleField = "client_ip_persons_attributes_0_contact_role";

    public void enterIPOGRN(String ipOGRN) {
        enter(ipOGRN).into(ipOGRNField);
    }

    public void enterIPINN(String ipINN) {
        enter(ipINN).into(ipINNField);
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

    public void enterIPDocumentIssuedDate(String ipDocumentIssuedDate) {
        enter(ipDocumentIssuedDate).into(ipDocumentIssuedDateField);
    }

    public void enterIPDocumentIssuedBy(String ipDocumentIssuedBy) {
        enter(ipDocumentIssuedBy).into(ipDocumentIssuedByField);
    }

    public void enterIPMainPhone(String ipMainPhone) {
        enter(ipMainPhone).into(ipMainPhoneField);
    }

    public void enterIPMainEmail(String ipMainEmail) {
        enter(ipMainEmail).into(ipMainEmailField);
    }

    public void selectIPRole(String ipRole) {
        selectForSelectizePlugin(ipRoleField, ipRole);
    }
    
    //АДРЕС РЕГИСТРАЦИИ
    private static final String clientAddressRegionField = "client_ip_persons_attributes_0_reg_address_attributes_region";
    private static final String clientAddressDistrictField = "client_ip_persons_attributes_0_reg_address_attributes_district";
    private static final String clientAddressCityField = "client_ip_persons_attributes_0_reg_address_attributes_city";
    private static final String clientAddressSettlementField = "cclient_ip_persons_attributes_0_reg_address_attributes_settlement";
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
        if (!clientAddressStreet.isEmpty())enterForSelectizePlugin(clientAddressStreetField, clientAddressStreet);
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

    //ПОЧТОВЫЙ АДРЕС
    @FindBy(xpath = ".//*[@for='client_ip_persons_attributes_0_postal_address_attributes_same_as_reg']/div")
    WebElementFacade postalAddressSameAsRegistrationCheckBox;

    private static final String postalAddressRegionField = "client_ip_persons_attributes_0_postal_address_attributes_region";
    private static final String postalAddressDistrictField = "client_ip_persons_attributes_0_postal_address_attributes_district";
    private static final String postalAddressCityField = "client_ip_persons_attributes_0_postal_address_attributes_city";
    private static final String postalAddressSettlementField = "client_ip_persons_attributes_0_postal_address_attributes_settlement";
    private static final String postalAddressStreetField = "client_ip_persons_attributes_0_postal_address_attributes_street";

    @FindBy(id = "client_ip_persons_attributes_0_postal_address_attributes_house")
    WebElementFacade postalAddressHouseField;

    @FindBy(id = "client_ip_persons_attributes_0_postal_address_attributes_housing")
    WebElementFacade postalAddressHousingField;

    @FindBy(id = "client_ip_persons_attributes_0_postal_address_attributes_building")
    WebElementFacade postalAddressBuildingField;

    @FindBy(id = "client_ip_persons_attributes_0_postal_address_attributes_room")
    WebElementFacade postalAddressRoomField;

    @FindBy(id = "client_ip_persons_attributes_0_postal_address_attributes_post_index")
    WebElementFacade postalAddressIndexField;

    public void clickToPostalAddressSameAsRegistrationCheckBox() {
        postalAddressSameAsRegistrationCheckBox.click();
    }

    public void selectClientPostalAddressRegion(String postalAddressRegion) {
        if (!postalAddressRegion.isEmpty()) enterForSelectizePlugin(postalAddressRegionField, postalAddressRegion);
    }

    public void selectClientPostalAddressDistrict(String postalAddressDistrict) {
        if (!postalAddressDistrict.isEmpty()) enterForSelectizePlugin(postalAddressDistrictField, postalAddressDistrict);
    }

    public void selectClientPostalAddressCity(String postalAddressCity) {
        if (!postalAddressCity.isEmpty()) enterForSelectizePlugin(postalAddressCityField, postalAddressCity);
    }

    public void selectClientPostalAddressSettlement(String postalAddressSettlement) {
        if (!postalAddressSettlement.isEmpty()) enterForSelectizePlugin(postalAddressSettlementField, postalAddressSettlement);
    }

    public void selectClientPostalAddressStreet(String postalAddressStreet) {
        if (!postalAddressStreet.isEmpty()) enterForSelectizePlugin(postalAddressStreetField, postalAddressStreet);
    }

    public void enterClientPostalAddressHouse(String postalAddressHouse) {
        enter(postalAddressHouse).into(postalAddressHouseField);
    }

    public void enterClientPostalAddressHousing(String postalAddressHousing) {
        enter(postalAddressHousing).into(postalAddressHousingField);
    }

    public void enterClientPostalAddressBuilding(String postalAddressBuilding) {
        enter(postalAddressBuilding).into(postalAddressBuildingField);
    }

    public void enterClientPostalAddressRoom(String postalAddressRoom) {
        enter(postalAddressRoom).into(postalAddressRoomField);
    }

    public void enterClientPostalAddressIndex(String postalAddressIndex) {
        enter(postalAddressIndex).into(postalAddressIndexField);
    }
}
