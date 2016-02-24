package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Страница выбора типа и резиденства Владельце ТС при регистрации
 */
@DefaultUrl("http://lk-stage.progresspoint.ru/registration")
public class LKStartRegistrationPage extends LKSelectizePageObject {

    @FindBy(xpath = ".//*[@type='submit']")
    WebElementFacade submitButton;

    private static final String ownerTypeField = "client_client_type_id";
    private static final String ownerCountryField = "client_country_id";

    public void selectClientType(String ownerType) {
        selectForSelectizePlugin(ownerTypeField, ownerType);
    }

    public void selectClientCountry(String ownerCountry) {
        selectForSelectizePlugin(ownerCountryField, ownerCountry);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
