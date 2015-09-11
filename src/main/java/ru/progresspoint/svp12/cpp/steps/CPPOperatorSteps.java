package ru.progresspoint.svp12.cpp.steps;


import net.thucydides.core.annotations.Step;
import ru.progresspoint.svp12.RandomGenerators;
import ru.progresspoint.svp12.cpp.pages.*;

import static java.lang.String.format;
import static net.serenitybdd.core.Serenity.getCurrentSession;
import static net.thucydides.core.matchers.BeanMatcherAsserts.shouldMatch;
import static net.thucydides.core.matchers.BeanMatchers.the;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.By.*;

/**
 * Шаги оператора АРМа ЦИПП
 */
public class CPPOperatorSteps extends RandomGenerators {

    CPPLoginPage loginPage;
    CPPSelectActionDialog selectActionDialog;
    CPPClientRegistrationPage clientRegistrationPage;
    CPPVehicleRegistrationPage vehicleRegistrationPage;
    CPPIPRegistrationPage ipRegistrationPage;
    CPPOrganizationRegistrationPage organizationRegistrationPage;
    CPPClientNonresidentRegistrationPage clientNonresidentRegistrationPage;
    CPPIPNonresidentRegistrationPage ipNonresidentRegistrationPage;
    CPPOrganizationNonresidentRegistrationPage organizationNonresidentRegistrationPage;
    CPPAppealHistoryPopUp appealHistoryPopUp;

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

    @Step("Вводит данные ИП")
    public void entersIPData(String ipEmail) {
        fillsIPData(ipEmail, "Паспорт");
        fillsIPRegistrationAddress("Санкт-Петербург", "", "", "", "Иркутская");
        fillsIPLocationAddress("Совпадает с адресом регистрации");
        fillsIPPostalAddress("Совпадает с адресом регистрации");
    }

    @Step("Вводит данные ЮЛ")
    public void entersULData(String organizationEmail) {
        fillsOrganizationData(organizationEmail);
        fillsOrganizationRegistrationAddress("Санкт-Петербург", "", "", "", "Иркутская");
        fillsOrganizationLocationAddress("Совпадает с адресом регистрации");
        fillsOrganizationPostalAddress("Совпадает с адресом регистрации");
        fillsDirectorData(organizationEmail, "Удостоверение личности военнослужащего РФ");
    }

    @Step("Вводит данные ФЛ")
    public void entersFLData(String clientEmail) {
        fillsClientPersonalData(clientEmail, "Паспорт");
        fillsClientRegistrationAddress("Санкт-Петербург", "", "", "", "Иркутская");
        fillsClientLocationAddress("Совпадает с адресом регистрации");
        fillsClientPostalAddress("Совпадает с адресом регистрации");
    }

    @Step("Вводит данные ИП, нерезидента РФ")
    public void entersIPNonresidentData(String ipEmail) {
        fillsIPData(ipEmail, "Паспорт иностранного гражданина");
        fillsIPNonresidentAddress();
    }

    @Step("Вводит данные ЮЛ, нерезидента РФ")
    public void entersULNonresidentData(String organizationEmail) {
        fillsOrganizationNonresidentData(organizationEmail);
        fillsOrganizationNonresidentAddress();
        fillsDirectorData(organizationEmail, "Паспорт иностранного гражданина");
    }

    @Step("Вводит данные ФЛ, нерезидента РФ")
    public void entersFLNonresidentData(String clientEmail) {
        fillsClientPersonalData(clientEmail, "Паспорт иностранного гражданина");
        fillsClientNonresidentAddress();
    }

    @Step("Вводит данные дополнительного лицевого счета")
    public void entersAccountData() {
        clientRegistrationPage.enterClientSecondAccountName(getRandomCyrillicProperString(6));
    }

    @Step("Вводит данные расчетного счета в банке")
    public void entersClientBankData() {
        clientRegistrationPage.enterClientBankName(getRandomCyrillicProperString(6));
        clientRegistrationPage.enterClientBankBIK(getRandomNumber(9));
        clientRegistrationPage.enterClientBankINN(getRandomNumber(10));
        clientRegistrationPage.enterClientBankKorNumber(getRandomNumber(20));
        clientRegistrationPage.enterClientBankAccountNumber(getRandomNumber(20));
        clientRegistrationPage.enterClientBankReceiverName(getRandomCyrillicProperString(18));
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

    @Step("Вводит в поле поиска ВТС {0}")
    public void searchClientByQuery(String query) {
        selectActionDialog.clickToSearchClientButton();
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
                the("Статус", is(status)));
    }

    @Step("Закрывает окно истории текущего обращения")
    public void clicksToCloseHistoryPopUp() {
        appealHistoryPopUp.clickToClosePopUpButton();
    }

    private void fillsClientPersonalData(String clientEmail, String clientDocumentType) {
        clientRegistrationPage.selectClientDocumentType(clientDocumentType);
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

    private void fillsIPData(String ipEmail, String ipDocumentType) {
        ipRegistrationPage.enterIPOGRN(getRandomNumber(15));
        ipRegistrationPage.enterIPINN(getRandomNumber(12));
        ipRegistrationPage.enterIPSurname(getRandomCyrillicProperString(7));
        ipRegistrationPage.enterIPName(getRandomCyrillicProperString(5));
        ipRegistrationPage.enterIPPatronymic(getRandomCyrillicProperString(10));
        ipRegistrationPage.enterIPShortName(getRandomCyrillicProperString(10));
        ipRegistrationPage.selectIPDocumentType(ipDocumentType);
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

    private void fillsDirectorData(String directorEmail, String directorDocumentType) {
        getCurrentSession().put("login", directorEmail.replace("@gmail.com", "+" + getRandomNumber(6) + "@gmail.com"));

        organizationRegistrationPage.enterDirectorSurname(getRandomCyrillicProperString(7));
        organizationRegistrationPage.enterDirectorName(getRandomCyrillicProperString(5));
        organizationRegistrationPage.enterDirectorPatronymic(getRandomCyrillicProperString(10));
        organizationRegistrationPage.selectDirectorPersonalDocumentType(directorDocumentType);
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

    private void fillsClientRegistrationAddress(String clientAddressRegion,
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

    private void fillsIPRegistrationAddress(String clientAddressRegion,
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

    private void fillsOrganizationRegistrationAddress(String clientAddressRegion,
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

    private void fillsClientLocationAddress(String locationAddress) {
        if (locationAddress.equals("Совпадает с адресом регистрации"))
            clientRegistrationPage.clickToLocationAddressSameAsRegistrationCheckBox();
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

    private void fillsIPLocationAddress(String locationAddress) {
        if (locationAddress.equals("Совпадает с адресом регистрации"))
            ipRegistrationPage.clickToLocationAddressSameAsRegistrationCheckBox();
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

    private void fillsOrganizationLocationAddress(String locationAddress) {
        if (locationAddress.equals("Совпадает с адресом регистрации"))
            organizationRegistrationPage.clickToLocationAddressSameAsRegistrationCheckBox();
    }

    private void fillsClientPostalAddress(String clientAddressRegion,
                                          String clientAddressDistrict,
                                          String clientAddressCity,
                                          String clientAddressSettlement,
                                          String clientAddressStreet) {
        clientRegistrationPage.selectClientPostalAddressRegion(clientAddressRegion);
        clientRegistrationPage.selectClientPostalAddressDistrict(clientAddressDistrict);
        clientRegistrationPage.selectClientPostalAddressCity(clientAddressCity);
        clientRegistrationPage.selectClientPostalAddressSettlement(clientAddressSettlement);
        clientRegistrationPage.selectClientPostalAddressStreet(clientAddressStreet);
        clientRegistrationPage.enterClientPostalAddressHouse(getRandomNumber(3));
        clientRegistrationPage.enterClientPostalAddressHousing(getRandomNumber(1));
        clientRegistrationPage.enterClientPostalAddressBuilding(getRandomNumber(1));
        clientRegistrationPage.enterClientPostalAddressRoom(getRandomNumber(2));
//                clientRegistrationPage.enterClientPostalAddressIndex(getRandomNumber(6));
    }

    private void fillsClientPostalAddress(String postalAddress) {
        if (postalAddress.equals("Совпадает с адресом регистрации"))
            clientRegistrationPage.clickToPostalAddressSameAsRegistrationCheckBox();
    }

    private void fillsIPPostalAddress(String clientAddressRegion,
                                      String clientAddressDistrict,
                                      String clientAddressCity,
                                      String clientAddressSettlement,
                                      String clientAddressStreet) {
        ipRegistrationPage.selectClientPostalAddressRegion(clientAddressRegion);
        ipRegistrationPage.selectClientPostalAddressDistrict(clientAddressDistrict);
        ipRegistrationPage.selectClientPostalAddressCity(clientAddressCity);
        ipRegistrationPage.selectClientPostalAddressSettlement(clientAddressSettlement);
        ipRegistrationPage.selectClientPostalAddressStreet(clientAddressStreet);
        ipRegistrationPage.enterClientPostalAddressHouse(getRandomNumber(3));
        ipRegistrationPage.enterClientPostalAddressHousing(getRandomNumber(1));
        ipRegistrationPage.enterClientPostalAddressBuilding(getRandomNumber(1));
        ipRegistrationPage.enterClientPostalAddressRoom(getRandomNumber(2));
//                ipRegistrationPage.enterClientPostalAddressIndex(getRandomNumber(6));
    }

    private void fillsIPPostalAddress(String postalAddress) {
        if (postalAddress.equals("Совпадает с адресом регистрации"))
            ipRegistrationPage.clickToPostalAddressSameAsRegistrationCheckBox();
    }

    private void fillsOrganizationPostalAddress(String clientAddressRegion,
                                                String clientAddressDistrict,
                                                String clientAddressCity,
                                                String clientAddressSettlement,
                                                String clientAddressStreet) {
        organizationRegistrationPage.selectClientPostalAddressRegion(clientAddressRegion);
        organizationRegistrationPage.selectClientPostalAddressDistrict(clientAddressDistrict);
        organizationRegistrationPage.selectClientPostalAddressCity(clientAddressCity);
        organizationRegistrationPage.selectClientPostalAddressSettlement(clientAddressSettlement);
        organizationRegistrationPage.selectClientPostalAddressStreet(clientAddressStreet);
        organizationRegistrationPage.enterClientPostalAddressHouse(getRandomNumber(3));
        organizationRegistrationPage.enterClientPostalAddressHousing(getRandomNumber(1));
        organizationRegistrationPage.enterClientPostalAddressBuilding(getRandomNumber(1));
        organizationRegistrationPage.enterClientPostalAddressRoom(getRandomNumber(2));
//                organizationRegistrationPage.enterClientPostalAddressIndex(getRandomNumber(6));
    }

    private void fillsOrganizationPostalAddress(String postalAddress) {
        if (postalAddress.equals("Совпадает с адресом регистрации"))
            organizationRegistrationPage.clickToPostalAddressSameAsRegistrationCheckBox();
    }

    private void fillsOrganizationNonresidentData(String organizationEmail) {
        organizationNonresidentRegistrationPage.enterRegistrationNumber(getRandomNumber(12));
        organizationNonresidentRegistrationPage.enterRegistrationOrgan(getRandomCyrillicProperString(12));
        organizationNonresidentRegistrationPage.enterTaxNumber(getRandomNumber(8));
        organizationNonresidentRegistrationPage.enterOrganizationINN(getRandomNumber(10));
        organizationNonresidentRegistrationPage.enterOrganizationName(getRandomCyrillicProperString(10));
        organizationNonresidentRegistrationPage.enterOrganizationShortName(getRandomCyrillicProperString(6));
        organizationNonresidentRegistrationPage.enterOrganizationMainPhone(getRandomNumber(11));
        organizationNonresidentRegistrationPage.enterOrganizationMainEmail(organizationEmail.replace("@gmail.com", "+" + getRandomNumber(6) + "@gmail.com"));
    }

    private void fillsClientNonresidentAddress() {
        clientNonresidentRegistrationPage.enterClientRegistrationAddress(getRandomCyrillicProperString(30));
        clientNonresidentRegistrationPage.clickToLocationAddressSameAsRegistrationCheckBox();
        clientNonresidentRegistrationPage.clickToPostalAddressSameAsRegistrationCheckBox();
    }

    private void fillsIPNonresidentAddress() {
        ipNonresidentRegistrationPage.enterClientRegistrationAddress(getRandomCyrillicProperString(30));
        ipNonresidentRegistrationPage.clickToLocationAddressSameAsRegistrationCheckBox();
        ipNonresidentRegistrationPage.clickToPostalAddressSameAsRegistrationCheckBox();
    }

    private void fillsOrganizationNonresidentAddress() {
        organizationNonresidentRegistrationPage.enterClientRegistrationAddress(getRandomCyrillicProperString(30));
        organizationNonresidentRegistrationPage.clickToLocationAddressSameAsRegistrationCheckBox();
        organizationNonresidentRegistrationPage.clickToPostalAddressSameAsRegistrationCheckBox();
    }
}
