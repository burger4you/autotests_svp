package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница Регистрациb ВТС
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

    private static final String directorPersonalDocumentTypeField = "client_ceo_certify_doc_type_id";

    @FindBy(id = "client_ceo_certify_number")
    WebElementFacade directorPersonalDocumentNumberField;

    @FindBy(id = "client_ceo_certify_issue_date")
    WebElementFacade directorPersonalDocumentDateField;

    @FindBy(id = "client_ceo_certify_issued")
    WebElementFacade directorPersonalDocumentByField;

    private static final String directorDocumentTypeField = "client_ceo_authority_doc_type_id";

    @FindBy(id = "client_ceo_authority_number")
    WebElementFacade directorDocumentNumberField;

    @FindBy(id = "client_ceo_authority_issue_date")
    WebElementFacade directorDocumentDateField;

    @FindBy(id = "client_ceo_authority_end_date")
    WebElementFacade directorDocumentValidityField;

    @FindBy(id = "client_ceo_main_phone_name")
    WebElementFacade directorPhoneField;

    @FindBy(id = "client_ceo_main_email_name")
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
    @FindBy(id = "client_reg_address_attributes_post_index")
    WebElementFacade clientAddressIndexField;

    private static final String clientAddressKladrField = "client_reg_address_attributes_kladr_code";

    @FindBy(id = "client_reg_address_attributes_house")
    WebElementFacade clientAddressHouseField;

    @FindBy(id = "client_reg_address_attributes_housing")
    WebElementFacade clientAddressHousingField;

    @FindBy(id = "client_reg_address_attributes_building")
    WebElementFacade clientAddressBuildingField;

    @FindBy(id = "client_reg_address_attributes_room")
    WebElementFacade clientAddressRoomField;

    public void selectClientRegistrationAddressKladr(String clientAddressKladr) {
        enterForSelectizePlugin(clientAddressKladrField, clientAddressKladr);
    }

    public void enterClientRegistrationAddressIndex(String clientAddressIndex) {
        enter(clientAddressIndex).into(clientAddressIndexField);
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

    //АДРЕС МЕСТОНАХОЖДЕНИЯ
    @FindBy(xpath = ".//*[@for='client_postal_address_attributes_same_as_reg']/div")
    WebElementFacade clientLocationAddressSameAsClientRegistrationCheckBox;

    @FindBy(id = "client_location_address_attributes_post_index")
    WebElementFacade locationAddressIndexField;

    private static final String locationAddressKladrField = "client_location_address_attributes_kladr_code";

    @FindBy(id = "client_location_address_attributes_house")
    WebElementFacade locationAddressHouseField;

    @FindBy(id = "client_location_address_attributes_housing")
    WebElementFacade locationAddressHousingField;

    @FindBy(id = "client_location_address_attributes_building")
    WebElementFacade locationAddressBuildingField;

    @FindBy(id = "client_location_address_attributes_room")
    WebElementFacade locationAddressRoomField;

    public void clickToLocationAddressSameAsRegistrationCheckBox() {
        clientLocationAddressSameAsClientRegistrationCheckBox.click();
    }

    public void selectClientLocationAddressKladr(String locationAddressKladr) {
        enterForSelectizePlugin(locationAddressKladrField, locationAddressKladr);
    }

    public void enterClientLocationAddressIndex(String locationAddressIndex) {
        enter(locationAddressIndex).into(locationAddressIndexField);
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

    //ПОЧТОВЫЙ АДРЕС
    @FindBy(xpath = ".//*[@for='client_postal_address_attributes_same_as_reg']/div")
    WebElementFacade clientPostalAddressSameAsClientRegistrationCheckBox;

    @FindBy(id = "client_postal_address_attributes_post_index")
    WebElementFacade postalAddressIndexField;

    private static final String postalAddressKladrDropDown = "client_postal_address_attributes_kladr_code";

    @FindBy(id = "client_postal_address_attributes_house")
    WebElementFacade postalAddressHouseField;

    @FindBy(id = "client_postal_address_attributes_housing")
    WebElementFacade postalAddressHousingField;

    @FindBy(id = "client_postal_address_attributes_building")
    WebElementFacade postalAddressBuildingField;

    @FindBy(id = "client_postal_address_attributes_room")
    WebElementFacade postalAddressRoomField;

    public void clickToPostalAddressSameAsRegistrationCheckBox() {
        clientPostalAddressSameAsClientRegistrationCheckBox.click();
    }

    public void selectClientPostalAddressKladr(String postalAddressKladr) {
        enterForSelectizePlugin(postalAddressKladrDropDown, postalAddressKladr);
    }

    public void enterClientPostalAddressIndex(String postalAddressIndex) {
        enter(postalAddressIndex).into(postalAddressIndexField);
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

    //ЛИЦЕВОЙ СЧЕТ
    @FindBy(id = "client_accounts_attributes_0_name")
    WebElementFacade clientAccountNameField;

    @FindBy(id = "client_accounts_attributes_0_num")
    WebElementFacade clientAccountNamberField;

    public void enterClientAccountName(String clientAccountName) {
        enter(clientAccountName).into(clientAccountNameField);
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
