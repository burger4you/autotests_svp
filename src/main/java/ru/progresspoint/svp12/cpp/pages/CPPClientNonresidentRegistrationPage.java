package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница Регистрации ВТС - физическое лицо, нерезидент РФ
 */
@At("#HOST/clients/draft")
public class CPPClientNonresidentRegistrationPage extends CPPSelectizePageObject {

    //АДРЕС РЕГИСТРАЦИИ
    private static final String clientRegistrationCountryField = "client_fl_persons_attributes_0_reg_address_attributes_country_id";

    @FindBy(id = "client_fl_persons_attributes_0_reg_address_attributes_address")
    WebElementFacade clientRegistrationAddressField;

    public void selectClientRegistrationCountry(String clientRegistrationCountry) {
        selectForSelectizePlugin(clientRegistrationCountryField, clientRegistrationCountry);
    }

    public void enterClientRegistrationAddress(String clientRegistrationAddress) {
        enter(clientRegistrationAddress).into(clientRegistrationAddressField);
    }

    //АДРЕС МЕСТОНАХОЖДЕНИЯ
    @FindBy(xpath = ".//*[@for='client_fl_persons_attributes_0_location_address_attributes_same_as_reg']/div")
    WebElementFacade clientLocationAddressSameAsClientRegistrationCheckBox;

    private static final String clientLocationCountryField = "client_fl_persons_attributes_0_location_address_attributes_country_id";

    @FindBy(id = "client_fl_persons_attributes_0_location_address_attributes_address")
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
    @FindBy(xpath = ".//*[@for='client_fl_persons_attributes_0_postal_address_attributes_same_as_reg']/div")
    WebElementFacade clientPostalAddressSameAsClientRegistrationCheckBox;

    private static final String clientPostalCountryField = "client_fl_persons_attributes_0_postal_address_attributes_country_id";

    @FindBy(id = "client_fl_persons_attributes_0_postal_address_attributes_address")
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
