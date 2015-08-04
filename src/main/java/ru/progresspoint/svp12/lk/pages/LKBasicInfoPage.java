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
    WebElementFacade ownerShortNameField;

    @FindBy(id = "client_name")
    WebElementFacade ownerNameField;

    @FindBy(id = "client_inn")
    WebElementFacade ownerINNField;

    @FindBy(id = "client_ogrn")
    WebElementFacade ownerOGRNField;

    @FindBy(id = "client_main_email")
    WebElementFacade ownerMainEmailField;

    @FindBy(id = "client_main_phone")
    WebElementFacade ownerMainPhoneField;

    public void enterOwnerShortName(String ownerShortName) {
        enter(ownerShortName).into(ownerShortNameField);
    }

    public void enterOwnerName(String ownerName) {
        enter(ownerName).into(ownerNameField);
    }

    public void enterOwnerINN(String ownerINN) {
        enter(ownerINN).into(ownerINNField);
    }

    public void enterOwnerOGRN(String ownerOGRN) {
        enter(ownerOGRN).into(ownerOGRNField);
    }

    public void enterOwnerMainEmail(String ownerMainEmail) {
        enter(ownerMainEmail).into(ownerMainEmailField);
    }

    public void enterOwnerMainPhone(String ownerMainPhone) {
        enter(ownerMainPhone).into(ownerMainPhoneField);
    }

    //Юридический адрес

    @FindBy(id = "client_reg_address_post_index")
    WebElementFacade ownerRegistrationAddressIndexField;

    private static final String ownerRegistrationAddressKladrField = "client_reg_address_kladr_code";

    @FindBy(id = "client_reg_address_house")
    WebElementFacade ownerRegistrationAddressHouseField;

    @FindBy(id = "client_reg_address_housing")
    WebElementFacade ownerRegistrationAddressHousingField;

    @FindBy(id = "client_reg_address_building")
    WebElementFacade ownerRegistrationAddressBuildingField;

    @FindBy(id = "client_reg_address_room")
    WebElementFacade ownerRegistrationAddressRoomField;

    public void enterOwnerRegistrationAddressIndex(String ownerRegistrationAddressIndex) {
        enter(ownerRegistrationAddressIndex).into(ownerRegistrationAddressIndexField);
    }

    public void selectOwnerRegistrationAddressKladr(String ownerRegistrationAddressKladr) {
        enterForSelectizePlugin(ownerRegistrationAddressKladrField, ownerRegistrationAddressKladr);
    }

    public void enterOwnerRegistrationAddressHouse(String ownerRegistrationAddressHouse) {
        enter(ownerRegistrationAddressHouse).into(ownerRegistrationAddressHouseField);
    }

    public void enterOwnerRegistrationAddressHousing(String ownerRegistrationAddressHousing) {
        enter(ownerRegistrationAddressHousing).into(ownerRegistrationAddressHousingField);
    }

    public void enterOwnerRegistrationAddressBuilding(String ownerRegistrationAddressBuilding) {
        enter(ownerRegistrationAddressBuilding).into(ownerRegistrationAddressBuildingField);
    }

    public void enterOwnerRegistrationAddressRoom(String ownerRegistrationAddressRoom) {
        enter(ownerRegistrationAddressRoom).into(ownerRegistrationAddressRoomField);
    }

    //Адрес местонахождения

    @FindBy(id = "client_location_address_post_index")
    WebElementFacade ownerLocationAddressIndexField;

    private static final String ownerLocationAddressKladrField = "client_location_address_kladr_code";

    @FindBy(id = "client_location_address_house")
    WebElementFacade ownerLocationAddressHouseField;

    @FindBy(id = "client_location_address_housing")
    WebElementFacade ownerLocationAddressHousingField;

    @FindBy(id = "client_location_address_building")
    WebElementFacade ownerLocationAddressBuildingField;

    @FindBy(id = "client_location_address_room")
    WebElementFacade ownerLocationAddressRoomField;

    public void enterOwnerLocationAddressIndex(String ownerLocationAddressIndex) {
        enter(ownerLocationAddressIndex).into(ownerLocationAddressIndexField);
    }

    public void selectOwnerLocationAddressKladr(String ownerLocationAddressKladr) {
        enterForSelectizePlugin(ownerLocationAddressKladrField, ownerLocationAddressKladr);
    }

    public void enterOwnerLocationAddressHouse(String ownerLocationAddressHouse) {
        enter(ownerLocationAddressHouse).into(ownerLocationAddressHouseField);
    }

    public void enterOwnerLocationAddressHousing(String ownerLocationAddressHousing) {
        enter(ownerLocationAddressHousing).into(ownerLocationAddressHousingField);
    }

    public void enterOwnerLocationAddressBuilding(String ownerLocationAddressBuilding) {
        enter(ownerLocationAddressBuilding).into(ownerLocationAddressBuildingField);
    }

    public void enterOwnerLocationAddressRoom(String ownerLocationAddressRoom) {
        enter(ownerLocationAddressRoom).into(ownerLocationAddressRoomField);
    }

    //Почтовый адрес

    @FindBy(id = "client_postal_address_post_index")
    WebElementFacade ownerPostalAddressIndexField;

    private static final String ownerPostalAddressKladrField = "client_postal_address_kladr_code";

    @FindBy(id = "client_postal_address_house")
    WebElementFacade ownerPostalAddressHouseField;

    @FindBy(id = "client_postal_address_housing")
    WebElementFacade ownerPostalAddressHousingField;

    @FindBy(id = "client_postal_address_building")
    WebElementFacade ownerPostalAddressBuildingField;

    @FindBy(id = "client_postal_address_room")
    WebElementFacade ownerPostalAddressRoomField;

    public void enterOwnerPostalAddressIndex(String ownerPostalAddressIndex) {
        enter(ownerPostalAddressIndex).into(ownerPostalAddressIndexField);
    }

    public void selectOwnerPostalAddressKladr(String ownerPostalAddressKladr) {
        enterForSelectizePlugin(ownerPostalAddressKladrField, ownerPostalAddressKladr);
    }

    public void enterOwnerPostalAddressHouse(String ownerPostalAddressHouse) {
        enter(ownerPostalAddressHouse).into(ownerPostalAddressHouseField);
    }

    public void enterOwnerPostalAddressHousing(String ownerPostalAddressHousing) {
        enter(ownerPostalAddressHousing).into(ownerPostalAddressHousingField);
    }

    public void enterOwnerPostalAddressBuilding(String ownerPostalAddressBuilding) {
        enter(ownerPostalAddressBuilding).into(ownerPostalAddressBuildingField);
    }

    public void enterOwnerPostalAddressRoom(String ownerPostalAddressRoom) {
        enter(ownerPostalAddressRoom).into(ownerPostalAddressRoomField);
    }

    //Банковские реквизиты

    @FindBy(id = "client_settlement_account_bank_name")
    WebElementFacade ownerBankNameField;

    @FindBy(id = "client_settlement_account_bik")
    WebElementFacade ownerBankBIKField;

    @FindBy(id = "client_settlement_account_inn")
    WebElementFacade ownerBankINNField;

    @FindBy(id = "client_settlement_account_kor_num")
    WebElementFacade ownerBankKorNumberField;

    @FindBy(id = "client_settlement_account_account_num")
    WebElementFacade ownerBankAccountNumberField;

    @FindBy(id = "client_settlement_account_receiver_name")
    WebElementFacade ownerBankReceiverNameField;

    public void enterOwnerBankName(String ownerBankName) {
        enter(ownerBankName).into(ownerBankNameField);
    }

    public void enterOwnerBankBIK(String ownerBankBIK) {
        enter(ownerBankBIK).into(ownerBankBIKField);
    }

    public void enterOwnerBankINN(String ownerBankINN) {
        enter(ownerBankINN).into(ownerBankINNField);
    }

    public void enterOwnerBankKorNumber(String ownerBankKorNumber) {
        enter(ownerBankKorNumber).into(ownerBankKorNumberField);
    }

    public void enterOwnerBankAccountNumber(String ownerBankAccountNumber) {
        enter(ownerBankAccountNumber).into(ownerBankAccountNumberField);
    }

    public void enterOwnerBankReceiverName(String ownerBankReceiverName) {
        enter(ownerBankReceiverName).into(ownerBankReceiverNameField);
    }
}
