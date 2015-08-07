package ru.progresspoint.svp12.lk.steps;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.matchers.BeanMatcher;
import net.thucydides.core.steps.ScenarioSteps;
import org.joda.time.DateTime;
import org.openqa.selenium.WebElement;
import ru.progresspoint.svp12.lk.pages.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static net.serenitybdd.core.Serenity.getCurrentSession;
import static net.thucydides.core.matchers.BeanMatcherAsserts.shouldMatch;
import static net.thucydides.core.matchers.BeanMatchers.the;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.jodatime.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.joda.time.DateTime.*;
import static org.joda.time.DateTime.parse;
import static org.joda.time.format.DateTimeFormat.forPattern;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.name;

/**
 * Шаги конечного пользователя АРМа Личный Кабинет
 */
public class LKUserSteps extends ScenarioSteps {

    final Random randomNum = new Random();

    LKLoginPage loginPage;
    LKMainPage mainPage;
    LKNewVehiclesGroupPage newVehiclesGroupPage;
    LKPaymentsPage paymentsPage;
    UnitellerPaymentsPage unitellerPage;
    LKAppealsPage appealsPage;
    LKAppealDetailPage appealDetailPage;
    LKNewAppealPage newAppealPage;
    LKAccountPage accountPage;
    LKBasicInfoPage basicInfoPage;
    LKVehicleInfoPage vehicleInfoPage;
    LKPasswordPage passwordPage;
    LKNewVehiclePage newVehiclePage;
    LKMainHeader mainHeader;


    @Step("Нажимает на ссылку {0}")
    public void clicksToLink(String linkText) {
        getDriver().findElement(linkText(linkText)).click();
    }

    @Step("Вводит данные учетной записи")
    public void entersAccountData(String registrationEmail) {
        fillsAccountData(registrationEmail);
    }

    @Step("Выбирает из списка тип ВТС {0}")
    public void selectsClientType(String clientType) {
        accountPage.selectClientType(clientType);
    }

    @Step("Выбирает из списка страну резиденства {0}")
    public void selectsClientCountry(String clientCountry) {
        accountPage.selectClientCountry(clientCountry);
    }

    @Step("Вводит CAPTCHA")
    public void entersCaptcha(String captcha) {
        accountPage.enterCaptcha(captcha);
    }

    @Step("Нажимает на кнопку подтверждения")
    public void clicksToConfirmButton() {
        getDriver().findElement(name("commit")).click();
    }

    @Step("Вводит данные ИП")
    public void entersIPData(String clientEmail) {
        fillsClientData(clientEmail);
        fillsClientRegistrationAddress("Город Санкт-Петербург, улица Иркутская");
        fillsClientLocationAddress("Город Москва, Театральный проезд");
        fillsClientPostalAddress("Ивановская область, город Иваново, улица Лежневская");
        fillsClientBankData();
    }

    @Step("Вводит данные ЮЛ")
    public void entersULData(String organizationEmail) {
        fillsOrganizationData(organizationEmail);
        fillsDirectorData(organizationEmail);
        fillsDirectorDocuments();
        fillsDirectorPersonalDocument();
        fillsClientRegistrationAddress("Город Санкт-Петербург, улица Иркутская");
        fillsClientLocationAddress("Город Москва, Театральный проезд");
        fillsClientPostalAddress("Ивановская область, город Иваново, улица Лежневская");
        fillsClientBankData();
    }

    @Step("Вводит данные ФЛ")
    public void entersFLData() {
        fillsClientRegistrationAddress("Костромская область, Костромской район, город Кострома, улица Сусанина Ивана");
        fillsClientLocationAddress("Новосибирская область, город Новосибирск, улица Парижской Коммуны");
        fillsClientBankData();
    }

    @Step("Прикладывает скан-копии документов ИП")
    public void uploadsIPDocumentsCopies() {
        basicInfoPage.uploadIPDocumentsCopies(
                "documents/CertificateOfStateRegistration.jpg",
                "documents/INN.jpg",
                "documents/CertificateOfAbsenceTaxDebt.jpg",
                "documents/CertificateOfAbsencePFRDebt.jpg",
                "documents/CertificateOfAbsenceFSSDebt.png",
                "documents/CertificateOfAbsenceFMSDebt.png"
        );
    }

    @Step("Прикладывает скан-копии документов ЮЛ")
    public void uploadsULDocumentsCopies() {
        basicInfoPage.uploadULDocumentsCopies(
                "documents/StatuteSecondPage.jpg",
                "documents/CertificateOfStateRegistration.jpg",
                "documents/INN.jpg",
                "documents/EGRUL.jpg",
                "documents/CertificateOfAbsenceTaxDebt.jpg",
                "documents/CertificateOfAbsencePFRDebt.jpg",
                "documents/CertificateOfAbsenceFSSDebt.png",
                "documents/CertificateOfAbsenceFMSDebt.png"
        );
    }

    @Step("Прикладывает скан-копии документов ФЛ")
    public void uploadsFLDocumentsCopies() {
        basicInfoPage.uploadFLDocumentsCopies("documents/CertificateOfAbsenceTaxDebt.jpg");
    }

    @Step("Вводит данные ТС")
    public void entersVehicleData() {
        String vehicleRegistrationGRNZ = "T" + getRandomNumber(3) + "TT" + getRandomNumber(2);
        String registrationDocumentNumber = getRandomNumber(10);
        String vehicleVIN = getRandomNumber(17);

        vehicleInfoPage.selectVehicleRegistrationCountry("Российская Федерация");
        vehicleInfoPage.enterVehicleRegistrationGRNZ(vehicleRegistrationGRNZ);
        vehicleInfoPage.selectVehicleBasisType("Собственность");
        vehicleInfoPage.enterVehicleRegistrationDocumentNumber(registrationDocumentNumber);
        vehicleInfoPage.selectVehicleMark("Volvo");
        vehicleInfoPage.enterVehicleVIN(vehicleVIN);
        vehicleInfoPage.selectVehicleMass("более 12 тонн");
    }

    @Step("Прикладывает скан-копии документов ТС")
    public void uploadsVehicleDocumentsCopies() {
        vehicleInfoPage.uploadVehicleDocumentsCopies("documents/STS_1.jpg", "documents/STS_2.jpg");
    }

    @Step("Вводит пароль {0}")
    public void entersPassword(String password) {
        passwordPage.enterPassword(password);
        passwordPage.enterConfirmPassword(password);
    }

//    @Step("Нажимает Зарегистрировать ТС")

    @Step("Вводит данные ТС")
    public void entersNewVehicleData(String vehicleData) {
        newVehiclePage.enterVehicleData(vehicleData);
    }

    @Step("Прикладывает скан-копии документов ТС")
    public void uploadsNewVehicleDocumentsCopies(String filename) {
        newVehiclePage.uploadVehicleDocumentsCopies(filename);
    }

//    @Step("Нажимает Зарегистрировать")

//    Перейти на вкладку «Основная информация».

//    @Step("Нажимает на кнопку Редактировать")
//
//    @Step("Вводит изменения в регистрационные данные")
//    @Step("Нажимает на кнопку Сохранить")
//    @Step("Нажимает на кнопку Редактировать")
//    @Step("Вводит изменения в регистрационные данные")
//    @Step("Нажимает на кнопку Сохранить")


    @Step("Вводит логин {0} и пароль {1}")
    public void entersLoginAndPassword(String login, String password) {
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
    }

    @Step("Вводит название новой группы {0}")
    public void entersNameForNewGroupVehicles(String groupName) {
        newVehiclesGroupPage.enterVehiclesGroupName(groupName);
    }

    @Step("Выбирает из списка {0} машин(ы) для новой группы")
    public void selectsVehiclesForGroup(int amountVehicles) {
        for (int vehicle = 0; vehicle < amountVehicles; vehicle++) {
            WebElement targetVehicle =
                    newVehiclesGroupPage
                            .getAllVehicles()
                            .get(amountVehicles);
            WebElement addToGroupCheckBox =
                    targetVehicle.findElement(By.xpath(".//i[@class='checkbox__field']"));
            addToGroupCheckBox.click();
        }
    }

    @Step("Вводит {0} рублей в окне Пополениние счета и жмет Оплатить")
    public void entersFundsAmount(String fundsAmount) {
        paymentsPage.shouldBeDisplayedAddFundsPopUp();
        // Запоминаем баланс лс до пополнения для следующей проверки
        getCurrentSession().put("oldAccountBalance", paymentsPage.getCurrentAccountBalance());
        paymentsPage.enterFundsAmount(fundsAmount);
        paymentsPage.clickToPayPopUpLink();
    }

    @Step("Вводит данные карты и оплачивает счет")
    public void entersCardDataAndPay(String cardData) {
        unitellerPage.entersCardData(cardData);
        unitellerPage.clickToPayButton();
    }

    @Step("Нажимает на кнопку Вернуться в магазин")
    public void clicksToComesBackToShopButton() {
        unitellerPage.clickToComesBackButton();
        mainPage.shouldBeDisplayed();
    }

    @Step("Вводит период тразакций с {0} по {1}")
    public void entersPeriodTransactionsDates(String startDate, String endDate) {
        paymentsPage.enterStartTransactionsDate(startDate);
        paymentsPage.enterEndTransactionsDate(endDate);
    }

    @Step("Выбирает из списка тип тразакций {0}")
    public void selectsTransactionsType(String transactionsType) {
        paymentsPage.setTypeTransactions(transactionsType);
    }

    @Step("Сравнивает баланс ЛС до пополнения и после")
    public void shouldSeeBalancesDifference() {
        String oldAccountBalance = (String) Serenity.getCurrentSession().get("oldAccountBalance");
        String currentAccountBalance = mainPage.getsCurrentAccountBalance();
        assertThat(currentAccountBalance)
                .overridingErrorMessage("Баланс parse(лицевого счета на главной странице не изменился")
                .isNotEqualTo(oldAccountBalance);
    }

    @Step("Видит транзакции c {0} по {1}")
    public void shouldSeeTransactionsDatesBetween(DateTime startDay, DateTime endDay) {
        List<String> dates = paymentsPage.getDatesSearchedTransactions();
        for (String date : dates) {
            assertThat(startDay).isBefore(parse(date));
            assertThat(endDay).isAfter(parse(date));
        }
    }

    @Step("Вводит данные в форму подачи обращения")
    public void entersAppealDetails() {
        getCurrentSession().put("appealTitle", getRandomCyrillicProperString(12));
        getCurrentSession().put("appealText", getRandomCyrillicProperString(4) + getRandomAlphabeticString(8) + getRandomNumber(4));
        newAppealPage.enterAppealTitle((String) getCurrentSession().get("appealTitle"));
        newAppealPage.enterAppealText((String) getCurrentSession().get("appealText"));
    }

    @Step("Прикладывает дополнительный документ")
    public void uploadsAdditionalDocument() {
        newAppealPage.uploadAdditionalDocument("documents/Appeal.pdf");
    }

    @Step("Нажимает на кнопку Ок в окне подтверждения отправки обращения")
    public void clicksToOkInConfirmationAppealPopUp() {
        newAppealPage.clickToOkConfirmationPopUp();
    }

    @Step("Находит обращение в общем списке")
    public void shouldSeeAppealInCommonList() {
        shouldMatch(appealsPage.getSearchAppeals(), the("ТЕМА:", is((String) getCurrentSession().get("appealTitle"))));
    }

    @Step("Находит обращения за последние 3 месяца")
    public void shouldSeeAppealForLastThreeMonth() {
        DateTime today = now();
        DateTime startDay = today.minusMonths(3);
        for( Map<Object, String> row : appealsPage.getSearchAppeals()) {
            String date = row.get("ПОДАНО:");
            assertThat(parse(date, forPattern("yyyy-MM-dd HH:mm")))
                    .isAfterOrEqualTo(startDay)
                    .isBefore(today);
        }
    }

    @Step("Нажимает на обращение дл просмотра деталей")
    public void clicksToAppealForDetail() {
        BeanMatcher matchers = the("ТЕМА:", is((String) getCurrentSession().get("appealTitle")));
        appealsPage.clickOnAppeal(matchers);
    }

    @Step("Находит в обращении все детали")
    public void shouldSeeCorrectAppealDetail() {
        assertThat(appealDetailPage.getAppealTitle())
                .overridingErrorMessage("Тема обращения не верная")
                .isEqualTo((String) getCurrentSession().get("appealTitle"));
        assertThat(appealDetailPage.getAppealText())
                .overridingErrorMessage("Текст обращения не верный")
                .isEqualTo((String) getCurrentSession().get("appealText"));
        assertThat(appealDetailPage.getAppealAdditionalFileName())
                .overridingErrorMessage("Имя приложенного файла к обращению не верный")
                .isEqualTo("Appeal.pdf");
    }

//    @Step("Нажимает на кнопку Запросить историю")

    @Step("Вводит период обращений с {0} по {1}")
    public void entersPeriodAppealsDates(String startDate, String endDate) {
        appealsPage.enterStartAppealsDate(startDate);
        appealsPage.enterEndAppealsDate(endDate);
    }

//    @Step("Нажимает на кнопку Запросить историю")


    @Step("Нажимает на кнопку Уведомления")
    public void clicksToNotificationsButton() {
        mainHeader.clickToNotificationsButton();
    }

    /**
     * Генератор случайного слова на латиннице
     *
     * @param count - количество символов в результате
     * @return - случайное слово на латиннице в LowerCase формате
     */
    private String getRandomAlphabeticString(int count) {
        return randomAlphabetic(count).toLowerCase();
    }

    /**
     * Генератор случайного слова на кириллице
     *
     * @param count - количество символов в результате
     * @return - случайное слово на кириллице в ProperCase формате
     */
    private String getRandomCyrillicProperString(int count) {
        String result = random(count, "абвгдеёжзийклмнопрстуфхцчшщъыьэюя");
        return capitalize(result);
    }

    /**
     * Генератор случайного слова из цифр
     *
     * @param count - количество цифр в результате
     * @return - случайное слово состоящие из цифр
     */
    private String getRandomNumber(int count) {
        String result = "";
        for (int i = 0; i < count; i++) result += String.valueOf(randomNum.nextInt(10));
        return result;
    }

    /**
     * Генератор случайной даты
     *
     * @return - случайная дата между 1940 и 2015 годом
     */
    private String getRandomDate() {

        DateTime date;
        long ms;

        // Получить значение Epoch между 1940 и 2015:
        // -946771200000L = 1 января, 1940
        // прибавить к этому 75 лет
        ms = -946771200000L + (Math.abs(randomNum.nextLong()) % (75L * 365 * 24 * 60 * 60 * 1000));

        // Собрать дату
        date = new DateTime(ms);
        return String.valueOf(date.toString("dd.MM.yyyy"));
    }

    private void fillsAccountData(String registrationEmail) {
        String randomForEmail = getRandomNumber(6);
        String registrationPhone = getRandomNumber(10);
        String registrationSurname = getRandomCyrillicProperString(7);
        String registrationName = getRandomCyrillicProperString(5);
        String registrationPatronymic = getRandomCyrillicProperString(10);
        String registrationDocumentNumber = getRandomNumber(10);
        String registrationDocumentDate = getRandomDate();
        String registrationDocumentBy = getRandomCyrillicProperString(12);

        accountPage.enterRegistrationLogin(registrationEmail.replace("@gmail.com", "+" + randomForEmail + "@gmail.com"));
        accountPage.enterRegistrationPhone(registrationPhone);
        accountPage.enterRegistrationPosition("Тестовый аккаунт");
        accountPage.enterRegistrationSurname(registrationSurname);
        accountPage.enterRegistrationName(registrationName);
        accountPage.enterRegistrationPatronymic(registrationPatronymic);
        accountPage.selectRegistrationDocumentType("Паспорт");
        accountPage.enterRegistrationDocumentNumber(registrationDocumentNumber);
        accountPage.enterRegistrationDocumentIssuedDate(registrationDocumentDate);
        accountPage.enterRegistrationDocumentIssuedBy(registrationDocumentBy);
    }

    private void fillsClientData(String clientEmail) {
        String randomForEmail = getRandomNumber(6);
        String clientShortName = getRandomCyrillicProperString(10);
        String clientName = getRandomCyrillicProperString(5);
        String clientINN = getRandomNumber(12);
        String clientOGRN = getRandomNumber(15);
        String clientPhone = getRandomNumber(10);

        basicInfoPage.enterClientShortName(clientShortName);
        basicInfoPage.enterClientName(clientName);
        basicInfoPage.enterClientINN(clientINN);
        basicInfoPage.enterClientOGRN(clientOGRN);
        basicInfoPage.enterClientMainEmail(clientEmail.replace("@gmail.com", "+" + randomForEmail + "@gmail.com"));
        basicInfoPage.enterClientMainPhone(clientPhone);
    }

    private void fillsOrganizationData(String organizationEmail) {
        basicInfoPage.selectOrganizationOPF("Общества с ограниченной ответственностью");
        fillsClientData(organizationEmail);
    }

    private void fillsDirectorData(String directorEmail) {
        String randomForEmail = getRandomNumber(6);
        String directorSurname = getRandomCyrillicProperString(7);
        String directorName = getRandomCyrillicProperString(5);
        String directorPatronymic = getRandomCyrillicProperString(10);
        String directorPhone = getRandomNumber(10);

        basicInfoPage.enterDirectorSurname(directorSurname);
        basicInfoPage.enterDirectorName(directorName);
        basicInfoPage.enterDirectorPatronymic(directorPatronymic);
        basicInfoPage.enterDirectorPhone(directorPhone);
        basicInfoPage.enterDirectorLogin(directorEmail.replace("@gmail.com", "+" + randomForEmail + "@gmail.com"));
        basicInfoPage.enterDirectorPosition("Генеральный директор");
    }

    private void fillsDirectorDocuments() {
        String directorDocumentNumber = getRandomNumber(10);
        String directorDocumentDate = getRandomDate();

        basicInfoPage.selectDirectorDocumentType("Устав");
        basicInfoPage.enterDirectorDocumentNumber(directorDocumentNumber);
        basicInfoPage.enterDirectorDocumentIssuedDate(directorDocumentDate);
        basicInfoPage.enterDirectorDocumentValidity("31.12.2015");
    }

    private void fillsDirectorPersonalDocument() {
        String directorPersonalDocumentNumber = getRandomNumber(10);
        String directorPersonalDocumentDate = getRandomDate();
        String directorPersonalDocumentBy = getRandomCyrillicProperString(12);

        basicInfoPage.selectDirectorPersonalDocumentType("Удостоверение личности военнослужащего РФ");
        basicInfoPage.enterDirectorPersonalDocumentNumber(directorPersonalDocumentNumber);
        basicInfoPage.enterDirectorPersonalDocumentIssuedDate(directorPersonalDocumentDate);
        basicInfoPage.enterDirectorPersonalDocumentIssuedBy(directorPersonalDocumentBy);
    }

    private void fillsClientRegistrationAddress(String registrationAddressKladr) {
        String registrationAddressIndex = getRandomNumber(6);
        String registrationAddressHouse = getRandomNumber(3);
        String registrationAddressHousing = getRandomNumber(1);
        String registrationAddressBuilding = getRandomNumber(1);
        String registrationAddressRoom = getRandomNumber(2);

        basicInfoPage.selectClientRegistrationAddressKladr(registrationAddressKladr);
        basicInfoPage.enterClientRegistrationAddressIndex(registrationAddressIndex);
        basicInfoPage.enterClientRegistrationAddressHouse(registrationAddressHouse);
        basicInfoPage.enterClientRegistrationAddressHousing(registrationAddressHousing);
        basicInfoPage.enterClientRegistrationAddressBuilding(registrationAddressBuilding);
        basicInfoPage.enterClientRegistrationAddressRoom(registrationAddressRoom);
    }

    private void fillsClientLocationAddress(String locationAddressKladr) {
        String locationAddressIndex = getRandomNumber(6);
        String locationAddressHouse = getRandomNumber(3);
        String locationAddressHousing = getRandomNumber(1);
        String locationAddressBuilding = getRandomNumber(1);
        String locationAddressRoom = getRandomNumber(2);

        basicInfoPage.selectClientLocationAddressKladr(locationAddressKladr);
        basicInfoPage.enterClientLocationAddressIndex(locationAddressIndex);
        basicInfoPage.enterClientLocationAddressHouse(locationAddressHouse);
        basicInfoPage.enterClientLocationAddressHousing(locationAddressHousing);
        basicInfoPage.enterClientLocationAddressBuilding(locationAddressBuilding);
        basicInfoPage.enterClientLocationAddressRoom(locationAddressRoom);
    }

    private void fillsClientPostalAddress(String postalAddressKladr) {
        String postalAddressIndex = getRandomNumber(6);
        String postalAddressHouse = getRandomNumber(3);
        String postalAddressHousing = getRandomNumber(1);
        String postalAddressBuilding = getRandomNumber(1);
        String postalAddressRoom = getRandomNumber(2);

        basicInfoPage.selectClientPostalAddressKladr(postalAddressKladr);
        basicInfoPage.enterClientPostalAddressIndex(postalAddressIndex);
        basicInfoPage.enterClientPostalAddressHouse(postalAddressHouse);
        basicInfoPage.enterClientPostalAddressHousing(postalAddressHousing);
        basicInfoPage.enterClientPostalAddressBuilding(postalAddressBuilding);
        basicInfoPage.enterClientPostalAddressRoom(postalAddressRoom);
    }

    private void fillsClientBankData() {
        String clientBankName = getRandomCyrillicProperString(6);
        String clientBankBIK = getRandomNumber(9);
        String clientBankINN = getRandomNumber(10);
        String clientBankKorNumber = getRandomNumber(20);
        String clientAccountNumber = getRandomNumber(20);
        String clientBankReceiverName = getRandomCyrillicProperString(18);

        basicInfoPage.enterClientBankName(clientBankName);
        basicInfoPage.enterClientBankBIK(clientBankBIK);
        basicInfoPage.enterClientBankINN(clientBankINN);
        basicInfoPage.enterClientBankKorNumber(clientBankKorNumber);
        basicInfoPage.enterClientBankAccountNumber(clientAccountNumber);
        basicInfoPage.enterClientBankReceiverName(clientBankReceiverName);
    }
}