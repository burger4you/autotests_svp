package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница Регистрация ВТС
 */
@At("#HOST/clients/draft")
public class CPPOwnerRegistrationPage extends CPPSelectizePageObject {

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

    public void selectOwnerType(String clientType) {
        selectForSelectizePlugin(clientTypeDropDown, clientType);
    }

    public void selectOwnerCountry(String clientCountry) {
        selectForSelectizePlugin(clientCountryDropDown, clientCountry);
    }

    public void enterClientFullName(String clientSurname, String clientName, String clientPatronymic) {
        enter(clientSurname).into(clientSurnameField);
        enter(clientName).into(clientNameField);
        enter(clientPatronymic).into(clientPatronymicField);
    }

    public void enterClientBirthday(String clientBirthday) {
        enter(clientBirthday).into(clientBirthdayField);
    }

    public void enterClientPassportData(String passportSeriesAndNumber, String passportIssuedBy, String passportIssuedWhen) {
        enter(passportSeriesAndNumber).into(clientSeriesAndNumberPassportField);
        enter(passportIssuedBy).into(clientIssuedByPassportField);
        enter(passportIssuedWhen).into(clientIssuedWhenPassportField);
    }

    public void enterClientIndex(String addressIndex) {
        enter(addressIndex).into(clientAddressIndexField);
    }

    public void enterClientCityAndStreet(String addressCityAndStreet) {
        enterForSelectizePlugin(clientAddressCityAndStreetDropDown, addressCityAndStreet);
    }

    public void enterClientHome(String addressHouse) {
        enter(addressHouse).into(clientAddressHouseField);
    }

    public void enterClientApartment(String addressApartment) {
        enter(addressApartment).into(clientAddressApartmentField);
    }

    public void selectActualClientAddressSameAsRegistration() {
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

    public boolean displayedInviteToRegistrationVehicle() {
        registrationVehicleButton.waitUntilPresent();
        return registrationVehicleButton.isEnabled();
    }
}
