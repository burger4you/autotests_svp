package ru.progresspoint.svp12.cpp.steps;


import net.thucydides.core.annotations.Step;
import ru.progresspoint.svp12.RandomGenerators;
import ru.progresspoint.svp12.cpp.pages.*;

import static java.lang.String.format;
import static net.serenitybdd.core.Serenity.getCurrentSession;
import static org.openqa.selenium.By.*;

/**
 * Шаги оператора
 */
public class CPPOperatorSteps extends RandomGenerators {

    CPPLoginPage loginPage;
    CPPSelectActionDialog selectActionDialog;
    CPPClientRegistrationPage clientRegistrationPage;
    CPPVehicleRegistrationPage vehicleRegistrationPage;
    CPPIPRegistrationPage ipRegistrationPage;
    CPPOrganizationRegistrationPage organizationRegistrationPage;

    @Step("Нажимает на ссылку {0}")
    public void clicksToLink(String linkText) {
        getDriver().findElement(linkText(linkText));
    }

    @Step("Вводит логин {0} и пароль {1}")
    public void entersLoginAndPassword(String login, String password) {
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
    }

    @Step("Нажимает на кнопку подтверждения")
    public void clicksToConfirmButton() {
        getDriver().findElement(name("commit")).click();
    }

    @Step("Выбирает тип клиента {0}")
    public void selectsClientType(String clientType) {
        selectActionDialog.selectClientType(clientType);
    }

    @Step("Выбирает резидентство {0}")
    public void selectsClientCountry(String clientCountry) {
        selectActionDialog.selectClientCountry(clientCountry);
    }

    @Step("Нажимает на кнопку Зарегистрировать")
    public void clicksToRegistrationButton() {
        selectActionDialog.clickRegistrationButton();
    }

    @Step("Вводит данные ИП")
    public void entersIPData(String ipEmail) {
        fillsIPData(ipEmail);
        fillsIPRegistrationAddress("Город Санкт-Петербург, улица Иркутская");
        fillsIPLocationAddress("Совпадает с адресом регистрации");
        fillsIPPostalAddress("Совпадает с адресом регистрации");
        fillsAccountData();
        fillsClientBankData();
    }

    @Step("Вводит данные ЮЛ")
    public void entersULData(String organizationEmail) {
        fillsOrganizationData(organizationEmail);
        fillsOrganizationRegistrationAddress("Город Санкт-Петербург, улица Иркутская");
        fillsOrganizationLocationAddress("Совпадает с адресом регистрации");
        fillsOrganizationPostalAddress("Совпадает с адресом регистрации");
        fillsDirectorData(organizationEmail);
        fillsAccountData();
        fillsClientBankData();
    }

    @Step("Вводит данные ФЛ")
    public void entersFLData(String clientEmail) {
        fillsClientPersonalData(clientEmail);
        fillsClientRegistrationAddress("Город Санкт-Петербург, улица Иркутская");
        fillsClientLocationAddress("Совпадает с адресом регистрации");
        fillsClientPostalAddress("Совпадает с адресом регистрации");
        fillsAccountData();
        fillsClientBankData();
    }

    @Step("Нажимает на кнопку {0}")
    public void clicksToTextButton(String textButton) {
        getDriver().findElement(xpath(format(".//a[text()='%s']", textButton))).click();
    }

    @Step("Прикладывает скан-копии документов ВТС")
    public void uploadsClientDocumentsCopies() {

    }

    @Step("Прикладывает скан-копии документов ТС")
    public void uploadsVehicleDocumentsCopies() {

    }

    @Step("Вводит данные ТС")
    public void entersVehicleData() {
        vehicleRegistrationPage.selectVehicleCountry("Российская Федерация");
        vehicleRegistrationPage.enterVehicleDocumentNumber(getRandomNumber(10));
        vehicleRegistrationPage.enterVehicleDocumentDateIssue(getRandomDate());
        vehicleRegistrationPage.enterVehicleGRNZ("T" + getCurrentSession().get("vehicleGRNZ") + "ST" + getRandomNumber(3));
        vehicleRegistrationPage.selectVehicleType("Рефрижератор");
        vehicleRegistrationPage.enterVehicleVIN(getRandomNumber(17));
        vehicleRegistrationPage.selectVehicleBasisType("Собственность");
        vehicleRegistrationPage.selectVehicleMark("MAN");
        vehicleRegistrationPage.enterVehicleMass("12000");
    }

    @Step("Находит заявку на верификацию ВТС")
    public void findsOwnerVerificationRequest() {
    }

    @Step("Проводит верификацию ВТС")
    public void conductOwnerVerificationRequest() {
    }

    @Step("Находит заявку на верификацию ТС")
    public void findsVehicleVerificationRequest() {
    }

    @Step("Проводит верификацию ТС")
    public void conductVehicleVerificationRequest() {
    }

    private void fillsClientPersonalData(String clientEmail) {
        clientRegistrationPage.selectClientDocumentType("Паспорт");
        clientRegistrationPage.enterClientDocumentNumber(getRandomNumber(10));
        clientRegistrationPage.enterClientDocumentIssuedBy(getRandomCyrillicProperString(12));
        clientRegistrationPage.enterClientDocumentIssuedDate(getRandomDate());
        clientRegistrationPage.enterClientSurname(getRandomCyrillicProperString(7));
        clientRegistrationPage.enterClientName(getRandomCyrillicProperString(5));
        clientRegistrationPage.enterClientPatronymic(getRandomCyrillicProperString(10));
        clientRegistrationPage.enterClientPhone(getRandomNumber(11));
        getCurrentSession().put("login", clientEmail.replace("@gmail.com", "+" + getRandomNumber(6) + "@gmail.com"));
        clientRegistrationPage.enterClientEmail((String) getCurrentSession().get("login"));
        clientRegistrationPage.selectClientRole("Главный менеджер");
    }

    private void fillsIPData(String ipEmail) {
        ipRegistrationPage.enterIPOGRN(getRandomNumber(15));
        ipRegistrationPage.enterIPINN(getRandomNumber(12));
        ipRegistrationPage.enterIPSurname(getRandomCyrillicProperString(7));
        ipRegistrationPage.enterIPName(getRandomCyrillicProperString(5));
        ipRegistrationPage.enterIPPatronymic(getRandomCyrillicProperString(10));
        ipRegistrationPage.enterIPShortName(getRandomCyrillicProperString(10));
        ipRegistrationPage.selectIPDocumentType("Паспорт");
        ipRegistrationPage.enterIPDocumentNumber(getRandomNumber(10));
        ipRegistrationPage.enterIPDocumentIssuedBy(getRandomCyrillicProperString(12));
        ipRegistrationPage.enterIPDocumentIssuedDate(getRandomDate());
        ipRegistrationPage.enterIPMainPhone(getRandomNumber(11));
        getCurrentSession().put("login", ipEmail.replace("@gmail.com", "+" + getRandomNumber(6) + "@gmail.com"));
        ipRegistrationPage.enterIPMainEmail((String) getCurrentSession().get("login"));
        ipRegistrationPage.selectIPRole("Главный менеджер");
    }

    private void fillsOrganizationData(String organizationEmail) {
        organizationRegistrationPage.selectOrganizationOPF("Общества с ограниченной ответственностью");
        organizationRegistrationPage.enterOrganizationOGRN(getRandomNumber(15));
        organizationRegistrationPage.enterOrganizationINN(getRandomNumber(12));
        organizationRegistrationPage.enterOrganizationName(getRandomCyrillicProperString(10));
        organizationRegistrationPage.enterOrganizationShortName(getRandomCyrillicProperString(5));
        organizationRegistrationPage.enterOrganizationMainPhone(getRandomNumber(11));
        organizationRegistrationPage.enterOrganizationMainEmail(organizationEmail.replace("@gmail.com", "+" + getRandomNumber(6) + "@gmail.com"));
    }

    private void fillsDirectorData(String directorEmail) {
        getCurrentSession().put("login", directorEmail.replace("@gmail.com", "+" + getRandomNumber(6) + "@gmail.com"));

        organizationRegistrationPage.enterDirectorSurname(getRandomCyrillicProperString(7));
        organizationRegistrationPage.enterDirectorName(getRandomCyrillicProperString(5));
        organizationRegistrationPage.enterDirectorPatronymic(getRandomCyrillicProperString(10));
        organizationRegistrationPage.selectDirectorPersonalDocumentType("Удостоверение личности военнослужащего РФ");
        organizationRegistrationPage.enterDirectorPersonalDocumentNumber(getRandomNumber(10));
        organizationRegistrationPage.enterDirectorPersonalDocumentIssuedDate(getRandomDate());
        organizationRegistrationPage.enterDirectorPersonalDocumentIssuedBy(getRandomCyrillicProperString(12));
        organizationRegistrationPage.selectDirectorDocumentType("Устав");
        organizationRegistrationPage.enterDirectorDocumentNumber(getRandomNumber(10));
        organizationRegistrationPage.enterDirectorDocumentIssuedDate(getRandomDate());
        organizationRegistrationPage.enterDirectorDocumentValidity("31.12.2015");
        organizationRegistrationPage.enterDirectorPhone(getRandomNumber(11));
        organizationRegistrationPage.enterDirectorLogin((String) getCurrentSession().get("login"));
        organizationRegistrationPage.selectDirectorPosition("Генеральный директор");
        organizationRegistrationPage.selectDirectorRole("Главный менеджер");
    }

    private void fillsClientRegistrationAddress(String clientAddressKladr) {
        clientRegistrationPage.selectClientRegistrationAddressKladr(clientAddressKladr);
//        clientRegistrationPage.enterClientRegistrationAddressIndex(getRandomNumber(6));
        clientRegistrationPage.enterClientRegistrationAddressHouse(getRandomNumber(3));
        clientRegistrationPage.enterClientRegistrationAddressHousing(getRandomNumber(1));
        clientRegistrationPage.enterClientRegistrationAddressBuilding(getRandomNumber(1));
        clientRegistrationPage.enterClientRegistrationAddressRoom(getRandomNumber(2));
    }

    private void fillsIPRegistrationAddress(String clientAddressKladr) {
        ipRegistrationPage.selectClientRegistrationAddressKladr(clientAddressKladr);
//        ipRegistrationPage.enterClientRegistrationAddressIndex(getRandomNumber(6));
        ipRegistrationPage.enterClientRegistrationAddressHouse(getRandomNumber(3));
        ipRegistrationPage.enterClientRegistrationAddressHousing(getRandomNumber(1));
        ipRegistrationPage.enterClientRegistrationAddressBuilding(getRandomNumber(1));
        ipRegistrationPage.enterClientRegistrationAddressRoom(getRandomNumber(2));
    }

    private void fillsOrganizationRegistrationAddress(String clientAddressKladr) {
        organizationRegistrationPage.selectClientRegistrationAddressKladr(clientAddressKladr);
//        organizationRegistrationPage.enterClientRegistrationAddressIndex(getRandomNumber(6));
        organizationRegistrationPage.enterClientRegistrationAddressHouse(getRandomNumber(3));
        organizationRegistrationPage.enterClientRegistrationAddressHousing(getRandomNumber(1));
        organizationRegistrationPage.enterClientRegistrationAddressBuilding(getRandomNumber(1));
        organizationRegistrationPage.enterClientRegistrationAddressRoom(getRandomNumber(2));
    }

    private void fillsClientLocationAddress(String locationAddressKladr) {
        switch (locationAddressKladr) {
            case "Совпадает с адресом регистрации":
                clientRegistrationPage.clickToLocationAddressSameAsRegistrationCheckBox();
                break;
            default:
                clientRegistrationPage.selectClientLocationAddressKladr(locationAddressKladr);
//        clientRegistrationPage.enterClientLocationAddressIndex(getRandomNumber(6));
                clientRegistrationPage.enterClientLocationAddressHouse(getRandomNumber(3));
                clientRegistrationPage.enterClientLocationAddressHousing(getRandomNumber(1));
                clientRegistrationPage.enterClientLocationAddressBuilding(getRandomNumber(1));
                clientRegistrationPage.enterClientLocationAddressRoom(getRandomNumber(2));
        }
    }

    private void fillsIPLocationAddress(String locationAddressKladr) {
        switch (locationAddressKladr) {
            case "Совпадает с адресом регистрации":
                ipRegistrationPage.clickToLocationAddressSameAsRegistrationCheckBox();
                break;
            default:
                ipRegistrationPage.selectClientLocationAddressKladr(locationAddressKladr);
//        ipRegistrationPage.enterClientLocationAddressIndex(getRandomNumber(6));
                ipRegistrationPage.enterClientLocationAddressHouse(getRandomNumber(3));
                ipRegistrationPage.enterClientLocationAddressHousing(getRandomNumber(1));
                ipRegistrationPage.enterClientLocationAddressBuilding(getRandomNumber(1));
                ipRegistrationPage.enterClientLocationAddressRoom(getRandomNumber(2));
                break;
        }
    }

    private void fillsOrganizationLocationAddress(String locationAddressKladr) {
        switch (locationAddressKladr) {
            case "Совпадает с адресом регистрации":
                organizationRegistrationPage.clickToLocationAddressSameAsRegistrationCheckBox();
                break;
            default:
                organizationRegistrationPage.selectClientLocationAddressKladr(locationAddressKladr);
//        organizationRegistrationPage.enterClientLocationAddressIndex(getRandomNumber(6));
                organizationRegistrationPage.enterClientLocationAddressHouse(getRandomNumber(3));
                organizationRegistrationPage.enterClientLocationAddressHousing(getRandomNumber(1));
                organizationRegistrationPage.enterClientLocationAddressBuilding(getRandomNumber(1));
                organizationRegistrationPage.enterClientLocationAddressRoom(getRandomNumber(2));
        }
    }

    private void fillsClientPostalAddress(String postalAddressKladr) {
        switch (postalAddressKladr) {
            case "Совпадает с адресом регистрации":
                clientRegistrationPage.clickToPostalAddressSameAsRegistrationCheckBox();
                break;
            default:
                clientRegistrationPage.selectClientPostalAddressKladr(postalAddressKladr);
//        clientRegistrationPage.enterClientPostalAddressIndex(getRandomNumber(6));
                clientRegistrationPage.enterClientPostalAddressHouse(getRandomNumber(3));
                clientRegistrationPage.enterClientPostalAddressHousing(getRandomNumber(1));
                clientRegistrationPage.enterClientPostalAddressBuilding(getRandomNumber(1));
                clientRegistrationPage.enterClientPostalAddressRoom(getRandomNumber(2));
        }
    }

    private void fillsIPPostalAddress(String postalAddressKladr) {
        switch (postalAddressKladr) {
            case "Совпадает с адресом регистрации":
                ipRegistrationPage.clickToPostalAddressSameAsRegistrationCheckBox();
                break;
            default:
                ipRegistrationPage.selectClientPostalAddressKladr(postalAddressKladr);
//        ipRegistrationPage.enterClientPostalAddressIndex(getRandomNumber(6));
                ipRegistrationPage.enterClientPostalAddressHouse(getRandomNumber(3));
                ipRegistrationPage.enterClientPostalAddressHousing(getRandomNumber(1));
                ipRegistrationPage.enterClientPostalAddressBuilding(getRandomNumber(1));
                ipRegistrationPage.enterClientPostalAddressRoom(getRandomNumber(2));
        }
    }

    private void fillsOrganizationPostalAddress(String postalAddressKladr) {
        switch (postalAddressKladr) {
            case "Совпадает с адресом регистрации":
                organizationRegistrationPage.clickToPostalAddressSameAsRegistrationCheckBox();
                break;
            default:
                organizationRegistrationPage.selectClientPostalAddressKladr(postalAddressKladr);
//        organizationRegistrationPage.enterClientPostalAddressIndex(getRandomNumber(6));
                organizationRegistrationPage.enterClientPostalAddressHouse(getRandomNumber(3));
                organizationRegistrationPage.enterClientPostalAddressHousing(getRandomNumber(1));
                organizationRegistrationPage.enterClientPostalAddressBuilding(getRandomNumber(1));
                organizationRegistrationPage.enterClientPostalAddressRoom(getRandomNumber(2));
        }
    }

    private void fillsAccountData() {
        clicksToTextButton("Добавить лицевой счет");
        clientRegistrationPage.enterClientSecondAccountName(getRandomCyrillicProperString(6));
    }

    private void fillsClientBankData() {
        clientRegistrationPage.enterClientBankName(getRandomCyrillicProperString(6));
        clientRegistrationPage.enterClientBankBIK(getRandomNumber(9));
        clientRegistrationPage.enterClientBankINN(getRandomNumber(10));
        clientRegistrationPage.enterClientBankKorNumber(getRandomNumber(20));
        clientRegistrationPage.enterClientBankAccountNumber(getRandomNumber(20));
        clientRegistrationPage.enterClientBankReceiverName(getRandomCyrillicProperString(18));
    }
}
