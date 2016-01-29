package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import org.openqa.selenium.WebElement;

/**
 * Страница Регистрации ВТС - физическое лицо
 */
@At("#HOST/clients/draft")
public class CPPClientRegistrationPage extends CPPSelectizePageObject {

    //ЛИЧНЫЕ ДАННЫЕ ВЛАДЕЛЬЦА
    private static final String clientDocumentTypeField = "client_fl_persons_attributes_0_certify_doc_attributes_doc_type_id_or_name";
    private static final String clientRoleField = "client_fl_persons_attributes_0_contact_role";
    private static final String clientLanguageField = "client_language_id";

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_certify_doc_attributes_passport_ser_and_num']")
    WebElementFacade clientDocumentNumberField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_certify_doc_attributes_issued']")
    WebElementFacade clientDocumentByField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_certify_doc_attributes_issue_date']")
    WebElementFacade clientDocumentDateField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_certify_doc_attributes_issue_code']")
    WebElementFacade clientDocumentCodeField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_surname']")
    WebElementFacade clientSurnameField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_name']")
    WebElementFacade clientNameField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_patronymic']")
    WebElementFacade clientPatronymicField;

    @FindBy(xpath = ".//input[@id='client_inn']")
    WebElementFacade clientINNField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_main_phone_attributes_name']")
    WebElementFacade clientPhoneField;

    @FindBy(xpath = ".//input[@id='client_fl_persons_attributes_0_main_email_attributes_name']")
    WebElementFacade clientEmailField;

    public void selectClientDocumentType(String clientDocumentType) {
        selectForSelectizePlugin(clientDocumentTypeField, clientDocumentType);
    }

    public void enterClientDocumentNumber(String clientDocumentNumber) {
        enter(clientDocumentNumber).into(clientDocumentNumberField);
    }

    public void enterClientDocumentIssuedBy(String clientDocumentBy) {
        enter(clientDocumentBy).into(clientDocumentByField);
    }

    public void enterClientDocumentIssuedDate(String clientDocumentDate) {
        enter(clientDocumentDate).into(clientDocumentDateField);
    }

    public void enterClientDocumentIssuedCode(String clientDocumentCode) {
        enter(clientDocumentCode).into(clientDocumentCodeField);
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

    public void enterClientINN(String clientINN) {
        enter(clientINN).into(clientINNField);
    }

    public void enterClientEmail(String clientEmail) {
        enter(clientEmail).into(clientEmailField);
    }

    public void enterClientPhone(String clientPhone) {
        enter(clientPhone).into(clientPhoneField);
    }

    public void selectClientRole(String clientRole) {
        selectForSelectizePlugin(clientRoleField, clientRole);
    }

    public void selectClientLanguage(String clientLanguage) {
        selectForSelectizePlugin(clientLanguageField, clientLanguage);
    }

    //АДРЕС РЕГИСТРАЦИИ ПО МЕСТУ ЖИТЕЛЬСТВА
    private static final String clientAddressRegionField = "client_fl_persons_attributes_0_reg_address_attributes_region";
    private static final String clientAddressDistrictField = "client_fl_persons_attributes_0_reg_address_attributes_district";
    private static final String clientAddressCityField = "client_fl_persons_attributes_0_reg_address_attributes_city";
    private static final String clientAddressSettlementField = "client_fl_persons_attributes_0_reg_address_attributes_settlement";
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
        if (!clientAddressDistrict.isEmpty())
            enterForSelectizePlugin(clientAddressDistrictField, clientAddressDistrict);
    }

    public void selectClientRegistrationAddressCity(String clientAddressCity) {
        if (!clientAddressCity.isEmpty()) enterForSelectizePlugin(clientAddressCityField, clientAddressCity);
    }

    public void selectClientRegistrationAddressSettlement(String clientAddressSettlement) {
        if (!clientAddressSettlement.isEmpty())
            enterForSelectizePlugin(clientAddressSettlementField, clientAddressSettlement);
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

    //АДРЕС ПО МЕСТУ ПРЕБЫВАНИЯ
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
        if (!locationAddressRegion.isEmpty())
            enterForSelectizePlugin(locationAddressRegionField, locationAddressRegion);
    }

    public void selectClientLocationAddressDistrict(String locationAddressDistrict) {
        if (!locationAddressDistrict.isEmpty())
            enterForSelectizePlugin(locationAddressDistrictField, locationAddressDistrict);
    }

    public void selectClientLocationAddressCity(String locationAddressCity) {
        if (!locationAddressCity.isEmpty()) enterForSelectizePlugin(locationAddressCityField, locationAddressCity);
    }

    public void selectClientLocationAddressSettlement(String locationAddressSettlement) {
        if (!locationAddressSettlement.isEmpty())
            enterForSelectizePlugin(locationAddressSettlementField, locationAddressSettlement);
    }

    public void selectClientLocationAddressStreet(String locationAddressStreet) {
        if (!locationAddressStreet.isEmpty())
            enterForSelectizePlugin(locationAddressStreetField, locationAddressStreet);
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

    //ЛИЦЕВОЙ СЧЕТ
    @FindBy(id = "client_accounts_attributes_0_name")
    WebElementFacade clientAccountNameField;

    @FindBy(xpath = ".//*[@class='string optional name-account 0 required form-control']")
    WebElementFacade clientSecondAccountNameField;

    @FindBy(id = "client_accounts_attributes_0_num")
    WebElementFacade clientAccountNumberField;

    public void enterClientAccountName(String clientAccountName) {
        enter(clientAccountName).into(clientAccountNameField);
    }

    public void enterClientSecondAccountName(String clientSecondAccountName) {
        enter(clientSecondAccountName).into(clientSecondAccountNameField);
    }

    public String getClientAccountNumber() {
        return clientAccountNumberField.getValue();
    }

    //РАСЧЕТНЫЙ СЧЕТ
    @FindBy(id = "client_client_settlement_account_attributes_account_num")
    WebElementFacade clientBankAccountNumberField;

    @FindBy(id = "client_client_settlement_account_attributes_receiver_name")
    WebElementFacade clientBankReceiverNameField;

    @FindBy(id = "client_client_settlement_account_attributes_bik")
    WebElementFacade clientBankBIKField;

    @FindBy(id = "client_client_settlement_account_attributes_bank_name")
    WebElementFacade clientBankNameField;

    @FindBy(id = "client_client_settlement_account_attributes_kor_num")
    WebElementFacade clientBankKorNumberField;

    @FindBy(id = "client_client_settlement_account_attributes_swift")
    WebElementFacade clientBankSWIFTField;

    public void enterClientBankAccountNumber(String clientBankAccountNumber) {
        enter(clientBankAccountNumber).into(clientBankAccountNumberField);
    }

    public void enterClientBankReceiverName(String clientBankReceiverName) {
        enter(clientBankReceiverName).into(clientBankReceiverNameField);
    }

    public void enterClientBankBIK(String clientBankBIK) {
        enter(clientBankBIK).into(clientBankBIKField);
    }

    public void enterClientBankName(String clientBankName) {
        enter(clientBankName).into(clientBankNameField);
    }

    public void enterClientBankKorNumber(String clientBankKorNumber) {
        enter(clientBankKorNumber).into(clientBankKorNumberField);
    }

    public void enterClientBankSWIFT(String clientBankSWIFT) {
        enter(clientBankSWIFT).into(clientBankSWIFTField);
    }

    private void clickOnInvisibleElement(WebElement element) {
        String script = "var object = arguments[0];"
                + "var theEvent = document.createEvent(\"MouseEvent\");"
                + "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "object.dispatchEvent(theEvent);";
        getJavascriptExecutorFacade().executeScript(script, element);
    }
}
