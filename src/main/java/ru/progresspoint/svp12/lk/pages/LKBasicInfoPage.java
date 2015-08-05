package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Страница ввода основной информации ВТС при регистрации
 */
@DefaultUrl("http://lk-stage.progresspoint.ru/registration")
public class LKBasicInfoPage extends LKSelectizePageObject {

    //Данные об ИП
    @FindBy(id = "client_short_name")
    WebElementFacade clientShortNameField;

    @FindBy(id = "client_name")
    WebElementFacade clientNameField;

    @FindBy(id = "client_inn")
    WebElementFacade clientINNField;

    @FindBy(id = "client_ogrn")
    WebElementFacade clientOGRNField;

    @FindBy(id = "client_main_email")
    WebElementFacade clientMainEmailField;

    @FindBy(id = "client_main_phone")
    WebElementFacade clientMainPhoneField;

    public void enterClientShortName(String clientShortName) {
        enter(clientShortName).into(clientShortNameField);
    }

    public void enterClientName(String clientName) {
        enter(clientName).into(clientNameField);
    }

    public void enterClientINN(String clientINN) {
        enter(clientINN).into(clientINNField);
    }

    public void enterClientOGRN(String clientOGRN) {
        enter(clientOGRN).into(clientOGRNField);
    }

    public void enterClientMainEmail(String clientMainEmail) {
        enter(clientMainEmail).into(clientMainEmailField);
    }

    public void enterClientMainPhone(String clientMainPhone) {
        enter(clientMainPhone).into(clientMainPhoneField);
    }

    //Данные об организации

    private static final String organizationOPFField = "client_okopf_id";

    public void selectOrganizationOPF(String organizationOPF) {
        selectForSelectizePlugin(organizationOPFField, organizationOPF);
    }

    //Данные о руководителе

    @FindBy(id = "client_ceo_last_name")
    WebElementFacade directorSurnameField;

    @FindBy(id = "client_ceo_first_name")
    WebElementFacade directorNameField;

    @FindBy(id = "client_ceo_middle_name")
    WebElementFacade directorPatronymicField;

    @FindBy(id = "client_ceo_job_name")
    WebElementFacade directorPositionField;

    @FindBy(id = "client_ceo_main_phone_name")
    WebElementFacade directorPhoneField;

    @FindBy(id = "client_ceo_main_email_name")
    WebElementFacade directorEmailField;

    public void enterDirectorSurname(String directorSurname) {
        enter(directorSurname).into(directorSurnameField);
    }

    public void enterDirectorName(String directorName) {
        enter(directorName).into(directorNameField);
    }

    public void enterDirectorPatronymic(String directorPatronymic) {
        enter(directorPatronymic).into(directorPatronymicField);
    }

    public void enterDirectorPhone(String directorPhone) {
        enter(directorPhone).into(directorPhoneField);
    }

    public void enterDirectorLogin(String directorEmail) {
        enter(directorEmail).into(directorEmailField);
    }

    public void enterDirectorPosition(String directorPosition) {
        enter(directorPosition).into(directorPositionField);
    }

    //Документ, подтверждающий полномочия руководителя

    private static final String directorDocumentTypeField = "client_ceo_authority_doc_type_id";

    @FindBy(id = "client_ceo_authority_number")
    WebElementFacade directorDocumentNumberField;

    @FindBy(id = "client_ceo_authority_issue_date")
    WebElementFacade directorDocumentDateField;

    @FindBy(id = "client_ceo_authority_end_date")
    WebElementFacade directorDocumentValidityField;

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

    //Реквизиты документа, удостоверящего личность руководителя

    private static final String directorPersonalDocumentTypeField = "client_ceo_certify_doc_type_id";

    @FindBy(id = "client_ceo_certify_number")
    WebElementFacade directorPersonalDocumentNumberField;

    @FindBy(id = "client_ceo_certify_issue_date")
    WebElementFacade directorPersonalDocumentDateField;

    @FindBy(id = "client_ceo_certify_issued")
    WebElementFacade directorPersonalDocumentByField;

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

    //Юридический адрес

    @FindBy(id = "client_reg_address_post_index")
    WebElementFacade clientRegistrationAddressIndexField;

    private static final String clientRegistrationAddressKladrField = "client_reg_address_kladr_code";

    @FindBy(id = "client_reg_address_house")
    WebElementFacade clientRegistrationAddressHouseField;

    @FindBy(id = "client_reg_address_housing")
    WebElementFacade clientRegistrationAddressHousingField;

    @FindBy(id = "client_reg_address_building")
    WebElementFacade clientRegistrationAddressBuildingField;

    @FindBy(id = "client_reg_address_room")
    WebElementFacade clientRegistrationAddressRoomField;

    public void enterClientRegistrationAddressIndex(String clientRegistrationAddressIndex) {
        enter(clientRegistrationAddressIndex).into(clientRegistrationAddressIndexField);
    }

    public void selectClientRegistrationAddressKladr(String clientRegistrationAddressKladr) {
        enterForSelectizePlugin(clientRegistrationAddressKladrField, clientRegistrationAddressKladr);
    }

    public void enterClientRegistrationAddressHouse(String clientRegistrationAddressHouse) {
        enter(clientRegistrationAddressHouse).into(clientRegistrationAddressHouseField);
    }

    public void enterClientRegistrationAddressHousing(String clientRegistrationAddressHousing) {
        enter(clientRegistrationAddressHousing).into(clientRegistrationAddressHousingField);
    }

    public void enterClientRegistrationAddressBuilding(String clientRegistrationAddressBuilding) {
        enter(clientRegistrationAddressBuilding).into(clientRegistrationAddressBuildingField);
    }

    public void enterClientRegistrationAddressRoom(String clientRegistrationAddressRoom) {
        enter(clientRegistrationAddressRoom).into(clientRegistrationAddressRoomField);
    }

    //Адрес местонахождения

    @FindBy(id = "client_location_address_post_index")
    WebElementFacade clientLocationAddressIndexField;

    private static final String clientLocationAddressKladrField = "client_location_address_kladr_code";

    @FindBy(id = "client_location_address_house")
    WebElementFacade clientLocationAddressHouseField;

    @FindBy(id = "client_location_address_housing")
    WebElementFacade clientLocationAddressHousingField;

    @FindBy(id = "client_location_address_building")
    WebElementFacade clientLocationAddressBuildingField;

    @FindBy(id = "client_location_address_room")
    WebElementFacade clientLocationAddressRoomField;

    public void enterClientLocationAddressIndex(String clientLocationAddressIndex) {
        enter(clientLocationAddressIndex).into(clientLocationAddressIndexField);
    }

    public void selectClientLocationAddressKladr(String clientLocationAddressKladr) {
        enterForSelectizePlugin(clientLocationAddressKladrField, clientLocationAddressKladr);
    }

    public void enterClientLocationAddressHouse(String clientLocationAddressHouse) {
        enter(clientLocationAddressHouse).into(clientLocationAddressHouseField);
    }

    public void enterClientLocationAddressHousing(String clientLocationAddressHousing) {
        enter(clientLocationAddressHousing).into(clientLocationAddressHousingField);
    }

    public void enterClientLocationAddressBuilding(String clientLocationAddressBuilding) {
        enter(clientLocationAddressBuilding).into(clientLocationAddressBuildingField);
    }

    public void enterClientLocationAddressRoom(String clientLocationAddressRoom) {
        enter(clientLocationAddressRoom).into(clientLocationAddressRoomField);
    }

    //Почтовый адрес

    @FindBy(id = "client_postal_address_post_index")
    WebElementFacade clientPostalAddressIndexField;

    private static final String clientPostalAddressKladrField = "client_postal_address_kladr_code";

    @FindBy(id = "client_postal_address_house")
    WebElementFacade clientPostalAddressHouseField;

    @FindBy(id = "client_postal_address_housing")
    WebElementFacade clientPostalAddressHousingField;

    @FindBy(id = "client_postal_address_building")
    WebElementFacade clientPostalAddressBuildingField;

    @FindBy(id = "client_postal_address_room")
    WebElementFacade clientPostalAddressRoomField;

    public void enterClientPostalAddressIndex(String clientPostalAddressIndex) {
        enter(clientPostalAddressIndex).into(clientPostalAddressIndexField);
    }

    public void selectClientPostalAddressKladr(String clientPostalAddressKladr) {
        enterForSelectizePlugin(clientPostalAddressKladrField, clientPostalAddressKladr);
    }

    public void enterClientPostalAddressHouse(String clientPostalAddressHouse) {
        enter(clientPostalAddressHouse).into(clientPostalAddressHouseField);
    }

    public void enterClientPostalAddressHousing(String clientPostalAddressHousing) {
        enter(clientPostalAddressHousing).into(clientPostalAddressHousingField);
    }

    public void enterClientPostalAddressBuilding(String clientPostalAddressBuilding) {
        enter(clientPostalAddressBuilding).into(clientPostalAddressBuildingField);
    }

    public void enterClientPostalAddressRoom(String clientPostalAddressRoom) {
        enter(clientPostalAddressRoom).into(clientPostalAddressRoomField);
    }

    //Банковские реквизиты

    @FindBy(id = "client_settlement_account_bank_name")
    WebElementFacade clientBankNameField;

    @FindBy(id = "client_settlement_account_bik")
    WebElementFacade clientBankBIKField;

    @FindBy(id = "client_settlement_account_inn")
    WebElementFacade clientBankINNField;

    @FindBy(id = "client_settlement_account_kor_num")
    WebElementFacade clientBankKorNumberField;

    @FindBy(id = "client_settlement_account_account_num")
    WebElementFacade clientBankAccountNumberField;

    @FindBy(id = "client_settlement_account_receiver_name")
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