package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница Регистрации ВТС - физическое лицо
 */
@At("#HOST/clients/draft")
public class CPPClientRegistrationPage extends CPPSelectizePageObject {

    //ЛИЧНЫЕ ДАННЫЕ ВЛАДЕЛЬЦА
    private static final String clientDocumentTypeField = "client_fl_persons_attributes_0_certify_doc_attributes_doc_type_id_or_name";

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_certify_doc_attributes_passport_ser_and_num']")
    WebElementFacade clientDocumentNumberField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_certify_doc_attributes_issued']")
    WebElementFacade clientDocumentByField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_certify_doc_attributes_issue_date']")
    WebElementFacade clientDocumentDateField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_surname']")
    WebElementFacade clientSurnameField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_name']")
    WebElementFacade clientNameField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_patronymic']")
    WebElementFacade clientPatronymicField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_main_phone_attributes_name']")
    WebElementFacade clientPhoneField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_main_email_attributes_name']")
    WebElementFacade clientEmailField;

    private static final String clientRoleField = "client_fl_persons_attributes_0_contact_role";

    public void selectClientDocumentType(String clientDocumentType) {
        selectForSelectizePlugin(clientDocumentTypeField, clientDocumentType);
    }

    public void enterClientDocumentNumber(String clientDocumentNumber) {
        enter(clientDocumentNumber).into(clientDocumentNumberField);
    }

    public void enterClientDocumentIssuedDate(String clientDocumentDate) {
        enter(clientDocumentDate).into(clientDocumentDateField);
    }

    public void enterClientDocumentIssuedBy(String clientDocumentBy) {
        enter(clientDocumentBy).into(clientDocumentByField);
    }

    public void enterClientSurname(String clientSurname) {
        enter(clientSurname).into(clientSurnameField);
    }

    public void enterClientName(String clientName) {
        enter(clientName).into(clientNameField);
    }

    public void enterClientPatronymic(String clientPatronymic) {
        enter(clientPatronymic).into(clientPatronymicField);
    }

    public void enterClientPhone(String clientPhone) {
        enter(clientPhone).into(clientPhoneField);
    }

    public void enterClientEmail(String clientEmail) {
        enter(clientEmail).into(clientEmailField);
    }

    public void selectClientRole(String clientRole) {
        selectForSelectizePlugin(clientRoleField, clientRole);
    }

    //АДРЕС РЕГИСТРАЦИИ
    private static final String clientAddressRegionField = "client_fl_persons_attributes_0_reg_address_attributes_region";
    private static final String clientAddressDistrictField = "client_fl_persons_attributes_0_reg_address_attributes_district";
    private static final String clientAddressCityField = "client_fl_persons_attributes_0_reg_address_attributes_city";
    private static final String clientAddressSettlementField = "cclient_fl_persons_attributes_0_reg_address_attributes_settlement";
    private static final String clientAddressStreetField = "client_fl_persons_attributes_0_reg_address_attributes_street";

    @FindBy(id = "client_fl_persons_attributes_0_reg_address_attributes_house")
    WebElementFacade clientAddressHouseField;

    @FindBy(id = "client_fl_persons_attributes_0_reg_address_attributes_housing")
    WebElementFacade clientAddressHousingField;

    @FindBy(id = "client_fl_persons_attributes_0_reg_address_attributes_building")
    WebElementFacade clientAddressBuildingField;

    @FindBy(id = "client_fl_persons_attributes_0_reg_address_attributes_room")
    WebElementFacade clientAddressRoomField;

    @FindBy(id = "client_fl_persons_attributes_0_reg_address_attributes_index")
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
    @FindBy(xpath = ".//*[@for='client_fl_persons_attributes_0_location_address_attributes_same_as_reg']/div")
    WebElementFacade locationAddressSameAsRegistrationCheckBox;

    private static final String locationAddressRegionField = "client_fl_persons_attributes_0_location_address_attributes_region";
    private static final String locationAddressDistrictField = "client_fl_persons_attributes_0_location_address_attributes_district";
    private static final String locationAddressCityField = "client_fl_persons_attributes_0_location_address_attributes_city";
    private static final String locationAddressSettlementField = "client_fl_persons_attributes_0_location_address_attributes_settlement";
    private static final String locationAddressStreetField = "client_fl_persons_attributes_0_location_address_attributes_street";

    @FindBy(id = "client_fl_persons_attributes_0_location_address_attributes_house")
    WebElementFacade locationAddressHouseField;

    @FindBy(id = "client_fl_persons_attributes_0_location_address_attributes_housing")
    WebElementFacade locationAddressHousingField;

    @FindBy(id = "client_fl_persons_attributes_0_location_address_attributes_building")
    WebElementFacade locationAddressBuildingField;

    @FindBy(id = "client_fl_persons_attributes_0_location_address_attributes_room")
    WebElementFacade locationAddressRoomField;

    @FindBy(id = "client_fl_persons_attributes_0_location_address_attributes_post_index")
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
    @FindBy(xpath = ".//*[@for='client_fl_persons_attributes_0_postal_address_attributes_same_as_reg']/div")
    WebElementFacade postalAddressSameAsRegistrationCheckBox;

    private static final String postalAddressRegionField = "client_fl_persons_attributes_0_postal_address_attributes_region";
    private static final String postalAddressDistrictField = "client_fl_persons_attributes_0_postal_address_attributes_district";
    private static final String postalAddressCityField = "client_fl_persons_attributes_0_postal_address_attributes_city";
    private static final String postalAddressSettlementField = "client_fl_persons_attributes_0_postal_address_attributes_settlement";
    private static final String postalAddressStreetField = "client_fl_persons_attributes_0_postal_address_attributes_street";

    @FindBy(id = "client_fl_persons_attributes_0_postal_address_attributes_house")
    WebElementFacade postalAddressHouseField;

    @FindBy(id = "client_fl_persons_attributes_0_postal_address_attributes_housing")
    WebElementFacade postalAddressHousingField;

    @FindBy(id = "client_fl_persons_attributes_0_postal_address_attributes_building")
    WebElementFacade postalAddressBuildingField;

    @FindBy(id = "client_fl_persons_attributes_0_postal_address_attributes_room")
    WebElementFacade postalAddressRoomField;

    @FindBy(id = "client_fl_persons_attributes_0_postal_address_attributes_post_index")
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

    //ЛИЦЕВОЙ СЧЕТ
    @FindBy(id = "client_accounts_attributes_0_name")
    WebElementFacade clientAccountNameField;

    @FindBy(xpath = ".//*[@class='string optional name-account 0 required form-control']")
    WebElementFacade clientSecondAccountNameField;

    @FindBy(id = "client_accounts_attributes_0_num")
    WebElementFacade clientAccountNamberField;

    public void enterClientAccountName(String clientAccountName) {
        enter(clientAccountName).into(clientAccountNameField);
    }

    public void enterClientSecondAccountName(String clientSecondAccountName) {
        enter(clientSecondAccountName).into(clientSecondAccountNameField);
    }

    public String getClientAccountNamber() {
        return clientAccountNamberField.getValue();
    }

    //РАСЧЕТНЫЙ СЧЕТ
    @FindBy(id = "client_client_settlement_account_attributes_bank_name")
    WebElementFacade clientBankNameField;

    @FindBy(id = "client_client_settlement_account_attributes_bik")
    WebElementFacade clientBankBIKField;

    @FindBy(id = "client_client_settlement_account_attributes_inn")
    WebElementFacade clientBankINNField;

    @FindBy(id = "client_client_settlement_account_attributes_kor_num")
    WebElementFacade clientBankKorNumberField;

    @FindBy(id = "client_client_settlement_account_attributes_account_num")
    WebElementFacade clientBankAccountNumberField;

    @FindBy(id = "client_client_settlement_account_attributes_receiver_name")
    WebElementFacade clientBankReceiverNameField;

    public void enterClientBankName(String clientBankName) {
        enter(clientBankName).into(clientBankNameField);
    }

    public void enterClientBankBIK(String clientBankBIK) {
        enter(clientBankBIK).into(clientBankBIKField);
    }

    public void enterClientBankINN(String clientBankINN) {
        enter(clientBankINN).into(clientBankINNField);
    }

    public void enterClientBankKorNumber(String clientBankKorNumber) {
        enter(clientBankKorNumber).into(clientBankKorNumberField);
    }

    public void enterClientBankAccountNumber(String clientBankAccountNumber) {
        enter(clientBankAccountNumber).into(clientBankAccountNumberField);
    }

    public void enterClientBankReceiverName(String clientBankReceiverName) {
        enter(clientBankReceiverName).into(clientBankReceiverNameField);
    }
}
