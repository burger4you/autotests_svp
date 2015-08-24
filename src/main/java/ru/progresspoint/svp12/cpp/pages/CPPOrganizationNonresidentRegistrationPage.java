package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница Регистрации ВТС - юридическое лицо, нерезидент РФ
 */
@At("#HOST/clients/draft")
public class CPPOrganizationNonresidentRegistrationPage extends CPPSelectizePageObject {

    //ДАННЫЕ ЮРИДИЧЕСКОГО ЛИЦА
    private static final String organizationOPFField = "client_okopf_id";

    @FindBy(id = "client_country_reg_num")
    WebElementFacade registrationNumberField;

    @FindBy(id = "client_country_reg_organ")
    WebElementFacade registrationOrganField;

    @FindBy(id = "client_country_nalog_num")
    WebElementFacade taxNumberField;

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

    public void enterRegistrationNumber(String registrationNumber) {
        enter(registrationNumber).into(registrationNumberField);
    }

    public void enterRegistrationOrgan(String registrationOrgan) {
        enter(registrationOrgan).into(registrationOrganField);
    }

    public void enterTaxNumber(String taxNumber) {
        enter(taxNumber).into(taxNumberField);
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

    //АДРЕС РЕГИСТРАЦИИ
    private static final String clientRegistrationCountryField = "client_location_address_attributes_country_id";

    @FindBy(id = "client_reg_address_attributes_address")
    WebElementFacade clientRegistrationAddressField;

    public void selectClientRegistrationCountry(String clientRegistrationCountry) {
        selectForSelectizePlugin(clientRegistrationCountryField, clientRegistrationCountry);
    }

    public void enterClientRegistrationAddress(String clientRegistrationAddress) {
        enter(clientRegistrationAddress).into(clientRegistrationAddressField);
    }

    //АДРЕС МЕСТОНАХОЖДЕНИЯ
    @FindBy(xpath = ".//*[@id='client_location_address_attributes_same_as_reg']/..//div")
    WebElementFacade clientLocationAddressSameAsClientRegistrationCheckBox;

    private static final String clientLocationCountryField = "client_reg_address_attributes_country_id";

    @FindBy(id = "client_location_address_attributes_address")
    WebElementFacade locationAddressField;


    public void clickToLocationAddressSameAsRegistrationCheckBox() {
        clientLocationAddressSameAsClientRegistrationCheckBox.click();
    }

    public void selectClientLocationCountry(String clientLocationCountry) {
        selectForSelectizePlugin(clientLocationCountryField, clientLocationCountry);
    }

    public void enterClientLocationAddress(String locationAddress) {
        enter(locationAddress).into(locationAddressField);
    }

    //ПОЧТОВЫЙ АДРЕС
    @FindBy(xpath = ".//*[@id='client_postal_address_attributes_same_as_reg']/..//div")
    WebElementFacade clientPostalAddressSameAsClientRegistrationCheckBox;

    private static final String clientPostalCountryField = "client_postal_address_attributes_country_id";

    @FindBy(id = "client_postal_address_attributes_address")
    WebElementFacade postalAddressField;


    public void clickToPostalAddressSameAsRegistrationCheckBox() {
        clientPostalAddressSameAsClientRegistrationCheckBox.click();
    }

    public void selectClientPostalCountry(String clientPostalCountry) {
        selectForSelectizePlugin(clientPostalCountryField, clientPostalCountry);
    }

    public void enterClientPostalAddress(String postalAddress) {
        enter(postalAddress).into(postalAddressField);
    }
}
