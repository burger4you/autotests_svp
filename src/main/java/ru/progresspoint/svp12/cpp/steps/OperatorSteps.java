package ru.progresspoint.svp12.cpp.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.progresspoint.svp12.cpp.pages.OwnerRegistrationPage;
import ru.progresspoint.svp12.cpp.pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorSteps extends ScenarioSteps {

    LoginPage loginPage;
    OwnerRegistrationPage ownerRegistrationPage;

    @Step("Открывает страницу {0}")
    public void opensPage(String page) {
        switch (page) {
            case "Авторизация"             : loginPage.open(); break;
            case "Регистрация"             : ownerRegistrationPage.open(); break;
        }
    }

    @Step("Находится на странице {0}")
    public void isOnPage(String page) {
        switch (page) {
            case "Авторизация"             : loginPage.shouldBeDisplayed(); break;
            case "Регистрация"             : ownerRegistrationPage.shouldBeDisplayed(); break;
        }
    }

    @Step("Вводит логин {0} и пароль {1}")
    public void entersLoginAndPassword(String login, String password) {
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
    }

    @Step("Жмет кнопку Войти")
    public void clickLoginButton() {
        loginPage.clickConfirmButton();
    }

    @Step("Заголовок вкладки меняется на {0}")
    public boolean isOnSystem(String title) {
        waitABit(3000);
        return getDriver().getTitle().equals(title);
    }

    @Step("Выбирает тип клиента {0}")
    public void setsClientType(String clientType) {
        ownerRegistrationPage.selectClientType(clientType);
    }

    @Step("Выбирает резидентство {0}")
    public void setsClientResidence(String clientCountry) {
        ownerRegistrationPage.selectClientCountry(clientCountry);
    }

    @Step("Вводит ФИО клиента {0} {1} {2}")
    public void fillsClientPersonalData(String clientSurname,
                                        String clientName,
                                        String clientPatronymic) {
        ownerRegistrationPage.enterOwnerFullName(clientSurname, clientName, clientPatronymic);
    }

    @Step("Вводит дату рожденя {0}")
    public void fillsClientBirthday(String clientBirthday) {
        ownerRegistrationPage.enterOwnerBirthday(clientBirthday);
    }

    @Step("Вводит серию и номер паспорта {0} кем и когда выдан {1} {2}")
    public void fillsClientPassportData(String passportSeriesAndNumber,
                                        String passportIssuedBy,
                                        String passportIssuedWhen) {
        ownerRegistrationPage.enterOwnerPassportData(passportSeriesAndNumber, passportIssuedBy, passportIssuedWhen);
    }

    @Step("Вводит адрес {0}, {1}, д.{2}, кв.{3}")
    public void fillsClientAddressData(String addressIndex,
                                       String addressCityAndStreet,
                                       String addressHouse,
                                       String addressApartment) {
        ownerRegistrationPage.enterOwnerIndex(addressIndex);
        ownerRegistrationPage.enterOwnerCityAndStreet(addressCityAndStreet);
        ownerRegistrationPage.enterOwnerHome(addressHouse);
        ownerRegistrationPage.enterOwnerApartment(addressApartment);
    }
    @Step("Указывает, что фактический и адрес регистрации совпадают")
    public void setsMatchedClientAddresses() {
        ownerRegistrationPage.setActualAddressSameAsRegistration();
    }

    @Step("Вводит ФИО контактного лица {0} {1} {2}")
    public void fillsContactPersonalData(String contactSurname,
                                         String contactName,
                                         String contactPatronymic) {
        ownerRegistrationPage.clickContactInfoMenuItem();
        ownerRegistrationPage.enterContactFullName(contactSurname, contactName, contactPatronymic);
    }

    @Step("Вводит основные телефон {0} и адрес почты {1} контактного лица")
    public void fillsContactPhoneAndEmail(String contactMainPhone,
                                          String contactMainEmail) {
        ownerRegistrationPage.enterContactMainPhone(contactMainPhone);
        ownerRegistrationPage.enterContactMainEmail(contactMainEmail);
    }

    @Step("Жмет кнопку Зарегистрировать")
    public void clickRegistrationButton() {
        ownerRegistrationPage.clickRegistrationButton();
    }

    @Step("Дожидается приглашения зарегестрировать ТС")
    public void shouldSeeInviteToRegistrationVehicle() {
        assertThat(ownerRegistrationPage.displayedInviteToRegistrationVehicle())
                .overridingErrorMessage("Приглашение зарегестрировать ТС не отображается")
                .isTrue();
    }

    public void fillsEntityOGRN(String entityOGRN) {

    }

    public void fillsEntityOGRNDate(String entityOGRNDate) {

    }

    public void fillsEntityINN(String entityINN) {

    }

    public void fillsEntityKPP(String entityKPP) {

    }

    public void setsEntityForm(String entityForm) {

    }

    public void setsEntityCategory(String entityCategory) {

    }

    public void fillsEntityFullName(String entityFullName) {

    }

    public void fillsEntityShortName(String entityShortName) {

    }

    public void fillsEntityAddressData(String entityAddressIndex, String entityAddressCityAndStreet, String entityAddressHome, String entityAddressApartment) {

    }

    public void fillsEntityAccountNumber(String accountNumber) {

    }

    public void fillsEntityAccountBank(String accountBank) {

    }

    public void fillsEntityAccountBIK(String accountBIK) {

    }

    public void fillsEntityAccountINN(String accountINN) {

    }

    public void fillsEntityAccountKPP(String accountKPP) {

    }

    public void fillsEntityAccountOKPO(String accountOKPO) {

    }

    public void fillsEntityAccountCorr(String accountCorr) {

    }

    public void fillsEntityAccountRecipient(String accountRecipient) {

    }

    public void fillsDirectorPersonalData(String directorSurname, String directorName, String directorPatronymic) {

    }

    public void fillsDirectorBirthday(String directorBirthday) {

    }

    public void fillsDirectorPassportData(String directorPassportSeriesAndNumber, String directorPassportIssuedBy, String directorPassportIssuedWhen) {

    }

    public void fillsDirectorAddressData(String directorAddressIndex, String directorAddressCityAndStreet, String directorAddressHome, String directorAddressApartment) {

    }

    public void setsMatchedDirectorAddresses() {

    }

    public void fillsAgentPersonalData(String agentSurname, String agentName, String agentPatronymic) {

    }

    public void fillsAgentBirthday(String agentBirthday) {

    }

    public void fillsAgentPassportData(String agentPassportSeriesAndNumber, String agentPassportIssuedBy, String agentPassportIssuedWhen) {

    }

    public void fillsAgentAddressData(String agentAddressIndex, String agentAddressCityAndStreet, String agentAddressHome, String agentAddressApartment) {

    }

    public void setsMatchedAgentAddresses() {

    }
}
