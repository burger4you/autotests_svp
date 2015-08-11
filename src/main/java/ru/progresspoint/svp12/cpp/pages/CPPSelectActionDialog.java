package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Окно ЦИПП Выберите действие, отображающиеся при входе в арм
 */
@At("#HOST/#")
public class CPPSelectActionDialog extends CPPSelectizePageObject {

    private static final String clientCountryDropDown = "country_id";
    private static final String clientTypeDropDown = "client_type_id";

    @FindBy(linkText = "Регистрация нового ВТС")
    WebElementFacade registrationClientLink;

    @FindBy(xpath = ".//button[text()='Зарегистрировать']")
    WebElementFacade registrationButton;

    public void selectClientCountry(String clientCountry) {
        selectForSelectizePlugin(clientCountryDropDown, clientCountry);
    }

    public void selectClientType(String clientType) {
        selectForSelectizePlugin(clientTypeDropDown, clientType);
    }

    public void clickOwnerRegistrationLink() {
        registrationClientLink.click();
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }
}