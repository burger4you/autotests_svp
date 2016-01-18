package ru.progresspoint.svp12.jbehave.steps.cpp;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.EmailUserSteps;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.cpp.steps.CPPUserSteps;

import javax.mail.MessagingException;

/**
 * Шаги пользователя АРМа ЦИПП
 */
public class CPPUserActions {

    @Steps
    CPPUserSteps operator;

    @Steps
    EmailUserSteps email;

    @Steps
    NavigationSteps navigation;

    @When("пользователь введет логин $login и пароль $password для авторизации в АРМ ЦИПП")
    public void operatorEntersLoginAndPassword(String login, String password) {
        operator.entersLoginAndPassword(login, password);
        operator.clicksToConfirmButton();
    }

    @When("оператор зарегистрирует ВТС как $clientType ($clientEmail)")
    public void operatorRegistersNewClient(String clientType, String clientEmail) throws MessagingException {
        email.deletesAllMessagesFromPlaton(clientEmail);
        operator.selectsClientCountry("Российская Федерация");
        operator.selectsClientType(clientType);
        operator.clicksToRegistrationButton();
        switch (clientType) {
            case "Индивидуальный предприниматель":
                operator.fillsIPPersonalData(clientEmail);
                operator.fillsIPRegistrationAddress("Москва", "", "", "", "Флотская");
                operator.fillsIPLocationAddress("Совпадает с адресом регистрации");
                break;
            case "Юридическое лицо":
                operator.fillsOrganizationData(clientEmail);
                operator.fillsOrganizationRegistrationAddress("Санкт-Петербург", "", "", "", "Иркутская");
                operator.fillsOrganizationLocationAddress("Совпадает с адресом регистрации");
                operator.fillsDirectorData(clientEmail);
                break;
            case "Физическое лицо":
                operator.fillsClientPersonalData(clientEmail);
                operator.fillsClientRegistrationAddress("Санкт-Петербург", "", "", "", "Иркутская");
                operator.fillsClientLocationAddress("Совпадает с адресом регистрации");
                break;
        }
        operator.clicksToTextButton("Добавить лицевой счет");
        operator.entersAccountData();
        operator.entersClientBankData();
        operator.clicksToLink("Завершить регистрацию");


//        operator.clicksToTextButton("Управление документами ВТС");
//        operator.uploadsClientDocumentsCopies();
//        operator.clicksToTextButton("Подтвердить");
//        operator.clicksToTextButton("Регистрация ТС");
//        operator.entersVehicleData();
//        operator.clicksToTextButton("Зарегистрировать");
//        operator.uploadsVehicleDocumentsCopies();
//        operator.clicksToConfirmButton();
//        operator.clicksToConfirmVehicleRegistrationDialogButton();
//        operator.clicksToTextButton("Завершить");
    }

    @When("оператор зарегистрирует ВТС из $clientCountry как $clientType ($clientEmail)")
    public void operatorRegistersUserData(String clientCountry, String clientType, String clientEmail) throws MessagingException {
        email.deletesAllMessagesFromPlaton(clientEmail);
        operator.selectsClientCountry(clientCountry);
        operator.selectsClientType(clientType);
        operator.clicksToRegistrationButton();
        switch (clientType) {
            case "Юридическое лицо":
                operator.fillsNonresidentOrganizationData(clientEmail);
                operator.fillsNonresidentOrganizationAddress();
                operator.fillsNonresidentDirectorData(clientEmail);
                break;
            case "Физическое лицо":
                operator.fillsNonResidentPersonalData(clientEmail);
                operator.fillsNonresidentClientAddress();
                break;
        }
        operator.clicksToTextButton("Добавить лицевой счет");
        operator.entersAccountData();
        operator.entersNonresidentClientBankData();
        operator.clicksToLink("Завершить регистрацию");
//        operator.uploadsClientDocumentsCopies();
//        operator.clicksToTextButton("Подтвердить");
//        operator.clicksToTextButton("Регистрация ТС");
//        operator.entersVehicleData();
//        operator.clicksToTextButton("Зарегистрировать");
//        operator.uploadsVehicleDocumentsCopies();
//        operator.clicksToConfirmButton();
//        operator.clicksToConfirmVehicleRegistrationDialogButton();
//        operator.clicksToTextButton("Завершить");
    }

    @When("оператор проведет верификацию данных ВТС")
    public void operatorVerifiesUserData() {
        operator.clicksToLink("Регистрация");
        operator.clicksToLink("Верификация");
        operator.findsOwnerVerificationRequest();
        operator.conductOwnerVerificationRequest();
        operator.findsVehicleVerificationRequest();
        operator.conductVehicleVerificationRequest();
    }

    @When("оператор выберет признак $searchBy и введет в поле для поиска ВТС $query")
    public void operatorSearchClientBy(String searchBy, String query) {
        operator.selectsByAndEntersQueryForSearch(searchBy, query);
        operator.clicksToTextButton("Искать");
    }

    @When("оператор откроет вкладку $tab в АРМ ЦИПП")
    public void operatorOpensTabOnMainMenu(String tab) {
        navigation.opensCPPPage(tab);
    }

    @When("оператор откроет страницу $page в АРМ ЦИПП")
    public void operatorOpensPageOnLeftMenu(String page) {
        operator.clicksToTextButton(page);
    }

    @When("оператор предоставит информацию с этой страницы владельцу ТС")
    public void operatorAcceptsInfo() {
        operator.clicksToLink("Информация предоставлена");
        operator.clicksToLink("OK");
    }

    @When("оператор пополнит счет на $amount рублей банковской картой в АРМ ЦИПП")
    public void operatorAddPaymentFromCreditCard(String amount) {
        navigation.opensCPPPage("Расчеты");
        operator.clicksToLink("Пополнение баланса");
        operator.enterAmountPaymentFromCreditCard(amount);
        operator.clicksToLink("Оплатить");
    }
}