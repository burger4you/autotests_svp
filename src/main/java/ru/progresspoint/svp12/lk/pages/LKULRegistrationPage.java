package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Страница ввода основной информации ВТС при регистрации
 */
@DefaultUrl("http://lk-stage.progresspoint.ru/registration")
public class LKULRegistrationPage extends LKSelectizePageObject {

    //ДАННЫЕ КОНТАКТНОГО ЛИЦА
    @FindBy(id = "client_login")
    WebElementFacade registrationLoginField;

    @FindBy(id = "client_phone")
    WebElementFacade registrationPhoneField;

    @FindBy(id = "client_position")
    WebElementFacade registrationPositionField;

    @FindBy(id = "client_last_name")
    WebElementFacade clientSurnameField;

    @FindBy(id = "client_first_name")
    WebElementFacade clientNameField;

    @FindBy(id = "client_middle_name")
    WebElementFacade clientPatronymicField;

    public void loading() {
        registrationLoginField.shouldBeEnabled();
        registrationPhoneField.shouldBeEnabled();
    }

    public void enterRegistrationLogin(String registrationLogin) {
        enter(registrationLogin).into(registrationLoginField);
    }

    public void enterRegistrationPhone(String registrationPhone) {
        enter(registrationPhone).into(registrationPhoneField);
    }

    public void enterRegistrationPosition(String registrationPosition) {
        enter(registrationPosition).into(registrationPositionField);
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

    //ДАННЫЕ ОБ ОРГАНИЗАЦИИ
    @FindBy(id = "client_short_name")
    WebElementFacade clientShortNameField;

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

    //РЕКВИЗИТЫ ДОКУМЕНТА, УДОСТОВЕРЯЮЩЕГО ЛИЧНОСТЬ РУКОВОДИТЕЛЯ
    private static final String clientPersonalDocumentTypeField = "client_ip_person_certify_doc_type_id";

    @FindBy(id = "client_ip_person_certify_number")
    WebElementFacade clientPersonalDocumentNumberField;

    @FindBy(id = "client_ip_person_certify_issue_date")
    WebElementFacade clientPersonalDocumentDateField;

    @FindBy(id = "client_ip_person_certify_issued")
    WebElementFacade clientPersonalDocumentByField;

    public void selectClientPersonalDocumentType(String clientPersonalDocumentType) {
        selectForSelectizePlugin(clientPersonalDocumentTypeField, clientPersonalDocumentType);
    }

    public void enterClientPersonalDocumentNumber(String clientPersonalDocumentNumber) {
        enter(clientPersonalDocumentNumber).into(clientPersonalDocumentNumberField);
    }

    public void enterClientPersonalDocumentIssuedDate(String clientPersonalDocumentDate) {
        enter(clientPersonalDocumentDate).into(clientPersonalDocumentDateField);
    }

    public void enterClientPersonalDocumentIssuedBy(String clientPersonalDocumentBy) {
        enter(clientPersonalDocumentBy).into(clientPersonalDocumentByField);
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

    //ЮРИДИЧЕСКИЙ АДРЕС

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

    //АДРЕС МЕСТОНАХОЖДЕНИЯ
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

    //ПОЧТОВЫЙ АДРЕС
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

    //БАНКОВСКИЕ РЕКВИЗИТЫ
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

    //Скан-копии документов ВТС необходимые для регистрации
    @FindBy(xpath = ".//input[@name='client[client_files][0][file]']")
    WebElementFacade clientDocumentFirstCopyField;

    @FindBy(xpath = ".//input[@name='client[client_files][1][file]']")
    WebElementFacade clientDocumentSecondCopyField;

    @FindBy(xpath = ".//input[@name='client[client_files][2][file]']")
    WebElementFacade clientDocumentThirdCopyField;

    @FindBy(xpath = ".//input[@name='client[client_files][3][file]']")
    WebElementFacade clientDocumentFourthCopyField;

    @FindBy(xpath = ".//input[@name='client[client_files][4][file]']")
    WebElementFacade clientDocumentFifthCopyField;

    @FindBy(xpath = ".//input[@name='client[client_files][5][file]']")
    WebElementFacade clientDocumentSixthCopyField;

    @FindBy(xpath = ".//input[@name='client[client_files][6][file]']")
    WebElementFacade clientDocumentSeventhCopyField;

    @FindBy(xpath = ".//input[@name='client[client_files][7][file]']")
    WebElementFacade clientDocumentEighthCopyField;

    public void uploadULDocumentsCopies(
            String filename1,
            String filename2,
            String filename3,
            String filename4
//            String filename5,
//            String filename6,
//            String filename7,
//            String filename8
    ) {

        // Меняем атрибут display у инпута, для возможности загружать файлы
        evaluateJavascript("document.getElementsByName('client[client_files][0][file]')[0].setAttribute('Style','display:block');");
        upload(filename1).to(clientDocumentFirstCopyField);

        evaluateJavascript("document.getElementsByName('client[client_files][1][file]')[0].setAttribute('Style','display:block');");
        upload(filename2).to(clientDocumentSecondCopyField);

        evaluateJavascript("document.getElementsByName('client[client_files][2][file]')[0].setAttribute('Style','display:block');");
        upload(filename3).to(clientDocumentThirdCopyField);

        evaluateJavascript("document.getElementsByName('client[client_files][3][file]')[0].setAttribute('Style','display:block');");
        upload(filename4).to(clientDocumentFourthCopyField);

//        evaluateJavascript("document.getElementsByName('client[client_files][4][file]')[0].setAttribute('Style','display:block');");
//        upload(filename5).to(clientDocumentFifthCopyField);
//
//        evaluateJavascript("document.getElementsByName('client[client_files][5][file]')[0].setAttribute('Style','display:block');");
//        upload(filename6).to(clientDocumentSixthCopyField);
//
//        evaluateJavascript("document.getElementsByName('client[client_files][6][file]')[0].setAttribute('Style','display:block');");
//        upload(filename7).to(clientDocumentSeventhCopyField);
//
//        evaluateJavascript("document.getElementsByName('client[client_files][7][file]')[0].setAttribute('Style','display:block');");
//        upload(filename8).to(clientDocumentEighthCopyField);
    }

    public void uploadIPDocumentsCopies(
            String filename1,
            String filename2
//            String filename3,
//            String filename4,
//            String filename5,
//            String filename6
    ) {

        // Меняем атрибут display у инпута, для возможности загружать файлы
        evaluateJavascript("document.getElementsByName('client[client_files][0][file]')[0].setAttribute('Style','display:block');");
        upload(filename1).to(clientDocumentFirstCopyField);

        evaluateJavascript("document.getElementsByName('client[client_files][1][file]')[0].setAttribute('Style','display:block');");
        upload(filename2).to(clientDocumentSecondCopyField);

//        evaluateJavascript("document.getElementsByName('client[client_files][2][file]')[0].setAttribute('Style','display:block');");
//        upload(filename3).to(clientDocumentThirdCopyField);
//
//        evaluateJavascript("document.getElementsByName('client[client_files][3][file]')[0].setAttribute('Style','display:block');");
//        upload(filename4).to(clientDocumentFourthCopyField);
//
//        evaluateJavascript("document.getElementsByName('client[client_files][4][file]')[0].setAttribute('Style','display:block');");
//        upload(filename5).to(clientDocumentFifthCopyField);
//
//        evaluateJavascript("document.getElementsByName('client[client_files][5][file]')[0].setAttribute('Style','display:block');");
//        upload(filename6).to(clientDocumentSixthCopyField);
    }

    public void uploadFLDocumentsCopies(String filename) {
        // Меняем атрибут display у инпута, для возможности загружать файлы
        evaluateJavascript("document.getElementsByName('client[client_files][0][file]')[0].setAttribute('Style','display:block');");
        upload(filename).to(clientDocumentFirstCopyField);
    }
}
