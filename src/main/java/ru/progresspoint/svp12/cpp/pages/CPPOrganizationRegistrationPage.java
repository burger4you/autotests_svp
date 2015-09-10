package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница Регистрации ВТС - юридическое лицо
 */
@At("#HOST/clients/draft")
public class CPPOrganizationRegistrationPage extends CPPSelectizePageObject {

    //ДАННЫЕ ЮРИДИЧЕСКОГО ЛИЦА
    private static final String organizationOPFField = "client_okopf_id";

    @FindBy(id = "client_ogrn")
    WebElementFacade organizationOGRNField;

    @FindBy(id = "client_inn")
    WebElementFacade organizationINNField;

    @FindBy(id = "client_name")
    WebElementFacade organizationNameField;

    @FindBy(id = "client_short_name")
    WebElementFacade organizationShortNameField;

    @FindBy(id = "client_main_phone_attributes_name")
    WebElementFacade organizationMainPhoneField;

    @FindBy(id = "client_main_email_attributes_name")
    WebElementFacade organizationMainEmailField;

    public void selectOrganizationOPF(String organizationOPF) {
        selectForSelectizePlugin(organizationOPFField, organizationOPF);
    }

    public void enterOrganizationOGRN(String organizationOGRN) {
        enter(organizationOGRN).into(organizationOGRNField);
    }

    public void enterOrganizationINN(String organizationINN) {
        enter(organizationINN).into(organizationINNField);
    }

    public void enterOrganizationName(String organizationName) {
        enter(organizationName).into(organizationNameField);
    }

    public void enterOrganizationShortName(String organizationShortName) {
        enter(organizationShortName).into(organizationShortNameField);
    }

    public void enterOrganizationMainPhone(String organizationPhone) {
        enter(organizationPhone).into(organizationMainPhoneField);
    }

    public void enterOrganizationMainEmail(String organizationEmail) {
        enter(organizationEmail).into(organizationMainEmailField);
    }

    //ЛИЧНЫЕ ДАННЫЕ РУКОВОДИТЕЛЯ
    @FindBy(id = "client_ceo_persons_attributes_0_surname")
    WebElementFacade directorSurnameField;

    @FindBy(id = "client_ceo_persons_attributes_0_name")
    WebElementFacade directorNameField;

    @FindBy(id = "client_ceo_persons_attributes_0_patronymic")
    WebElementFacade directorPatronymicField;

    private static final String directorPersonalDocumentTypeField = "client_ceo_persons_attributes_0_certify_doc_attributes_doc_type_id_or_name";

    @FindBy(id = "client_ceo_persons_attributes_0_certify_doc_attributes_passport_ser_and_num")
    WebElementFacade directorPersonalDocumentNumberField;

    @FindBy(id = "client_ceo_persons_attributes_0_certify_doc_attributes_issue_date")
    WebElementFacade directorPersonalDocumentDateField;

    @FindBy(id = "client_ceo_persons_attributes_0_certify_doc_attributes_issued")
    WebElementFacade directorPersonalDocumentByField;

    private static final String directorDocumentTypeField = "client_ceo_persons_attributes_0_authority_doc_attributes_doc_type_id";

    @FindBy(id = "client_ceo_persons_attributes_0_authority_doc_attributes_number")
    WebElementFacade directorDocumentNumberField;

    @FindBy(id = "client_ceo_persons_attributes_0_authority_doc_attributes_start_date")
    WebElementFacade directorDocumentDateField;

    @FindBy(id = "client_ceo_persons_attributes_0_authority_doc_attributes_end_date")
    WebElementFacade directorDocumentValidityField;

    @FindBy(id = "client_ceo_persons_attributes_0_main_phone_attributes_name")
    WebElementFacade directorPhoneField;

    @FindBy(id = "client_ceo_persons_attributes_0_main_email_attributes_name")
    WebElementFacade directorEmailField;

    private static final String directorPositionField = "client_ceo_persons_attributes_0_person_job_id";

    private static final String directorRoleField = "client_ceo_persons_attributes_0_contact_role";

    public void enterDirectorSurname(String directorSurname) {
        enter(directorSurname).into(directorSurnameField);
    }

    public void enterDirectorName(String directorName) {
        enter(directorName).into(directorNameField);
    }

    public void enterDirectorPatronymic(String directorPatronymic) {
        enter(directorPatronymic).into(directorPatronymicField);
    }

    public void selectDirectorPersonalDocumentType(String directorPersonalDocumentType) {
        selectForSelectizePlugin(directorPersonalDocumentTypeField, directorPersonalDocumentType);
    }

    public void enterDirectorPersonalDocumentNumber(String directorPersonalDocumentNumber) {
        enter(directorPersonalDocumentNumber).into(directorPersonalDocumentNumberField);
    }

    public void enterDirectorPersonalDocumentIssuedDate(String directorPersonalDocumentDate) {
        enter(directorPersonalDocumentDate).into(directorPersonalDocumentDateField);
    }

    public void enterDirectorPersonalDocumentIssuedBy(String directorPersonalDocumentBy) {
        enter(directorPersonalDocumentBy).into(directorPersonalDocumentByField);
    }

    public void selectDirectorDocumentType(String directorDocumentType) {
        selectForSelectizePlugin(directorDocumentTypeField, directorDocumentType);
    }

    public void enterDirectorDocumentNumber(String directorDocumentNumber) {
        enter(directorDocumentNumber).into(directorDocumentNumberField);
    }

    public void enterDirectorDocumentIssuedDate(String directorDocumentDate) {
        enter(directorDocumentDate).into(directorDocumentDateField);
    }

    public void enterDirectorDocumentValidity(String directorDocumentValidity) {
        enter(directorDocumentValidity).into(directorDocumentValidityField);
    }

    public void enterDirectorPhone(String directorPhone) {
        enter(directorPhone).into(directorPhoneField);
    }

    public void enterDirectorLogin(String directorEmail) {
        enter(directorEmail).into(directorEmailField);
    }

    public void selectDirectorPosition(String directorPosition) {
        selectForSelectizePlugin(directorPositionField, directorPosition);
    }

    public void selectDirectorRole(String directorRole) {
        selectForSelectizePlugin(directorRoleField, directorRole);
    }

    //АДРЕС РЕГИСТРАЦИИ
    private static final String clientAddressRegionField = "client_reg_address_attributes_region";
    private static final String clientAddressDistrictField = "client_reg_address_attributes_district";
    private static final String clientAddressCityField = "client_reg_address_attributes_city";
    private static final String clientAddressSettlementField = "cclient_reg_address_attributes_settlement";
    private static final String clientAddressStreetField = "client_reg_address_attributes_street";

    @FindBy(id = "client_reg_address_attributes_house")
    WebElementFacade clientAddressHouseField;

    @FindBy(id = "client_reg_address_attributes_housing")
    WebElementFacade clientAddressHousingField;

    @FindBy(id = "client_reg_address_attributes_building")
    WebElementFacade clientAddressBuildingField;

    @FindBy(id = "client_reg_address_attributes_room")
    WebElementFacade clientAddressRoomField;

    @FindBy(id = "client_reg_address_attributes_index")
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
    @FindBy(xpath = ".//*[@for='client_location_address_attributes_same_as_reg']/div")
    WebElementFacade locationAddressSameAsRegistrationCheckBox;

    private static final String locationAddressRegionField = "client_location_address_attributes_region";
    private static final String locationAddressDistrictField = "client_location_address_attributes_district";
    private static final String locationAddressCityField = "client_location_address_attributes_city";
    private static final String locationAddressSettlementField = "client_location_address_attributes_settlement";
    private static final String locationAddressStreetField = "client_location_address_attributes_street";

    @FindBy(id = "client_location_address_attributes_house")
    WebElementFacade locationAddressHouseField;

    @FindBy(id = "client_location_address_attributes_housing")
    WebElementFacade locationAddressHousingField;

    @FindBy(id = "client_location_address_attributes_building")
    WebElementFacade locationAddressBuildingField;

    @FindBy(id = "client_location_address_attributes_room")
    WebElementFacade locationAddressRoomField;

    @FindBy(id = "client_location_address_attributes_post_index")
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
    @FindBy(xpath = ".//*[@for='client_postal_address_attributes_same_as_reg']/div")
    WebElementFacade postalAddressSameAsRegistrationCheckBox;

    private static final String postalAddressRegionField = "client_postal_address_attributes_region";
    private static final String postalAddressDistrictField = "client_postal_address_attributes_district";
    private static final String postalAddressCityField = "client_postal_address_attributes_city";
    private static final String postalAddressSettlementField = "client_postal_address_attributes_settlement";
    private static final String postalAddressStreetField = "client_postal_address_attributes_street";

    @FindBy(id = "client_postal_address_attributes_house")
    WebElementFacade postalAddressHouseField;

    @FindBy(id = "client_postal_address_attributes_housing")
    WebElementFacade postalAddressHousingField;

    @FindBy(id = "client_postal_address_attributes_building")
    WebElementFacade postalAddressBuildingField;

    @FindBy(id = "client_postal_address_attributes_room")
    WebElementFacade postalAddressRoomField;

    @FindBy(id = "client_postal_address_attributes_post_index")
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
