package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница Регистрация ВТС
 */
@At("#HOST/clients/draft")
public class OwnerRegistrationPage extends PageObject {

    static final String DROP_DOWN_XPATH = ".//*[@id='%s']/..//*[@class='item']";
    static final String DROP_DOWN_ITEM_XPATH = ".//*[@class='selectize-dropdown-content']/*[text()='%s']";
    static final String INPUT_XPATH = ".//*[@id='%s']/.//*[@class='selectize-input items not-full']/input";
    static final String INPUT_ITEM_XPATH = ".//*[@id='%s']/.//div[@class='selectize-dropdown-content']/div[1]";

    String clientTypeDropDown = "client_client_type_id";
    String clientCountryDropDown = "client_country_id";
    String clientAddressCityAndStreetDropDown = "reg_address";

    @FindBy(id = "client_fl_persons_attributes_0_surname")
    WebElementFacade clientSurnameField;

    @FindBy(id = "client_fl_persons_attributes_0_name")
    WebElementFacade clientNameField;

    @FindBy(id = "client_fl_persons_attributes_0_patronymic")
    WebElementFacade clientPatronymicField;

    @FindBy(id = "client_fl_persons_attributes_0_birthday")
    WebElementFacade clientBirthdayField;

    @FindBy(id = "client_fl_persons_attributes_0_passport_attributes_passport_ser_and_num")
    WebElementFacade clientSeriesAndNumberPassportField;

    @FindBy(id = "client_fl_persons_attributes_0_passport_attributes_issued")
    WebElementFacade clientIssuedByPassportField;

    @FindBy(id = "client_fl_persons_attributes_0_passport_attributes_issue_date")
    WebElementFacade clientIssuedWhenPassportField;

    @FindBy(id = "client_fl_persons_attributes_0_reg_address_attributes_post_index")
    WebElementFacade clientAddressIndexField;

    @FindBy(id = "client_fl_persons_attributes_0_reg_address_attributes_house")
    WebElementFacade clientAddressHouseField;

    @FindBy(id = "client_fl_persons_attributes_0_reg_address_attributes_room")
    WebElementFacade clientAddressApartmentField;

    @FindBy(xpath = ".//*[@for='client_fl_persons_attributes_0_postal_address_attributes_same_as_reg']")
    WebElementFacade clientActualAddressSameAsRegistrationCheckbox;

    @FindBy(id = "client_contact_persons_attributes_0_surname")
    WebElementFacade contactSurnameField;

    @FindBy(id = "client_contact_persons_attributes_0_name")
    WebElementFacade contactNameField;

    @FindBy(id = "client_contact_persons_attributes_0_patronymic")
    WebElementFacade contactPatronymicField;

    @FindBy(id = "client_contact_persons_attributes_0_main_phone_attributes_name")
    WebElementFacade contactMainPhoneField;

    @FindBy(id = "client_contact_persons_attributes_0_main_email_attributes_name")
    WebElementFacade contactMainEmailField;

    @FindBy(xpath = "//*[@class='register-contract-btn']")
    WebElementFacade registrationButton;

    @FindBy(id = "register-ts-button", timeoutInSeconds = "20")
    WebElementFacade registrationVehicleButton;

    @FindBy(linkText = "Контактная информация")
    WebElementFacade contactInfoMenuItem;

    public void selectClientType(String clientType) {
        selectForSelectizePlugin(clientTypeDropDown, clientType);
    }

    public void selectClientCountry(String clientCountry) {
        selectForSelectizePlugin(clientCountryDropDown, clientCountry);
    }

    public void enterOwnerFullName(String clientSurname, String clientName, String clientPatronymic) {
        enter(clientSurname).into(clientSurnameField);
        enter(clientName).into(clientNameField);
        enter(clientPatronymic).into(clientPatronymicField);
    }

    public void enterOwnerBirthday(String clientBirthday) {
        enter(clientBirthday).into(clientBirthdayField);
    }

    public void enterOwnerPassportData(String passportSeriesAndNumber, String passportIssuedBy, String passportIssuedWhen) {
        enter(passportSeriesAndNumber).into(clientSeriesAndNumberPassportField);
        enter(passportIssuedBy).into(clientIssuedByPassportField);
        enter(passportIssuedWhen).into(clientIssuedWhenPassportField);
    }

    public void enterOwnerIndex(String addressIndex) {
        enter(addressIndex).into(clientAddressIndexField);
    }

    public void enterOwnerCityAndStreet(String addressCityAndStreet) {
        enterForSelectizePlugin(clientAddressCityAndStreetDropDown, addressCityAndStreet);
    }

    public void enterOwnerHome(String addressHouse) {
        enter(addressHouse).into(clientAddressHouseField);
    }

    public void enterOwnerApartment(String addressApartment) {
        enter(addressApartment).into(clientAddressApartmentField);
    }

    public void setActualAddressSameAsRegistration() {
        clientActualAddressSameAsRegistrationCheckbox.click();
    }

    public void clickContactInfoMenuItem() {
        contactInfoMenuItem.click();
    }

    public void enterContactFullName(String contactSurname, String contactName, String contactPatronymic) {
        enter(contactSurname).into(contactSurnameField);
        enter(contactName).into(contactNameField);
        enter(contactPatronymic).into(contactPatronymicField);
    }

    public void enterContactMainPhone(String contactMainPhone) {
        enter(contactMainPhone).into(contactMainPhoneField);
    }

    public void enterContactMainEmail(String contactMainEmail) {
        enter(contactMainEmail).into(contactMainEmailField);
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }

    private void selectForSelectizePlugin(String selectId, String selectingValue) {
        findBy(String.format(DROP_DOWN_XPATH, selectId)).click();
        waitFor(String.format(DROP_DOWN_ITEM_XPATH, selectingValue));
        findBy(String.format(DROP_DOWN_ITEM_XPATH, selectingValue)).click();
    }

    private void enterForSelectizePlugin(String inputId, String inputtingValue) {
        enter(inputtingValue).into(findBy(String.format(INPUT_XPATH, inputId)));
        waitFor(String.format(INPUT_ITEM_XPATH, inputId));
        findBy(String.format(INPUT_ITEM_XPATH, inputId)).click();
    }

    public boolean displayedInviteToRegistrationVehicle() {
        registrationVehicleButton.waitUntilPresent();
        return registrationVehicleButton.isEnabled();
    }
}
