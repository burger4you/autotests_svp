package ru.progresspoint.svp12.cpp.jbehave.steps.cpp;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.cpp.steps.CPPOperatorSteps;

/**
 * Шаги пользователей АРМа ЦИПП
 */
public class CPPOperatorActions {

    @Steps
    CPPOperatorSteps operator;

    @When("он вводит логин $login и пароль $password для авторизации в ЦИПП")
    public void operatorEntersLoginAndPassword(String login, String password) {
        operator.entersLoginAndPassword(login, password);
        operator.clicksToLoginButton();
    }

    @When("он выбирает тип клиента \"$clientType\" и резидентство \"$clientResidence\"")
    public void operatorSetTypeAndResidenceOfClient(String clientType, String clientResidence) {
        operator.setsClientType(clientType);
        operator.setsClientResidence(clientResidence);
    }

    @When("заполняет ОГРН: $entityOGRN присвоен $entityOGRNDate, ИНН: $entityINN, КПП: $entityKPP")
    public void operatorFillsEntityData(String entityOGRN,
                                        String entityOGRNDate,
                                        String entityINN,
                                        String entityKPP) {
        operator.fillsEntityOGRN(entityOGRN);
        operator.fillsEntityOGRNDate(entityOGRNDate);
        operator.fillsEntityINN(entityINN);
        operator.fillsEntityKPP(entityKPP);
    }

    @When("выбирает ОПФ организации: $entityForm")
    public void operatorSetsEntityForm(String entityForm) {
        operator.setsEntityForm(entityForm);
    }

    @When("выбирает категорию юридического лица: $entityCategory")
    public void operatorSetsEntityCategory(String entityCategory) {
        operator.setsEntityCategory(entityCategory);
    }

    @When("заполняет полное и краткое наименования юридического лица: $entityFullName ($entityShortName)")
    public void operatorFillsFullAndShortEntityNames(String entityFullName, String entityShortName) {
        operator.fillsEntityFullName(entityFullName);
        operator.fillsEntityShortName(entityShortName);
    }

    @When("заполняет юридический адрес: $entityAddressIndex; $entityAddressCityAndStreet; д. $entityAddressHome; кв. $entityAddressApartment")
    public void operatorFillsEntityAddressData(String entityAddressIndex,
                                               String entityAddressCityAndStreet,
                                               String entityAddressHome,
                                               String entityAddressApartment) {
        operator.fillsEntityAddressData(entityAddressIndex, entityAddressCityAndStreet, entityAddressHome, entityAddressApartment);
    }

    @When("заполняет данные расчетного счета: номер $accountNumber, банк $accountBank, БИК $accountBIK, ИНН $accountINN, КПП $accountKPP, ОКПО $accountOKPO, Корсчет $accountCorr, Получатель $accountRecipient")
    public void operatorFillsEntityAccountData(String accountNumber,
                                               String accountBank,
                                               String accountBIK,
                                               String accountINN,
                                               String accountKPP,
                                               String accountOKPO,
                                               String accountCorr,
                                               String accountRecipient
    ) {
        operator.fillsEntityAccountNumber(accountNumber);
        operator.fillsEntityAccountBank(accountBank);
        operator.fillsEntityAccountBIK(accountBIK);
        operator.fillsEntityAccountINN(accountINN);
        operator.fillsEntityAccountKPP(accountKPP);
        operator.fillsEntityAccountOKPO(accountOKPO);
        operator.fillsEntityAccountCorr(accountCorr);
        operator.fillsEntityAccountRecipient(accountRecipient);
    }

    @When("заполняет личные данные руководителя: $directorSurname $directorName $directorPatronymic родился $directorBirthday")
    public void operatorFillsDirectorPersonalData(String directorSurname,
                                                  String directorName,
                                                  String directorPatronymic,
                                                  String directorBirthday) {
        operator.fillsDirectorPersonalData(directorSurname, directorName, directorPatronymic);
        operator.fillsDirectorBirthday(directorBirthday);
    }

    @When("заполняет паспортные данные руководителя: $directorPassportSeriesAndNumber выдан $directorPassportIssuedBy $directorPassportIssuedWhen")
    public void operatorFillsDirectorPassportData(String directorPassportSeriesAndNumber,
                                                  String directorPassportIssuedBy,
                                                  String directorPassportIssuedWhen) {
        operator.fillsDirectorPassportData(directorPassportSeriesAndNumber, directorPassportIssuedBy, directorPassportIssuedWhen);
    }

    @When("заполняет адрес регистрации руководителя: $directorAddressIndex; $directorAddressCityAndStreet; д. $directorAddressHome; кв. $directorAddressApartment")
    public void operatorFillsDirectorAddressData(String directorAddressIndex,
                                                 String directorAddressCityAndStreet,
                                                 String directorAddressHome,
                                                 String directorAddressApartment) {
        operator.fillsDirectorAddressData(directorAddressIndex, directorAddressCityAndStreet, directorAddressHome, directorAddressApartment);
    }

    @When("указывает, что фактический адрес руководителя совпадает с адресом регистрации")
    public void operatorFillsDirectorAddressData() {
        operator.setsMatchedDirectorAddresses();
    }

    @When("заполняет личные данные доверенного лица: $agentSurname $agentName $agentPatronymic родился $agentBirthday")
    public void operatorFillsAgentPersonalData(String agentSurname,
                                               String agentName,
                                               String agentPatronymic,
                                               String agentBirthday) {
        operator.fillsAgentPersonalData(agentSurname, agentName, agentPatronymic);
        operator.fillsAgentBirthday(agentBirthday);
    }

    @When("заполняет паспортные данные доверенного лица: $agentPassportSeriesAndNumber выдан $agentPassportIssuedBy $agentPassportIssuedWhen")
    public void operatorFillsAgentPassportData(String agentPassportSeriesAndNumber,
                                               String agentPassportIssuedBy,
                                               String agentPassportIssuedWhen) {
        operator.fillsAgentPassportData(agentPassportSeriesAndNumber, agentPassportIssuedBy, agentPassportIssuedWhen);
    }
    
    @When("заполняет адрес регистрации доверенного лица: $agentAddressIndex; $agentAddressCityAndStreet; д. $agentAddressHome; кв. $agentAddressApartment")
    public void operatorFillsAgentAddressData(String agentAddressIndex,
                                               String agentAddressCityAndStreet,
                                               String agentAddressHome,
                                               String agentAddressApartment) {
        operator.fillsAgentAddressData(agentAddressIndex, agentAddressCityAndStreet, agentAddressHome, agentAddressApartment);
    }
    
    @When("указывает, что фактический адрес доверенного лица совпадает с адресом регистрации")
    public void operatorSetsMatchedAgentAddresses() {
        operator.setsMatchedAgentAddresses();
    }

    @When("заполняет личные данные владельца: $clientSurname $clientName $clientPatronymic родился $clientBirthday")
    @Alias("заполняет личные данные владельца: <clientSurname> <clientName> <clientPatronymic> родился <clientBirthday>")
    public void operatorFillsClientPersonalData(String clientSurname,
                                                String clientName,
                                                String clientPatronymic,
                                                String clientBirthday) {
        operator.fillsClientPersonalData(clientSurname, clientName, clientPatronymic);
        operator.fillsClientBirthday(clientBirthday);
    }

    @When("заполняет паспортные данные владельца: <clientPassportSeriesAndNumber> выдан <clientPassportIssuedBy> <clientPassportIssuedWhen>")
    public void operatorFillsClientPassportData(String clientPassportSeriesAndNumber,
                                                String clientPassportIssuedBy,
                                                String clientPassportIssuedWhen) {
        operator.fillsClientPassportData(clientPassportSeriesAndNumber, clientPassportIssuedBy, clientPassportIssuedWhen);
    }

    @When("заполняет адрес регистрации: <clientAddressIndex>; <clientAddressCityAndStreet>; д. <clientAddressHome>; кв. <clientAddressApartment>")
    public void operatorFillsClientAddressData(String clientAddressIndex,
                                               String clientAddressCityAndStreet,
                                               String clientAddressHome,
                                               String clientAddressApartment) {
        operator.fillsClientAddressData(clientAddressIndex, clientAddressCityAndStreet, clientAddressHome, clientAddressApartment);
    }

    @When("указывает, что фактический адрес клиента совпадает с адресом регистрации")
    public void operatorSetsMatchedClientAddresses() {
        operator.setsMatchedClientAddresses();
    }

    @When("заполняет личные данные контактного лица: <contactSurname> <contactName> <contactPatronymic>")
    public void operatorFillsContactPersonalData(String contactSurname,
                                                 String contactName,
                                                 String contactPatronymic) {
        operator.fillsContactPersonalData(contactSurname, contactName, contactPatronymic);
    }

    @When("заполняет основные контакты: телефон <contactMainPhone> и email <contactMainEmail>")
    public void operatorFillsContactPersonalData(String contactMainPhone,
                                                 String contactMainEmail) {
        operator.fillsContactPhoneAndEmail(contactMainPhone, contactMainEmail);
    }

    @When("подтверждает регистрацию")
    public void operatorConfirmRegistration() {
        operator.clickRegistrationButton();
    }

    @When("оператор проводит верификацию данных пользователя")
    public void operatorVerifiesUserData() {
        operator.clicksToLink("Регистрация");
        operator.clicksToLink("Верификация");
        operator.findsOwnerVerificationRequest();
        operator.conductOwnerVerificationRequest();
        operator.findsVehicleVerificationRequest();
        operator.conductVehicleVerificationRequest();
    }
}