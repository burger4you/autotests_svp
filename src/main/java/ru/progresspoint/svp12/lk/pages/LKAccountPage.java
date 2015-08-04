package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Страница ввода данных учетной записи при регистрации
 */
@DefaultUrl("http://lk-stage.progresspoint.ru/registration")
public class LKAccountPage extends LKSelectizePageObject {

    @FindBy(id = "registration_login")
    WebElementFacade registrationLoginField;

    @FindBy(id = "registration_phone")
    WebElementFacade registrationPhoneField;

    @FindBy(id = "registration_position")
    WebElementFacade registrationPositionField;

    @FindBy(id = "registration_last_name")
    WebElementFacade registrationSurnameField;

    @FindBy(id = "registration_first_name")
    WebElementFacade registrationNameField;

    @FindBy(id = "registration_middle_name")
    WebElementFacade registrationPatronymicField;

    @FindBy(id = "registration_document_num")
    WebElementFacade registrationDocumentNumberField;

    @FindBy(id = "registration_document_issued_date")
    WebElementFacade registrationDocumentIssuedDateField;

    @FindBy(id = "registration_document_issued_by")
    WebElementFacade registrationDocumentIssuedByField;

    @FindBy(id = "captcha")
    WebElementFacade captchaField;

    private static final String ownerDocumentTypeField = "registration_document_document_type";
    private static final String ownerTypeField = "registration_client_type_id";
    private static final String ownerCountryField = "registration_country_id";

    public void enterRegistrationLogin(String registrationLogin) {
        enter(registrationLogin).into(registrationLoginField);
    }

    public void enterRegistrationPhone(String registrationPhone) {
        enter(registrationPhone).into(registrationPhoneField);
    }

    public void enterRegistrationPosition(String registrationPosition) {
        enter(registrationPosition).into(registrationPositionField);
    }

    public void enterRegistrationSurname(String registrationSurname) {
        enter(registrationSurname).into(registrationSurnameField);
    }

    public void enterRegistrationName(String registrationName) {
        enter(registrationName).into(registrationNameField);
    }

    public void enterRegistrationPatronymic(String registrationPatronymic) {
        enter(registrationPatronymic).into(registrationPatronymicField);
    }

    public void selectRegistrationDocumentType(String ownerDocumentType) {
        selectForSelectizePlugin(ownerDocumentTypeField, ownerDocumentType);
    }

    public void enterRegistrationDocumentNumber(String registrationDocumentNumber) {
        enter(registrationDocumentNumber).into(registrationDocumentNumberField);
    }

    public void enterRegistrationDocumentIssuedDate(String registrationDocumentIssuedDate) {
        enter(registrationDocumentIssuedDate).into(registrationDocumentIssuedDateField);
    }

    public void enterRegistrationDocumentIssuedBy(String registrationDocumentIssuedBy) {
        enter(registrationDocumentIssuedBy).into(registrationDocumentIssuedByField);
    }

    public void selectOwnerType(String ownerType) {
        selectForSelectizePlugin(ownerTypeField, ownerType);
    }

    public void selectOwnerCountry(String ownerCountry) {
        selectForSelectizePlugin(ownerCountryField, ownerCountry);
    }

    public void enterCaptcha(String captcha) {
        enter(captcha).into(captchaField);
    }
}
