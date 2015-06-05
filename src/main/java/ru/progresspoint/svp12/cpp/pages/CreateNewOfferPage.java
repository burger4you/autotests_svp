package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница создания нового договора
 */
@At("http://localhost:3000/clients/.*/draft")
public class CreateNewOfferPage extends PageObject {

    @FindBy(id = "client_client_type_id")
    WebElementFacade clientTypeDropDown;

    @FindBy(id = "client_country_id")
    WebElementFacade clientCountryDropDown;

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

    public void selectClientType(String clientType) {
        selectFromDropdown(clientTypeDropDown, clientType);
    }

    public void selectClientCountry(String clientCountry) {
        selectFromDropdown(clientCountryDropDown, clientCountry);
    }

    public void enterOwnerFullName(String clientSurname, String clientName, String clientPatronymic) {
        enter(clientSurname).into(clientSurnameField);
        enter(clientName).into(clientNameField);
        enter(clientPatronymic).into(clientPatronymicField);
    }

    public void enterOwnerBirthday(String clientBirthday) {
        enter(clientBirthday).into(clientBirthdayField);
    }

    public void enterOwnerPassportData(String passportSeriesAndNumber, String passportIssuedBy, String passportIssuedWhen) {
        enter(passportSeriesAndNumber).into(clientSeriesAndNumberPassportField);
        enter(passportIssuedBy).into(clientIssuedByPassportField);
        enter(passportIssuedWhen).into(clientIssuedWhenPassportField);
    }
}
