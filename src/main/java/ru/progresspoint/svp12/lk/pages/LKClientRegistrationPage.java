package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Страница ввода основной информации о Владельце ТС для физического лица
 */
@DefaultUrl("http://lk-stage.progresspoint.ru/registration")
public class LKClientRegistrationPage extends LKSelectizePageObject {

    @FindBy(id = "client_login")
    WebElementFacade registrationLoginField;

    @FindBy(id = "client_phone")
    WebElementFacade registrationPhoneField;

//    @FindBy(id = "registration_position")
//    WebElementFacade registrationPositionField;

    @FindBy(id = "client_last_name")
    WebElementFacade registrationSurnameField;

    @FindBy(id = "client_first_name")
    WebElementFacade registrationNameField;

    @FindBy(id = "client_middle_name")
    WebElementFacade registrationPatronymicField;

    private static final String ownerDocumentTypeField = "client_document_doc_type_id";

    @FindBy(id = "client_document_passport_ser_and_num")
    WebElementFacade registrationDocumentNumberField;

    @FindBy(id = "client_document_issue_date")
    WebElementFacade registrationDocumentIssuedDateField;

    @FindBy(id = "client_document_issued")
    WebElementFacade registrationDocumentIssuedByField;

    @FindBy(xpath = ".//*[@id='client[is_agree_person_data]']/..//i")
    WebElementFacade agreePersonDataCheckBox;

    @FindBy(xpath = ".//*[@id='client[is_agree_service_conditions]']/..//i")
    WebElementFacade agreeServiceCheckBox;

    @FindBy(id = "captcha")
    WebElementFacade captchaField;

    public void loading() {
        registrationLoginField.shouldBeEnabled();
        registrationPhoneField.shouldBeEnabled();
    }

    public void enterRegistrationLogin(String registrationLogin) {
        enter(registrationLogin).into(registrationLoginField);
    }

    public void enterRegistrationPhone(String registrationPhone) {
        enter(registrationPhone).into(registrationPhoneField);
    }

//    public void enterRegistrationPosition(String registrationPosition) {
//        enter(registrationPosition).into(registrationPositionField);
//    }

    public void enterRegistrationSurname(String registrationSurname) {
        enter(registrationSurname).into(registrationSurnameField);
    }

    public void enterRegistrationName(String registrationName) {
        enter(registrationName).into(registrationNameField);
    }

    public void enterRegistrationPatronymic(String registrationPatronymic) {
        enter(registrationPatronymic).into(registrationPatronymicField);
    }

    public void clickToAgreePersonDataCheckBox() {
        agreePersonDataCheckBox.click();
    }

    public void clickToAgreeServiceCheckBox() {
        agreeServiceCheckBox.click();
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

    public void enterCaptcha(String captcha) {
        enter(captcha).into(captchaField);
    }
}
