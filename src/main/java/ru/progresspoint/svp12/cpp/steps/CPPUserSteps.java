package ru.progresspoint.svp12.cpp.steps;


import net.thucydides.core.annotations.Step;
import ru.progresspoint.svp12.RandomGenerators;
import ru.progresspoint.svp12.cpp.pages.*;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static net.serenitybdd.core.Serenity.getCurrentSession;
import static net.thucydides.core.matchers.BeanMatcherAsserts.shouldMatch;
import static net.thucydides.core.matchers.BeanMatchers.the;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.By.*;

/**
 * Шаги пользователя АРМа ЦИПП
 */
public class CPPUserSteps extends RandomGenerators {

    CPPLoginPage loginPage;
    CPPSelectActionDialog selectActionDialog;
    CPPClientRegistrationPage clientRegistrationPage;
    CPPVehicleRegistrationPage vehicleRegistrationPage;
    CPPIPRegistrationPage ipRegistrationPage;
    CPPOrganizationRegistrationPage organizationRegistrationPage;
    CPPClientNonresidentRegistrationPage clientNonresidentRegistrationPage;
    CPPOrganizationNonresidentRegistrationPage organizationNonresidentRegistrationPage;
    CPPAppealHistoryPopUp appealHistoryPopUp;
    CPPNewPaymentPage newPaymentPage;

    @Step("Нажимает на ссылку {0}")
    public void clicksToLink(String linkText) {
        getDriver().findElement(linkText(linkText)).click();
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
        selectActionDialog.clickToRegistrationButton();
    }

    @Step("Вводит данные индивидуального предпринимателя")
    public void fillsIPPersonalData(String ipEmail) {
        ipRegistrationPage.enterIPOGRN(getRandomNumber(15));
        ipRegistrationPage.enterIPINN(getRandomNumber(12));
        ipRegistrationPage.enterIPKPP(getRandomNumber(9));
        ipRegistrationPage.enterIPSurname(getRandomCyrillicProperString(7));
        ipRegistrationPage.enterIPName(getRandomCyrillicProperString(5));
        ipRegistrationPage.enterIPPatronymic(getRandomCyrillicProperString(10));
        ipRegistrationPage.enterIPShortName(getRandomCyrillicProperString(10));
        ipRegistrationPage.selectIPDocumentType("Паспорт");
        ipRegistrationPage.enterIPDocumentNumber(getRandomNumber(10));
        ipRegistrationPage.enterIPDocumentIssuedBy(getRandomCyrillicProperString(12));
        ipRegistrationPage.enterIPDocumentIssuedDate(getRandomDate());
        ipRegistrationPage.enterIPDocumentIssuedCode(getRandomNumber(3) + "-" + getRandomNumber(3));
        String[] array = ipEmail.split("@");
        getCurrentSession().put("login", ipEmail.replace(valueOf(array[0]), valueOf(array[0]) + "+ip_" + getRandomNumber(6)));
        ipRegistrationPage.enterIPMainEmail((String) getCurrentSession().get("login"));
        ipRegistrationPage.selectIPRole("Главный менеджер");
        ipRegistrationPage.selectIPLanguage("Русский");
    }

    @Step("Вводит адрес регистрации ИП по месту жительства")
    public void fillsIPRegistrationAddress(String clientAddressRegion,
                                           String clientAddressDistrict,
                                           String clientAddressCity,
                                           String clientAddressSettlement,
                                           String clientAddressStreet) {
        ipRegistrationPage.selectClientRegistrationAddressRegion(clientAddressRegion);
        ipRegistrationPage.selectClientRegistrationAddressDistrict(clientAddressDistrict);
        ipRegistrationPage.selectClientRegistrationAddressCity(clientAddressCity);
        ipRegistrationPage.selectClientRegistrationAddressSettlement(clientAddressSettlement);
        ipRegistrationPage.selectClientRegistrationAddressStreet(clientAddressStreet);
        ipRegistrationPage.enterClientRegistrationAddressHouse(getRandomNumber(3));
        ipRegistrationPage.enterClientRegistrationAddressHousing(getRandomNumber(1));
        ipRegistrationPage.enterClientRegistrationAddressBuilding(getRandomNumber(1));
        ipRegistrationPage.enterClientRegistrationAddressRoom(getRandomNumber(2));
//        ipRegistrationPage.enterClientRegistrationAddressIndex(getRandomNumber(6));
    }

    @Step("Вводит адрес ИП по месту пребывания")
    public void fillsIPLocationAddress(String locationAddress) {
        if (locationAddress.equals("Совпадает с адресом регистрации"))
            ipRegistrationPage.clickToLocationAddressSameAsRegistrationCheckBox();
    }

    @Step("Вводит данные юридического лица")
    public void fillsOrganizationData(String organizationEmail) {
        organizationRegistrationPage.selectOrganizationOPF("Общество с ограниченной ответственностью");
        organizationRegistrationPage.enterOrganizationOGRN(getRandomNumber(15));
        organizationRegistrationPage.enterOrganizationINN(getRandomNumber(12));
        organizationRegistrationPage.enterOrganizationKPP(getRandomNumber(9));
        organizationRegistrationPage.enterOrganizationName(getRandomCyrillicProperString(10));
        organizationRegistrationPage.enterOrganizationShortName(getRandomCyrillicProperString(5));
        organizationRegistrationPage.enterOrganizationMainPhone(getRandomNumber(11));
        String[] array = organizationEmail.split("@");
        organizationRegistrationPage.enterOrganizationMainEmail(organizationEmail.replace(valueOf(array[0]), valueOf(array[0]) + "+ul_" + getRandomNumber(6)));
        organizationRegistrationPage.selectOrganizationLanguage("Русский");
    }

    @Step("Вводит юридический адрес организации")
    public void fillsOrganizationRegistrationAddress(String clientAddressRegion,
                                                     String clientAddressDistrict,
                                                     String clientAddressCity,
                                                     String clientAddressSettlement,
                                                     String clientAddressStreet) {
        organizationRegistrationPage.selectClientRegistrationAddressRegion(clientAddressRegion);
        organizationRegistrationPage.selectClientRegistrationAddressDistrict(clientAddressDistrict);
        organizationRegistrationPage.selectClientRegistrationAddressCity(clientAddressCity);
        organizationRegistrationPage.selectClientRegistrationAddressSettlement(clientAddressSettlement);
        organizationRegistrationPage.selectClientRegistrationAddressStreet(clientAddressStreet);
        organizationRegistrationPage.enterClientRegistrationAddressHouse(getRandomNumber(3));
        organizationRegistrationPage.enterClientRegistrationAddressHousing(getRandomNumber(1));
        organizationRegistrationPage.enterClientRegistrationAddressBuilding(getRandomNumber(1));
        organizationRegistrationPage.enterClientRegistrationAddressRoom(getRandomNumber(2));
//        organizationRegistrationPage.enterClientRegistrationAddressIndex(getRandomNumber(6));
    }

    @Step("Вводит адрес местонахождения организации")
    public void fillsOrganizationLocationAddress(String locationAddress) {
        if (locationAddress.equals("Совпадает с адресом регистрации"))
            organizationRegistrationPage.clickToLocationAddressSameAsRegistrationCheckBox();
    }

    @Step("Вводит личные данные руководителя организации")
    public void fillsDirectorData(String directorEmail) {
        organizationRegistrationPage.enterDirectorSurname(getRandomCyrillicProperString(7));
        organizationRegistrationPage.enterDirectorName(getRandomCyrillicProperString(5));
        organizationRegistrationPage.enterDirectorPatronymic(getRandomCyrillicProperString(10));
        organizationRegistrationPage.selectDirectorDocumentType("Устав");
        organizationRegistrationPage.enterDirectorDocumentNumber(getRandomNumber(10));
        organizationRegistrationPage.enterDirectorDocumentDate(getRandomDate());
        organizationRegistrationPage.enterDirectorDocumentValidity("31.12.2016");
        organizationRegistrationPage.enterDirectorDocumentIssuedDate(getRandomDate());
        String[] array = directorEmail.split("@");
        getCurrentSession().put("login", directorEmail.replace(valueOf(array[0]), valueOf(array[0]) + "+ul_dir_" + getRandomNumber(6)));
        organizationRegistrationPage.enterDirectorEmail((String) getCurrentSession().get("login"));
        organizationRegistrationPage.selectDirectorPosition("Генеральный директор");
        organizationRegistrationPage.selectDirectorRole("Главный менеджер");
    }

    @Step("Вводит личные данные физического лица")
    public void fillsClientPersonalData(String clientEmail) {
        clientRegistrationPage.selectClientDocumentType("Паспорт");
        clientRegistrationPage.enterClientDocumentNumber(getRandomNumber(10));
        clientRegistrationPage.enterClientDocumentIssuedBy(getRandomCyrillicProperString(12));
        clientRegistrationPage.enterClientDocumentIssuedDate(getRandomDate());
        clientRegistrationPage.enterClientDocumentIssuedCode(getRandomNumber(3) + "-" + getRandomNumber(3));
        clientRegistrationPage.enterClientSurname(getRandomCyrillicProperString(7));
        clientRegistrationPage.enterClientName(getRandomCyrillicProperString(5));
        clientRegistrationPage.enterClientPatronymic(getRandomCyrillicProperString(10));
        clientRegistrationPage.enterClientINN(getRandomNumber(12));
        String[] array = clientEmail.split("@");
        getCurrentSession().put("login", clientEmail.replace(valueOf(array[0]), valueOf(array[0]) + "+fl_" + getRandomNumber(6)));
        clientRegistrationPage.enterClientEmail((String) getCurrentSession().get("login"));
        clientRegistrationPage.enterClientPhone(getRandomNumber(11));
        clientRegistrationPage.selectClientRole("Главный менеджер");
        clientRegistrationPage.selectClientLanguage("Русский");
    }

    @Step("Вводит адрес регистрации физического лица по месту жительства")
    public void fillsClientRegistrationAddress(String clientAddressRegion,
                                               String clientAddressDistrict,
                                               String clientAddressCity,
                                               String clientAddressSettlement,
                                               String clientAddressStreet) {
        clientRegistrationPage.selectClientRegistrationAddressRegion(clientAddressRegion);
        clientRegistrationPage.selectClientRegistrationAddressDistrict(clientAddressDistrict);
        clientRegistrationPage.selectClientRegistrationAddressCity(clientAddressCity);
        clientRegistrationPage.selectClientRegistrationAddressSettlement(clientAddressSettlement);
        clientRegistrationPage.selectClientRegistrationAddressStreet(clientAddressStreet);
        clientRegistrationPage.enterClientRegistrationAddressHouse(getRandomNumber(3));
        clientRegistrationPage.enterClientRegistrationAddressHousing(getRandomNumber(1));
        clientRegistrationPage.enterClientRegistrationAddressBuilding(getRandomNumber(1));
        clientRegistrationPage.enterClientRegistrationAddressRoom(getRandomNumber(2));
//        clientRegistrationPage.enterClientRegistrationAddressIndex(getRandomNumber(6));
    }

    @Step("Вводит адрес физического лица по месту пребывания")
    public void fillsClientLocationAddress(String locationAddress) {
        if (locationAddress.equals("Совпадает с адресом регистрации"))
            clientRegistrationPage.clickToLocationAddressSameAsRegistrationCheckBox();
    }

    @Step("Вводит личные данные физического лица из другой страны")
    public void fillsNonResidentPersonalData(String clientEmail) {
        clientRegistrationPage.selectClientDocumentType("Паспорт иностранного гражданина");
        clientRegistrationPage.enterClientDocumentNumber(getRandomNumber(10));
        clientRegistrationPage.enterClientDocumentIssuedBy(getRandomCyrillicProperString(12));
        clientRegistrationPage.enterClientDocumentIssuedDate(getRandomDate());
        clientRegistrationPage.enterClientDocumentIssuedCode(getRandomNumber(3) + "-" + getRandomNumber(3));
        clientRegistrationPage.enterClientSurname(getRandomCyrillicProperString(7));
        clientRegistrationPage.enterClientName(getRandomCyrillicProperString(5));
        clientRegistrationPage.enterClientPatronymic(getRandomCyrillicProperString(10));
        String[] array = clientEmail.split("@");
        getCurrentSession().put("login", clientEmail.replace(valueOf(array[0]), valueOf(array[0]) + "+fl_nr_" + getRandomNumber(6)));
        clientRegistrationPage.enterClientEmail((String) getCurrentSession().get("login"));
        clientRegistrationPage.enterClientPhone(getRandomNumber(11));
        clientRegistrationPage.selectClientRole("Главный менеджер");
        clientRegistrationPage.selectClientLanguage("Английский");
    }

    @Step("Вводит адрес регистрации физического лица из другой страны")
    public void fillsNonresidentClientAddress() {
        clientNonresidentRegistrationPage.enterClientRegistrationAddress(getRandomCyrillicProperString(30));
    }

    @Step("Вводит данные юридического лица из другой страны")
    public void fillsNonresidentOrganizationData(String organizationEmail) {
        organizationRegistrationPage.enterOrganizationName(getRandomCyrillicProperString(10));
        organizationRegistrationPage.enterOrganizationShortName(getRandomCyrillicProperString(5));
        organizationRegistrationPage.enterOrganizationRegistrationNumber(getRandomNumber(8));
        organizationRegistrationPage.enterOrganizationMainPhone(getRandomNumber(11));
        String[] array = organizationEmail.split("@");
        organizationRegistrationPage.enterOrganizationMainEmail(organizationEmail.replace(valueOf(array[0]), valueOf(array[0]) + "+ul_nr_" + getRandomNumber(6)));
        organizationRegistrationPage.selectOrganizationLanguage("Английский");
    }

    @Step("Вводит адрес регистрации юридического лица из другой страны")
    public void fillsNonresidentOrganizationAddress() {
        organizationNonresidentRegistrationPage.enterOrganizationRegistrationAddress(getRandomCyrillicProperString(30));
    }

    @Step("Вводит личные данные руководителя организации из другой страны")
    public void fillsNonresidentDirectorData(String directorEmail) {
        organizationRegistrationPage.enterDirectorSurname(getRandomCyrillicProperString(7));
        organizationRegistrationPage.enterDirectorName(getRandomCyrillicProperString(5));
        organizationRegistrationPage.enterDirectorPatronymic(getRandomCyrillicProperString(10));
        String[] array = directorEmail.split("@");
        getCurrentSession().put("login", directorEmail.replace(valueOf(array[0]), valueOf(array[0]) + "+ul_dir_" + getRandomNumber(6)));
        organizationRegistrationPage.enterDirectorEmail((String) getCurrentSession().get("login"));
        organizationRegistrationPage.selectDirectorPosition("Генеральный директор");
        organizationRegistrationPage.selectDirectorRole("Главный менеджер");
    }

    @Step("Вводит данные дополнительного лицевого счета")
    public void entersAccountData() {
        clientRegistrationPage.enterClientSecondAccountName(getRandomCyrillicProperString(6));
    }

    @Step("Вводит данные расчетного счета в банке")
    public void entersClientBankData() {
        clientRegistrationPage.enterClientBankAccountNumber(getRandomNumber(20));
        clientRegistrationPage.enterClientBankBIK(getRandomNumber(9));
        clientRegistrationPage.enterClientBankName(getRandomCyrillicProperString(6));
        clientRegistrationPage.enterClientBankKorNumber(getRandomNumber(20));
    }

    @Step("Вводит данные расчетного счета в банке другой страны")
    public void entersNonresidentClientBankData() {
        clientRegistrationPage.enterClientBankAccountNumber(getRandomNumber(20));
        clientRegistrationPage.enterClientBankSWIFT(getRandomNumber(9));
        clientRegistrationPage.enterClientBankName(getRandomCyrillicProperString(10));
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
        getCurrentSession().put("vehicleGRNZ", getRandomNumber(3));
        vehicleRegistrationPage.selectVehicleCountry("Российская Федерация");
        vehicleRegistrationPage.enterVehicleDocumentNumber(getRandomNumber(10));
        vehicleRegistrationPage.enterVehicleDocumentDateIssue(getRandomDate());
        vehicleRegistrationPage.enterVehicleGRNZ("T" + getCurrentSession().get("vehicleGRNZ") + "СT" + getRandomNumber(3));
        vehicleRegistrationPage.selectVehicleType("Рефрижератор");
        vehicleRegistrationPage.enterVehicleVIN(getRandomNumber(17));
        vehicleRegistrationPage.selectVehicleBasisType("Собственность");
        vehicleRegistrationPage.selectVehicleMark("MAN");
        vehicleRegistrationPage.enterVehicleMass("12000");
    }

    @Step("Жмет ОК в окне подтверждения регистрации ТС")
    public void clicksToConfirmVehicleRegistrationDialogButton() {
        vehicleRegistrationPage.clickToConfirmVehicleRegistrationDialogButton();
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

    @Step("Выбирает признак {0} для поиска ВТС и вводит в поле {1}")
    public void selectsByAndEntersQueryForSearch(String searchBy, String query) {
        selectActionDialog.clickToSearchClientButton();
        selectActionDialog.selectSearchClientBy(searchBy);
        selectActionDialog.enterSearchClientQuery(query);
    }

    @Step("Видит ВТС с искомыми данными")
    public void looksUpClientByQuery(String query) {
        selectActionDialog.shouldContainSearchedClient(query);
    }

    @Step("Выбирает ВТС {0} и контактное лицо для начала работы с обращением")
    public void selectsClientByQuery(String query) {
        selectActionDialog.clickToSearchedClient(query);
        selectActionDialog.selectContactPerson();
    }

    @Step("Видит последнее событие в истории текущего обращения")
    public void shouldSeeEventInCommonHistory(String theme, String details, String status) {
        shouldMatch(appealHistoryPopUp.getAppealHistory(), the("Тема", is(theme)),
                the("Детализация", is(details)),
                the("Результат", is(status)));
    }

    @Step("Закрывает окно истории текущего обращения")
    public void clicksToCloseHistoryPopUp() {
        appealHistoryPopUp.clickToClosePopUpButton();
    }

    @Step("Вводит сумму пополнения ЛС {0} рублей")
    public void enterAmountPaymentFromCreditCard(String amount) {
        newPaymentPage.enterAmountOfNewPayment(amount);
    }

    private void fillsClientLocationAddress(String clientAddressRegion,
                                            String clientAddressDistrict,
                                            String clientAddressCity,
                                            String clientAddressSettlement,
                                            String clientAddressStreet) {
        clientRegistrationPage.selectClientLocationAddressRegion(clientAddressRegion);
        clientRegistrationPage.selectClientLocationAddressDistrict(clientAddressDistrict);
        clientRegistrationPage.selectClientLocationAddressCity(clientAddressCity);
        clientRegistrationPage.selectClientLocationAddressSettlement(clientAddressSettlement);
        clientRegistrationPage.selectClientLocationAddressStreet(clientAddressStreet);
        clientRegistrationPage.enterClientLocationAddressHouse(getRandomNumber(3));
        clientRegistrationPage.enterClientLocationAddressHousing(getRandomNumber(1));
        clientRegistrationPage.enterClientLocationAddressBuilding(getRandomNumber(1));
        clientRegistrationPage.enterClientLocationAddressRoom(getRandomNumber(2));
//                clientRegistrationPage.enterClientLocationAddressIndex(getRandomNumber(6));
    }

    private void fillsIPLocationAddress(String clientAddressRegion,
                                        String clientAddressDistrict,
                                        String clientAddressCity,
                                        String clientAddressSettlement,
                                        String clientAddressStreet) {
        ipRegistrationPage.selectClientLocationAddressRegion(clientAddressRegion);
        ipRegistrationPage.selectClientLocationAddressDistrict(clientAddressDistrict);
        ipRegistrationPage.selectClientLocationAddressCity(clientAddressCity);
        ipRegistrationPage.selectClientLocationAddressSettlement(clientAddressSettlement);
        ipRegistrationPage.selectClientLocationAddressStreet(clientAddressStreet);
        ipRegistrationPage.enterClientLocationAddressHouse(getRandomNumber(3));
        ipRegistrationPage.enterClientLocationAddressHousing(getRandomNumber(1));
        ipRegistrationPage.enterClientLocationAddressBuilding(getRandomNumber(1));
        ipRegistrationPage.enterClientLocationAddressRoom(getRandomNumber(2));
//                ipRegistrationPage.enterClientLocationAddressIndex(getRandomNumber(6));
    }

    private void fillsOrganizationLocationAddress(String clientAddressRegion,
                                                  String clientAddressDistrict,
                                                  String clientAddressCity,
                                                  String clientAddressSettlement,
                                                  String clientAddressStreet) {
        organizationRegistrationPage.selectClientLocationAddressRegion(clientAddressRegion);
        organizationRegistrationPage.selectClientLocationAddressDistrict(clientAddressDistrict);
        organizationRegistrationPage.selectClientLocationAddressCity(clientAddressCity);
        organizationRegistrationPage.selectClientLocationAddressSettlement(clientAddressSettlement);
        organizationRegistrationPage.selectClientLocationAddressStreet(clientAddressStreet);
        organizationRegistrationPage.enterClientLocationAddressHouse(getRandomNumber(3));
        organizationRegistrationPage.enterClientLocationAddressHousing(getRandomNumber(1));
        organizationRegistrationPage.enterClientLocationAddressBuilding(getRandomNumber(1));
        organizationRegistrationPage.enterClientLocationAddressRoom(getRandomNumber(2));
//                organizationRegistrationPage.enterClientLocationAddressIndex(getRandomNumber(6));
    }
}
