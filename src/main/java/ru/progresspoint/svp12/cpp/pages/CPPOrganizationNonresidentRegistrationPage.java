package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница Регистрации ВТС - юридическое лицо, нерезидент РФ
 */
@At("#HOST/clients/draft")
public class CPPOrganizationNonresidentRegistrationPage extends CPPSelectizePageObject {

    //ПОЛНЫЙ АДРЕС В СТРАНЕ РЕГИСТРАЦИИ
    private static final String organizationRegistrationCountryField = "client_reg_address_attributes_country_id";

    @FindBy(id = "client_reg_address_attributes_address")
    WebElementFacade organizationRegistrationAddressField;

    public void selectOrganizationRegistrationCountry(String organizationRegistrationCountry) {
        selectForSelectizePlugin(organizationRegistrationCountryField, organizationRegistrationCountry);
    }

    public void enterOrganizationRegistrationAddress(String organizationRegistrationAddress) {
        enter(organizationRegistrationAddress).into(organizationRegistrationAddressField);
    }
}
