package ru.progresspoint.svp12.cpp.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.progresspoint.svp12.cpp.pages.CreateNewOfferPage;
import ru.progresspoint.svp12.cpp.pages.LoginPage;

public class OperatorSteps extends ScenarioSteps {

    LoginPage loginPage;
    CreateNewOfferPage newOfferPage;

    @Step
    public void opensPage(String page) {
        switch (page) {
            case "Авторизация"             : loginPage.open(); break;
            case "Заключить новый договор" : newOfferPage.open(); break;
        }
    }

    @Step
    public void logsInSystem(String login, String password) {
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        loginPage.clickConfirmButton();
    }

    @Step
    public void setsClientType(String clientType) {
        newOfferPage.selectClientType(clientType);
    }

    @Step
    public void setsClientResidence(String clientCountry) {
        newOfferPage.selectClientCountry(clientCountry);
    }

    @Step
    public void fillsClientPersonalData(String clientSurname,
                                        String clientName,
                                        String clientPatronymic) {
        newOfferPage.enterOwnerFullName(clientSurname, clientName, clientPatronymic);
    }

    @Step
    public void fillsClientBirthday(String clientBirthday) {
        newOfferPage.enterOwnerBirthday(clientBirthday);
    }

    @Step
    public void fillsClientPassportData(String passportSeriesAndNumber,
                                        String passportIssuedBy,
                                        String passportIssuedWhen) {
        newOfferPage.enterOwnerPassportData(passportSeriesAndNumber, passportIssuedBy, passportIssuedWhen);
    }
}
