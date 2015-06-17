package ru.progresspoint.svp12.cpp.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.progresspoint.svp12.cpp.pages.CreateNewOfferPage;
import ru.progresspoint.svp12.cpp.pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorSteps extends ScenarioSteps {

    LoginPage loginPage;
    CreateNewOfferPage newOfferPage;

    @Step("Открывает страницу {0}")
    public void opensPage(String page) {
        switch (page) {
            case "Авторизация"             : loginPage.open(); break;
            case "Регистрация"             : newOfferPage.open(); break;
        }
    }

    @Step("Находится на странице {0}")
    public void isOnPage(String page) {
        switch (page) {
            case "Авторизация"             : loginPage.shouldBeDisplayed(); break;
            case "Регистрация"             : newOfferPage.shouldBeDisplayed(); break;
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
        newOfferPage.selectClientType(clientType);
    }

    @Step("Выбирает резидентство {0}")
    public void setsClientResidence(String clientCountry) {
        newOfferPage.selectClientCountry(clientCountry);
    }

    @Step("Вводит ФИО клиента {0} {1} {2}")
    public void fillsClientPersonalData(String clientSurname,
                                        String clientName,
                                        String clientPatronymic) {
        newOfferPage.enterOwnerFullName(clientSurname, clientName, clientPatronymic);
    }

    @Step("Вводит дату рожденя {0}")
    public void fillsClientBirthday(String clientBirthday) {
        newOfferPage.enterOwnerBirthday(clientBirthday);
    }

    @Step("Вводит серию и номер паспорта {0} кем и когда выдан {1} {2}")
    public void fillsClientPassportData(String passportSeriesAndNumber,
                                        String passportIssuedBy,
                                        String passportIssuedWhen) {
        newOfferPage.enterOwnerPassportData(passportSeriesAndNumber, passportIssuedBy, passportIssuedWhen);
    }

    @Step("Вводит адрес {0}, {1}, д.{2}, кв.{3}")
    public void fillsClientAddressData(String addressIndex,
                                       String addressCityAndStreet,
                                       String addressHouse,
                                       String addressApartment) {
        newOfferPage.enterOwnerIndex(addressIndex);
        newOfferPage.enterOwnerCityAndStreet(addressCityAndStreet);
        newOfferPage.enterOwnerHome(addressHouse);
        newOfferPage.enterOwnerApartment(addressApartment);
    }
    @Step("Указывает, что фактический и адрес регистрации совпадают")
    public void setMatchedTheAddresses() {
        newOfferPage.setActualAddressSameAsRegistration();
    }

    @Step("Вводит ФИО контактного лица {0} {1} {2}")
    public void fillsContactPersonalData(String contactSurname,
                                         String contactName,
                                         String contactPatronymic) {
        newOfferPage.clickContactInfoMenuItem();
        newOfferPage.enterContactFullName(contactSurname, contactName, contactPatronymic);
    }

    @Step("Вводит основные телефон {0} и адрес почты {1} контактного лица")
    public void fillsContactPhoneAndEmail(String contactMainPhone,
                                          String contactMainEmail) {
        newOfferPage.enterContactMainPhone(contactMainPhone);
        newOfferPage.enterContactMainEmail(contactMainEmail);
    }

    @Step("Жмет кнопку Зарегистрировать")
    public void clickRegistrationButton() {
        newOfferPage.clickRegistrationButton();
    }

    @Step("Дожидается приглашения зарегестрировать ТС")
    public void shouldSeeInviteToRegistrationVehicle() {
        assertThat(newOfferPage.displayedInviteToRegistrationVehicle())
                .overridingErrorMessage("Приглашение зарегестрировать ТС не отображается")
                .isTrue();
    }
}
