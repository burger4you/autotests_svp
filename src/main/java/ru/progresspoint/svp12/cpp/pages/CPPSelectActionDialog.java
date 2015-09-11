package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

import static java.lang.String.format;

/**
 * Окно выбора действия, отображающееся при входе в АРМ ЦИПП
 */
@At("#HOST/#")
public class CPPSelectActionDialog extends CPPSelectizePageObject {

    private static final String clientCountryDropDown = "country_id";
    private static final String clientTypeDropDown = "client_type_id";

    @FindBy(xpath = "//*[@id='start-work-modal']//li[1]/a")
    WebElementFacade registrationClientLink;

    @FindBy(xpath = ".//button[text()='Зарегистрировать']")
    WebElementFacade registrationButton;

    @FindBy(xpath = "//*[@id='start-work-modal']//li[2]/a")
    WebElementFacade searchClientLink;

    @FindBy(xpath = ".//*[@id='global_client_search']/..//input")
    WebElementFacade clientSearchField;

    public void selectClientCountry(String clientCountry) {
        selectForSelectizePlugin(clientCountryDropDown, clientCountry);
    }

    public void selectClientType(String clientType) {
        selectForSelectizePlugin(clientTypeDropDown, clientType);
    }

    public void clickToOwnerRegistrationLink() {
        registrationClientLink.click();
    }

    public void clickToRegistrationButton() {
        registrationButton.click();
    }

    public void clickToSearchClientButton() {
        searchClientLink.click();
    }

    public void enterSearchClientQuery(String query) {
        enter(query).into(clientSearchField);
    }

    public void shouldContainSearchedClient(String query) {
        $(format(".//*[@id='start-work-modal']//*[text()='%s']", query)).shouldBeEnabled();
    }

    public void clickToSearchedClient(String query) {
        $(format(".//*[@id='start-work-modal']//*[text()='%s']", query)).click();
    }

    public void selectContactPerson() {
        $(".//*[@id='sub_person_search']/..//input").click();
        waitABit(500);
        $(".//*[@id='sub_person_search']/..//div[@class='option'][1]").click();
    }
}