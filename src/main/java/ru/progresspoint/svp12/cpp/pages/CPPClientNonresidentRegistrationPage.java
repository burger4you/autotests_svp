package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница Регистрации ВТС - физическое лицо, нерезидент РФ
 */
@At("#HOST/clients/draft")
public class CPPClientNonresidentRegistrationPage extends CPPSelectizePageObject {

    //ПОЛНЫЙ АДРЕС В СТРАНЕ РЕГИСТРАЦИИ
    private static final String clientRegistrationCountryField = "client_fl_persons_attributes_0_reg_address_attributes_country_id";

    @FindBy(id = "client_fl_persons_attributes_0_reg_address_attributes_address")
    WebElementFacade clientRegistrationAddressField;

    public void selectClientRegistrationCountry(String clientRegistrationCountry) {
        selectForSelectizePlugin(clientRegistrationCountryField, clientRegistrationCountry);
    }

    public void enterClientRegistrationAddress(String clientRegistrationAddress) {
        enter(clientRegistrationAddress).into(clientRegistrationAddressField);
    }
}
