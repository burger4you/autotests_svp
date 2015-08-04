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

import static net.thucydides.core.matchers.BeanMatcherAsserts.shouldMatch;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.assertj.core.api.Assertions.assertThat;
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
        String registrationPhone = getRandomNumber(10);
        String registrationSurname = getRandomCyrillicProperString(7);
        String registrationName = getRandomCyrillicProperString(5);
        String registrationPatronymic = getRandomCyrillicProperString(10);
        String registrationDocumentNumber = getRandomNumber(10);
        String registrationDocumentDate = getRandomDate();
        String registrationDocumentBy = getRandomCyrillicProperString(12);

        accountPage.enterRegistrationLogin(registrationEmail);
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

    @Step("Выбирает из списка тип ВТС {0}")
    public void selectsOwnerType(String ownerType) {
        accountPage.selectOwnerType(ownerType);
    }

    @Step("Выбирает из списка страну резиденства {0}")
    public void selectsOwnerCountry(String ownerCountry) {
        accountPage.selectOwnerCountry(ownerCountry);
    }

    @Step("Вводит CAPTCHA")
    public void entersCaptcha(String captcha) {
        accountPage.enterCaptcha(captcha);
    }

    @Step("Нажимает на кнопку подтверждения")
    public void clicksToConfirmButton() {
        getDriver().findElement(name("commit")).click();
    }

    @Step("Вводит данные ВТС")
    public void entersOwnerData(String ownerEmail) {
        fillsPersonalOwnerData(ownerEmail);
        fillsOwnerRegistrationAddress("Город Санкт-Петербург, улица Иркутская");
        fillsOwnerLocationAddress("Город Москва, Театральный проезд");
        fillsOwnerPostalAddress("Ивановская область, город Иваново, улица Лежневская");
        fillsOwnerBankData();
    }

//    @Step("Прикладывает скан-копии документов ВТС")
//    public void uploadsOwnerDocumentsCopies(String filename) {
//        basicInfoPage.uploadOwnerDocumentsCopies(filename);
//    }

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
    }

//    @Step("Нажимает кнопку Войти в Личный кабинет")

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
        Serenity.getCurrentSession().put("oldAccountBalance", paymentsPage.getCurrentAccountBalance());
        paymentsPage.enterFundsAmount(fundsAmount);
        paymentsPage.clickToPayPopUpLink();
    }

    @Step("Вводит данные карты и оплачивает счет")
    public void entersCardDataAndPay(String cardData) {
        unitellerPage.entersCardData(cardData);
        unitellerPage.clickToPayButton();
    }

    @Step("Сравнивает баланс ЛС до пополнения и после")
    public void shouldSeeBalancesDifference() {
        String oldAccountBalance = (String) Serenity.getCurrentSession().get("oldAccountBalance");
        String currentAccountBalance = mainPage.getsCurrentAccountBalance();
        assertThat(currentAccountBalance)
                .overridingErrorMessage("Баланс лицевого счета на главной странице не изменился")
                .isNotEqualTo(oldAccountBalance);
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

    @Step("Видит отфильтрованные транзакции")
    public void shouldSeeTransactionsWhere(BeanMatcher... matchers) {
        List<Map<Object, String>> transactions = paymentsPage.getSearchTransactions();
        int countRows = transactions.size();
        transactions.remove(countRows - 1);
        transactions.remove(countRows - 2);
        transactions.remove(countRows - 3);
        shouldMatch(transactions, matchers);
    }


    @Step("Вводит данные в форму подачи обращения")
    public void entersAppealDetails(String title, String theme, String text) {
        newAppealPage.enterAppealTitle(title);
        newAppealPage.setAppealTheme(theme);
        newAppealPage.enterAppealText(text);

    }

    @Step("Нажимает на кнопку Загрузить новый файл")
    public void clicksToUploadNewFileButton() {
        getDriver().findElement(name("")).click();
    }

    @Step("Прикрепляет файл {0}")
    public void uploadFile(String filename) {
        newAppealPage.upload(filename);
    }

    @Step("Находит обращение {0} в списке")
    public void findsAppealInList(String appealTitle) {

    }

    @Step("Нажимает на обращение {0} для просмотра")
    public void opensAppealForDetail(String appealTitle) {

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

    private void fillsPersonalOwnerData(String ownerEmail) {
        String ownerShortName = getRandomCyrillicProperString(10);
        String ownerName = getRandomCyrillicProperString(5);
        String ownerINN = getRandomNumber(10);
        String ownerOGRN = getRandomNumber(15);
        String ownerPhone = getRandomNumber(10);

        basicInfoPage.enterOwnerShortName(ownerShortName);
        basicInfoPage.enterOwnerName(ownerName);
        basicInfoPage.enterOwnerINN(ownerINN);
        basicInfoPage.enterOwnerOGRN(ownerOGRN);
        basicInfoPage.enterOwnerMainEmail(ownerEmail);
        basicInfoPage.enterOwnerMainPhone(ownerPhone);
    }

    private void fillsOwnerRegistrationAddress(String registrationAddressKladr) {
        String registrationAddressIndex = getRandomNumber(6);
        String registrationAddressHouse = getRandomNumber(3);
        String registrationAddressHousing = getRandomNumber(1);
        String registrationAddressBuilding = getRandomNumber(1);
        String registrationAddressRoom = getRandomNumber(2);

        basicInfoPage.selectOwnerRegistrationAddressKladr(registrationAddressKladr);
        basicInfoPage.enterOwnerRegistrationAddressIndex(registrationAddressIndex);
        basicInfoPage.enterOwnerRegistrationAddressHouse(registrationAddressHouse);
        basicInfoPage.enterOwnerRegistrationAddressHousing(registrationAddressHousing);
        basicInfoPage.enterOwnerRegistrationAddressBuilding(registrationAddressBuilding);
        basicInfoPage.enterOwnerRegistrationAddressRoom(registrationAddressRoom);
    }

    private void fillsOwnerLocationAddress(String locationAddressKladr) {
        String locationAddressIndex = getRandomNumber(6);
        String locationAddressHouse = getRandomNumber(3);
        String locationAddressHousing = getRandomNumber(1);
        String locationAddressBuilding = getRandomNumber(1);
        String locationAddressRoom = getRandomNumber(2);

        basicInfoPage.selectOwnerLocationAddressKladr(locationAddressKladr);
        basicInfoPage.enterOwnerLocationAddressIndex(locationAddressIndex);
        basicInfoPage.enterOwnerLocationAddressHouse(locationAddressHouse);
        basicInfoPage.enterOwnerLocationAddressHousing(locationAddressHousing);
        basicInfoPage.enterOwnerLocationAddressBuilding(locationAddressBuilding);
        basicInfoPage.enterOwnerLocationAddressRoom(locationAddressRoom);
    }

    private void fillsOwnerPostalAddress(String postalAddressKladr) {
        String postalAddressIndex = getRandomNumber(6);
        String postalAddressHouse = getRandomNumber(3);
        String postalAddressHousing = getRandomNumber(1);
        String postalAddressBuilding = getRandomNumber(1);
        String postalAddressRoom = getRandomNumber(2);

        basicInfoPage.selectOwnerPostalAddressKladr(postalAddressKladr);
        basicInfoPage.enterOwnerPostalAddressIndex(postalAddressIndex);
        basicInfoPage.enterOwnerPostalAddressHouse(postalAddressHouse);
        basicInfoPage.enterOwnerPostalAddressHousing(postalAddressHousing);
        basicInfoPage.enterOwnerPostalAddressBuilding(postalAddressBuilding);
        basicInfoPage.enterOwnerPostalAddressRoom(postalAddressRoom);
    }

    private void fillsOwnerBankData() {
        String ownerBankName = getRandomCyrillicProperString(6);
        String ownerBankBIK = getRandomNumber(9);
        String ownerBankINN = getRandomNumber(10);
        String ownerBankKorNumber = getRandomNumber(20);
        String ownerAccountNumber = getRandomNumber(20);
        String ownerBankReceiverName = getRandomCyrillicProperString(18);

        basicInfoPage.enterOwnerBankName(ownerBankName);
        basicInfoPage.enterOwnerBankBIK(ownerBankBIK);
        basicInfoPage.enterOwnerBankINN(ownerBankINN);
        basicInfoPage.enterOwnerBankKorNumber(ownerBankKorNumber);
        basicInfoPage.enterOwnerBankAccountNumber(ownerAccountNumber);
        basicInfoPage.enterOwnerBankReceiverName(ownerBankReceiverName);
    }
}