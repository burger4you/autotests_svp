package ru.progresspoint.svp12.lk.steps;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.matchers.BeanMatcher;
import org.joda.time.DateTime;
import org.openqa.selenium.WebElement;
import ru.progresspoint.svp12.RandomGenerators;
import ru.progresspoint.svp12.lk.pages.*;

import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;
import static net.serenitybdd.core.Serenity.getCurrentSession;
import static net.thucydides.core.matchers.BeanMatcherAsserts.shouldMatch;
import static net.thucydides.core.matchers.BeanMatchers.the;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.jodatime.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.joda.time.DateTime.now;
import static org.joda.time.DateTime.parse;
import static org.joda.time.format.DateTimeFormat.forPattern;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.name;

/**
 * Шаги конечного пользователя АРМа Личный Кабинет
 */
public class LKUserSteps extends RandomGenerators {

    LKLoginPage loginPage;
    LKVehiclesGroupsPage vehiclesGroupsPage;
    LKNewVehiclesGroupPage newVehiclesGroupPage;
    LKVehiclesGroupDetailPage vehiclesGroupDetailPage;
    LKPaymentsPage paymentsPage;
    UnitellerPaymentsPage unitellerPage;
    LKAppealsPage appealsPage;
    LKAppealDetailPage appealDetailPage;
    LKNewAppealPage newAppealPage;
    LKStartRegistrationPage startRegistrationPage;
    LKClientRegistrationPage clientRegistrationPage;
    LKULRegistrationPage ulRegistrationPage;
    LKIPRegistrationPage ipRegistrationPage;
    LKVehicleInfoPage vehicleInfoPage;
    LKVehiclesPage vehiclesPage;
    LKPasswordPage passwordPage;
    LKNewVehiclePage newVehiclePage;
    LKMainHeader mainHeader;
    LKVehicleDetailPage vehicleDetailPage;


    @Step("Нажимает на ссылку {0}")
    public void clicksToLink(String linkText) {
        getDriver().findElement(linkText(linkText)).click();
    }

    @Step("Выбирает из списка тип ВТС {0}")
    public void selectsClientType(String clientType) {
        startRegistrationPage.selectClientType(clientType);
    }

    @Step("Выбирает из списка страну резиденства {0} и жмет далее")
    public void selectsClientCountry(String clientCountry) {
        startRegistrationPage.selectClientCountry(clientCountry);
        startRegistrationPage.clickSubmitButton();
    }

    @Step("Вводит CAPTCHA")
    public void entersCaptcha(String captcha) {
        clientRegistrationPage.enterCaptcha(captcha);
    }

    @Step("Нажимает на кнопку подтверждения")
    public void clicksToConfirmButton() {
        getDriver().findElement(name("commit")).click();
    }

    @Step("Вводит данные ИП")
    public void entersIPData(String clientEmail) {
        fillsIPData(clientEmail);
        fillsClientPersonalDocument();
    }

    @Step("Вводит данные ЮЛ")
    public void entersULData(String organizationEmail) {
        fillsOrganizationData(organizationEmail);
        fillsDirectorData(organizationEmail);
        fillsDirectorDocuments();
        fillsDirectorPersonalDocument();
    }

    @Step("Вводит данные ФЛ")
    public void entersFLData(String clientEmail) {
        fillsFLData(clientEmail);
    }

    @Step("Вводит адреса")
    public void entersAddressesData() {
        fillsClientRegistrationAddress("Костромская область, Костромской район, город Кострома, улица Сусанина Ивана");
        fillsClientLocationAddress("Новосибирская область, город Новосибирск, улица Парижской Коммуны");
        fillsClientPostalAddress("Ивановская область, город Иваново, улица Лежневская");
    }

    @Step("Вводит банковские реквизиты")
    public void entersBankData() {
        fillsClientBankData();
    }

    @Step("Соглашается с обработкой данных")
    public void confirmsAgreeCheckboxes() {
        selectsAgreeCheckboxes();
    }

    @Step("Прикладывает скан-копии документов ИП")
    public void uploadsIPDocumentsCopies() {
        ipRegistrationPage.uploadIPDocumentsCopies(
                "documents/CertificateOfStateRegistration.jpg",
                "documents/INN.jpg"
        );
    }

    @Step("Прикладывает скан-копии документов ЮЛ")
    public void uploadsULDocumentsCopies() {
        ulRegistrationPage.uploadULDocumentsCopies(
                "documents/StatuteSecondPage.jpg",
                "documents/CertificateOfStateRegistration.jpg",
                "documents/INN.jpg",
                "documents/EGRUL.jpg"
        );
    }

    @Step("Прикладывает скан-копии документов ФЛ")
    public void uploadsFLDocumentsCopies() {
        ipRegistrationPage.uploadFLDocumentsCopies("documents/CertificateOfAbsenceTaxDebt.jpg");
    }

    @Step("Вводит данные ТС")
    public void entersVehicleData() {
        String vehicleRegistrationGRNZ = "T" + getRandomNumber(3) + "TT" + getRandomNumber(2);
        String registrationDocumentNumber = getRandomNumber(10);
        String vehicleVIN = getRandomNumber(17);

        vehicleInfoPage.loading();
        vehicleInfoPage.selectVehicleRegistrationCountry("Российская Федерация");
        vehicleInfoPage.enterVehicleRegistrationGRNZ(vehicleRegistrationGRNZ);
        vehicleInfoPage.selectVehicleBasisType("Собственность");
        vehicleInfoPage.enterVehicleRegistrationDocumentNumber(registrationDocumentNumber);
        vehicleInfoPage.selectVehicleMark("Volvo");
        vehicleInfoPage.enterVehicleVIN(vehicleVIN);
        vehicleInfoPage.enterVehicleMass("более 12 тонн");
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

    @Step("Вводит данные нового ТС")
    public void entersNewVehicleData() {
        getCurrentSession().put("vehicleGRNZ", getRandomNumber(3));
        getCurrentSession().put("vehicleCountry", "Российская Федерация");
        getCurrentSession().put("vehicleBasisType", "Договор лизинга");
        String registrationDocumentNumber = getRandomNumber(10);

        newVehiclePage.enterVehicleGRNZ("A" + getCurrentSession().get("vehicleGRNZ") + "AA" + getRandomNumber(3));
        newVehiclePage.selectVehicleCountry((String) getCurrentSession().get("vehicleCountry"));
        newVehiclePage.selectVehicleBasisType((String) getCurrentSession().get("vehicleBasisType"));
        newVehiclePage.enterVehicleDocumentNumber(registrationDocumentNumber);
        newVehiclePage.selectVehicleMark("Ariel");
        newVehiclePage.enterVehicleVIN(getRandomNumber(17));
        newVehiclePage.enterVehicleMass("более 12 тонн");
//        newVehiclePage.selectAccountId("№ 101 000 001 010");
//        newVehiclePage.selectVehicleGroup("");
    }

    @Step("Прикладывает скан-копии документов ТС")
    public void uploadsNewVehicleDocumentsCopies() {
        newVehiclePage.uploadVehicleDocumentsCopies("documents/STS_1.jpg", "documents/STS_2.jpg");
    }

    @Step("Находит ТС в общем списке")
    public void shouldSeeVehicleInCommonList() {
        shouldMatch(vehiclesPage.getSearchVehicles(), the("РЕГИСТРАЦИОННЫЙ ЗНАК:", startsWith("A " + getCurrentSession().get("vehicleGRNZ") + " AA")));
    }

    @Step("Нажимает на ТС для просмотра деталей")
    public void clicksToVehicleForDetail() {
        BeanMatcher matchers = the("РЕГИСТРАЦИОННЫЙ ЗНАК:", startsWith("A " + getCurrentSession().get("vehicleGRNZ") + " AA"));
        vehiclesPage.clickOnVehicle(matchers);
    }

    @Step("Находит в ТС все детали")
    public void shouldSeeCorrectVehicleDetail() {
        assertThat(vehicleDetailPage.getVehicleGRNZ())
                .overridingErrorMessage("Регистрационный знак ТС не верный")
                .containsIgnoringCase("A " + getCurrentSession().get("vehicleGRNZ") + " AA");
        assertThat(vehicleDetailPage.getVehicleCountry())
                .overridingErrorMessage("Страна, выдавшая гос. номер ТС, не верная")
                .isEqualTo((String) getCurrentSession().get("vehicleCountry"));
        assertThat(vehicleDetailPage.getVehicleBasisType())
                .overridingErrorMessage("Основание владения ТС не верное")
                .isEqualTo((String) getCurrentSession().get("vehicleBasisType"));
    }

    @Step("Вводит данные новой группы ТС")
    public void entersNewVehiclesGroupData() {
        getCurrentSession().put("groupName", getRandomCyrillicProperString(10));
        getCurrentSession().put("groupLimit", getRandomNumber(3));
        getCurrentSession().put("groupManager", "Заяц Волк");
        newVehiclesGroupPage.enterVehiclesGroupName((String) getCurrentSession().get("groupName"));
        newVehiclesGroupPage.enterVehiclesGroupLimit((String) getCurrentSession().get("groupLimit"));
        newVehiclesGroupPage.selectVehiclesGroupManager("asdkjq76232@flklkfd77.ru");
    }

    @Step("Выбирает из списка {0} машин(ы) для новой группы")
    public void selectsVehiclesForGroup(int amountVehicles) {
        getCurrentSession().put("amountVehicles", valueOf(amountVehicles));
        List<WebElement> targetVehicles = newVehiclesGroupPage.getAllVehicles();
        for (int vehicle = 0; vehicle < amountVehicles; vehicle++) {
            WebElement targetVehicle = targetVehicles.get(vehicle);
            WebElement addToGroupCheckBox = targetVehicle.findElement(By.xpath(".//i[@class='b-checkbox__field']"));
            addToGroupCheckBox.click();
        }
    }

    @Step("Находит группу ТС в общем списке")
    public void shouldSeeVehiclesGroupInCommonList() {
        shouldMatch(vehiclesGroupsPage.getSearchVehiclesGroups(),
                the("НАЗВАНИЕ:", is((String) getCurrentSession().get("groupName"))),
                the("МЕНЕДЖЕР ГРУППЫ:", is((String) getCurrentSession().get("groupManager"))),
                the("КОЛ-ВО ТС:", is((String) getCurrentSession().get("amountVehicles"))),
                the("ЛИМИТ В МЕСЯЦ:", startsWith((String) getCurrentSession().get("groupLimit"))));
    }

    @Step("Нажимает на группу ТС для просмотра деталей")
    public void clicksToVehiclesGroupForDetail() {
        BeanMatcher matchers = the("НАЗВАНИЕ:", is((String) getCurrentSession().get("groupName")));
        vehiclesGroupsPage.clickOnVehiclesGroup(matchers);
    }

    @Step("Находит в группе ТС все детали")
    public void shouldSeeCorrectVehiclesGroupDetail() {
        assertThat(vehiclesGroupDetailPage.getVehiclesGroupName())
                .overridingErrorMessage("Название группы ТС не верное")
                .isEqualToIgnoringCase((String) getCurrentSession().get("groupName"));
        assertThat(vehiclesGroupDetailPage.getVehiclesGroupLimit())
                .overridingErrorMessage("Лимит расходов в месяц для группы ТС не верный")
                .startsWith((String) getCurrentSession().get("groupLimit"));
        assertThat(vehiclesGroupDetailPage.getVehiclesGroupManager())
                .overridingErrorMessage("Менеджер группы ТС не верный")
                .startsWith((String) getCurrentSession().get("groupManager"));
    }

//    @Step("Вводит изменения в регистрационные данные")

//    @Step("Вводит изменения в регистрационные данные")


    @Step("Вводит логин {0} и пароль {1}")
    public void entersLoginAndPassword(String login, String password) {
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
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
        ulRegistrationPage.shouldBeDisplayed();
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
        String currentAccountBalance = mainHeader.getsCurrentAccountBalance();
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

    @Step("Находит обращение в общем списке")
    public void shouldSeeAppealInCommonList() {
        shouldMatch(appealsPage.getSearchAppeals(), the("ТЕМА:", is((String) getCurrentSession().get("appealTitle"))));
    }

    @Step("Находит обращения за последние 3 месяца")
    public void shouldSeeAppealForLastThreeMonth() {
        DateTime today = now();
        DateTime startDay = today.minusMonths(3);
        for (Map<Object, String> row : appealsPage.getSearchAppeals()) {
            String date = row.get("ПОДАНО:");
//            assertThat(parse(date, forPattern("yyyy-MM-dd HH:mm")))
            assertThat(parse(date, forPattern("dd.MM.yyyy HH:mm")))

                    .isAfterOrEqualTo(startDay)
                    .isBefore(today);
        }
    }

    @Step("Нажимает на обращение для просмотра деталей")
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

    @Step("Вводит период обращений с {0} по {1}")
    public void entersPeriodAppealsDates(String startDate, String endDate) {
        appealsPage.enterStartAppealsDate(startDate);
        appealsPage.enterEndAppealsDate(endDate);
    }

    @Step("Нажимает на кнопку Уведомления")
    public void clicksToNotificationsButton() {
        mainHeader.clickToNotificationsButton();
    }

    public void fillsFLData(String registrationEmail) {
        getCurrentSession().put("registrationEmail", registrationEmail.replace("@gmail.com", "+" + getRandomNumber(6) + "@gmail.com"));
        getCurrentSession().put("registrationPhone", getRandomNumber(11));
        getCurrentSession().put("registrationSurname", getRandomCyrillicProperString(7));
        getCurrentSession().put("registrationName", getRandomCyrillicProperString(5));
        getCurrentSession().put("registrationPatronymic", getRandomCyrillicProperString(10));
        getCurrentSession().put("registrationDocumentType", "Паспорт");
        getCurrentSession().put("registrationDocumentNumber", getRandomNumber(10));
        getCurrentSession().put("registrationDocumentDate", getRandomDate());
        getCurrentSession().put("registrationDocumentBy", getRandomCyrillicProperString(12));

        clientRegistrationPage.enterRegistrationLogin((String) getCurrentSession().get("registrationEmail"));
        clientRegistrationPage.enterRegistrationPhone((String) getCurrentSession().get("registrationPhone"));
        clientRegistrationPage.enterRegistrationSurname((String) getCurrentSession().get("registrationSurname"));
        clientRegistrationPage.enterRegistrationName((String) getCurrentSession().get("registrationName"));
        clientRegistrationPage.enterRegistrationPatronymic((String) getCurrentSession().get("registrationPatronymic"));
        clientRegistrationPage.selectRegistrationDocumentType((String) getCurrentSession().get("registrationDocumentType"));
        clientRegistrationPage.enterRegistrationDocumentNumber((String) getCurrentSession().get("registrationDocumentNumber"));
        clientRegistrationPage.enterRegistrationDocumentIssuedDate((String) getCurrentSession().get("registrationDocumentDate"));
        clientRegistrationPage.enterRegistrationDocumentIssuedBy((String) getCurrentSession().get("registrationDocumentBy"));
    }

    private void selectsAgreeCheckboxes() {
        clientRegistrationPage.clickToAgreePersonDataCheckBox();
        clientRegistrationPage.clickToAgreeServiceCheckBox();
    }

    private void fillsIPData(String clientEmail) {
        getCurrentSession().put("registrationEmail", clientEmail.replace("@gmail.com", "+" + getRandomNumber(6) + "@gmail.com"));
        getCurrentSession().put("registrationPhone", getRandomNumber(11));
        getCurrentSession().put("registrationPosition", "Тестовый аккаунт");
        getCurrentSession().put("clientSurname", getRandomCyrillicProperString(8));
        getCurrentSession().put("clientName", getRandomCyrillicProperString(6));
        getCurrentSession().put("clientPatronymic", getRandomCyrillicProperString(10));
        getCurrentSession().put("clientShortName", getRandomCyrillicProperString(5));
        getCurrentSession().put("clientINN", getRandomNumber(12));
        getCurrentSession().put("clientOGRN", getRandomNumber(15));
        getCurrentSession().put("clientEmail", clientEmail.replace("@gmail.com", "+" + getRandomNumber(6) + "@gmail.com"));
        getCurrentSession().put("clientPhone", getRandomNumber(11));

        ipRegistrationPage.loading();
        ipRegistrationPage.enterRegistrationLogin((String) getCurrentSession().get("registrationEmail"));
        ipRegistrationPage.enterRegistrationPhone((String) getCurrentSession().get("registrationPhone"));
        ipRegistrationPage.enterRegistrationPosition((String) getCurrentSession().get("registrationPosition"));
        ipRegistrationPage.enterClientSurname((String) getCurrentSession().get("clientSurname"));
        ipRegistrationPage.enterClientName((String) getCurrentSession().get("clientName"));
        ipRegistrationPage.enterClientPatronymic((String) getCurrentSession().get("clientPatronymic"));
        ipRegistrationPage.enterClientShortName((String) getCurrentSession().get("clientShortName"));
        ipRegistrationPage.enterClientINN((String) getCurrentSession().get("clientINN"));
        ipRegistrationPage.enterClientOGRN((String) getCurrentSession().get("clientOGRN"));
        ipRegistrationPage.enterClientMainEmail((String) getCurrentSession().get("clientEmail"));
        ipRegistrationPage.enterClientMainPhone((String) getCurrentSession().get("clientPhone"));
    }

    private void fillsClientPersonalDocument() {
        getCurrentSession().put("clientPersonalDocumentType", "Паспорт");
        getCurrentSession().put("clientPersonalDocumentNumber", getRandomNumber(10));
        getCurrentSession().put("clientPersonalDocumentDate", getRandomDate());
        getCurrentSession().put("clientPersonalDocumentBy", getRandomCyrillicProperString(12));

        ipRegistrationPage.selectClientPersonalDocumentType((String) getCurrentSession().get("clientPersonalDocumentType"));
        ipRegistrationPage.enterClientPersonalDocumentNumber((String) getCurrentSession().get("clientPersonalDocumentNumber"));
        ipRegistrationPage.enterClientPersonalDocumentIssuedDate((String) getCurrentSession().get("clientPersonalDocumentDate"));
        ipRegistrationPage.enterClientPersonalDocumentIssuedBy((String) getCurrentSession().get("clientPersonalDocumentBy"));
    }

    private void fillsOrganizationData(String organizationEmail) {
        getCurrentSession().put("registrationEmail", organizationEmail.replace("@gmail.com", "+" + getRandomNumber(6) + "@gmail.com"));
        getCurrentSession().put("registrationPhone", getRandomNumber(11));
        getCurrentSession().put("registrationPosition", "Тестовый аккаунт");
        getCurrentSession().put("clientSurname", getRandomCyrillicProperString(8));
        getCurrentSession().put("clientName", getRandomCyrillicProperString(6));
        getCurrentSession().put("clientPatronymic", getRandomCyrillicProperString(10));
        getCurrentSession().put("organizationOPF", "Общества с ограниченной ответственностью");
        getCurrentSession().put("organizationName", getRandomCyrillicProperString(10));
        getCurrentSession().put("organizationShortName", getRandomCyrillicProperString(5));
        getCurrentSession().put("organizationOGRN", getRandomNumber(15));
        getCurrentSession().put("organizationINN", getRandomNumber(12));
        getCurrentSession().put("organizationEmail", organizationEmail.replace("@gmail.com", "+" + getRandomNumber(6) + "@gmail.com"));
        getCurrentSession().put("organizationPhone", getRandomNumber(11));

        ulRegistrationPage.loading();
        ulRegistrationPage.enterRegistrationLogin((String) getCurrentSession().get("registrationEmail"));
        ulRegistrationPage.enterRegistrationPhone((String) getCurrentSession().get("registrationPhone"));
        ulRegistrationPage.enterRegistrationPosition((String) getCurrentSession().get("registrationPosition"));
        ulRegistrationPage.enterClientSurname((String) getCurrentSession().get("clientSurname"));
        ulRegistrationPage.enterClientName((String) getCurrentSession().get("clientName"));
        ulRegistrationPage.enterClientPatronymic((String) getCurrentSession().get("clientPatronymic"));
        ulRegistrationPage.selectOrganizationOPF((String) getCurrentSession().get("organizationOPF"));
        ulRegistrationPage.enterClientName((String) getCurrentSession().get("organizationName"));
        ulRegistrationPage.enterClientShortName((String) getCurrentSession().get("organizationShortName"));
        ulRegistrationPage.enterClientOGRN((String) getCurrentSession().get("organizationOGRN"));
        ulRegistrationPage.enterClientINN((String) getCurrentSession().get("organizationINN"));
        ulRegistrationPage.enterClientMainEmail((String) getCurrentSession().get("organizationEmail"));
        ulRegistrationPage.enterClientMainPhone((String) getCurrentSession().get("organizationPhone"));
    }

    private void fillsDirectorData(String directorEmail) {
        getCurrentSession().put("directorSurname", getRandomCyrillicProperString(7));
        getCurrentSession().put("directorName", getRandomCyrillicProperString(5));
        getCurrentSession().put("directorPatronymic", getRandomCyrillicProperString(10));
        getCurrentSession().put("directorPhone", getRandomNumber(11));
        getCurrentSession().put("directorEmail", directorEmail.replace("@gmail.com", "+" + getRandomNumber(6) + "@gmail.com"));
        getCurrentSession().put("directorPosition", "Генеральный директор");

        ulRegistrationPage.enterDirectorSurname((String) getCurrentSession().get("directorSurname"));
        ulRegistrationPage.enterDirectorName((String) getCurrentSession().get("directorName"));
        ulRegistrationPage.enterDirectorPatronymic((String) getCurrentSession().get("directorPatronymic"));
        ulRegistrationPage.enterDirectorPhone((String) getCurrentSession().get("directorPhone"));
        ulRegistrationPage.enterDirectorLogin((String) getCurrentSession().get("directorEmail"));
        ulRegistrationPage.enterDirectorPosition((String) getCurrentSession().get("directorPosition"));
    }

    private void fillsDirectorDocuments() {
        getCurrentSession().put("directorDocumentType", "Устав");
//        getCurrentSession().put("directorDocumentNumber", getRandomNumber(10));
//        getCurrentSession().put("directorDocumentDate", getRandomDate());
//        getCurrentSession().put("directorDocumentValidity", "31.12.2015");

        ulRegistrationPage.selectDirectorDocumentType((String) getCurrentSession().get("directorDocumentType"));
//        ulRegistrationPage.enterDirectorDocumentNumber((String) getCurrentSession().get("directorDocumentNumber"));
//        ulRegistrationPage.enterDirectorDocumentIssuedDate((String) getCurrentSession().get("directorDocumentDate"));
//        ulRegistrationPage.enterDirectorDocumentValidity((String) getCurrentSession().get("directorDocumentValidity"));
    }

    private void fillsDirectorPersonalDocument() {
        getCurrentSession().put("directorPersonalDocumentType", "Паспорт");
        getCurrentSession().put("directorPersonalDocumentNumber", getRandomNumber(10));
        getCurrentSession().put("directorPersonalDocumentDate", getRandomDate());
        getCurrentSession().put("directorPersonalDocumentBy", getRandomCyrillicProperString(12));

        ulRegistrationPage.selectDirectorPersonalDocumentType((String) getCurrentSession().get("directorPersonalDocumentType"));
        ulRegistrationPage.enterDirectorPersonalDocumentNumber((String) getCurrentSession().get("directorPersonalDocumentNumber"));
        ulRegistrationPage.enterDirectorPersonalDocumentIssuedDate((String) getCurrentSession().get("directorPersonalDocumentDate"));
        ulRegistrationPage.enterDirectorPersonalDocumentIssuedBy((String) getCurrentSession().get("directorPersonalDocumentBy"));
    }

    private void fillsClientRegistrationAddress(String registrationAddressKladr) {
        getCurrentSession().put("registrationAddressKladr", registrationAddressKladr);
        getCurrentSession().put("registrationAddressIndex", getRandomNumber(6));
        getCurrentSession().put("registrationAddressHouse", getRandomNumber(3));
        getCurrentSession().put("registrationAddressHousing", getRandomNumber(1));
        getCurrentSession().put("registrationAddressBuilding", getRandomNumber(1));
        getCurrentSession().put("registrationAddressRoom", getRandomNumber(2));

        ulRegistrationPage.selectClientRegistrationAddressKladr((String) getCurrentSession().get("registrationAddressKladr"));
        ulRegistrationPage.enterClientRegistrationAddressIndex((String) getCurrentSession().get("registrationAddressIndex"));
        ulRegistrationPage.enterClientRegistrationAddressHouse((String) getCurrentSession().get("registrationAddressHouse"));
        ulRegistrationPage.enterClientRegistrationAddressHousing((String) getCurrentSession().get("registrationAddressHousing"));
        ulRegistrationPage.enterClientRegistrationAddressBuilding((String) getCurrentSession().get("registrationAddressBuilding"));
        ulRegistrationPage.enterClientRegistrationAddressRoom((String) getCurrentSession().get("registrationAddressRoom"));
    }

    private void fillsClientLocationAddress(String locationAddressKladr) {
        getCurrentSession().put("locationAddressKladr", locationAddressKladr);
        getCurrentSession().put("locationAddressIndex", getRandomNumber(6));
        getCurrentSession().put("locationAddressHouse", getRandomNumber(3));
        getCurrentSession().put("locationAddressHousing", getRandomNumber(1));
        getCurrentSession().put("locationAddressBuilding", getRandomNumber(1));
        getCurrentSession().put("locationAddressRoom", getRandomNumber(2));

        ulRegistrationPage.selectClientLocationAddressKladr((String) getCurrentSession().get("locationAddressKladr"));
        ulRegistrationPage.enterClientLocationAddressIndex((String) getCurrentSession().get("locationAddressIndex"));
        ulRegistrationPage.enterClientLocationAddressHouse((String) getCurrentSession().get("locationAddressHouse"));
        ulRegistrationPage.enterClientLocationAddressHousing((String) getCurrentSession().get("locationAddressHousing"));
        ulRegistrationPage.enterClientLocationAddressBuilding((String) getCurrentSession().get("locationAddressBuilding"));
        ulRegistrationPage.enterClientLocationAddressRoom((String) getCurrentSession().get("locationAddressRoom"));
    }

    private void fillsClientPostalAddress(String postalAddressKladr) {
        getCurrentSession().put("postalAddressKladr", postalAddressKladr);
        getCurrentSession().put("postalAddressIndex", getRandomNumber(6));
        getCurrentSession().put("postalAddressHouse", getRandomNumber(3));
        getCurrentSession().put("postalAddressHousing", getRandomNumber(1));
        getCurrentSession().put("postalAddressBuilding", getRandomNumber(1));
        getCurrentSession().put("postalAddressRoom", getRandomNumber(2));

        ulRegistrationPage.selectClientPostalAddressKladr((String) getCurrentSession().get("postalAddressKladr"));
        ulRegistrationPage.enterClientPostalAddressIndex((String) getCurrentSession().get("postalAddressIndex"));
        ulRegistrationPage.enterClientPostalAddressHouse((String) getCurrentSession().get("postalAddressHouse"));
        ulRegistrationPage.enterClientPostalAddressHousing((String) getCurrentSession().get("postalAddressHousing"));
        ulRegistrationPage.enterClientPostalAddressBuilding((String) getCurrentSession().get("postalAddressBuilding"));
        ulRegistrationPage.enterClientPostalAddressRoom((String) getCurrentSession().get("postalAddressRoom"));
    }

    private void fillsClientBankData() {
        getCurrentSession().put("clientBankName", getRandomCyrillicProperString(6));
        getCurrentSession().put("clientBankBIK", getRandomNumber(9));
        getCurrentSession().put("clientBankINN", getRandomNumber(10));
        getCurrentSession().put("clientBankKorNumber", getRandomNumber(20));
        getCurrentSession().put("clientAccountNumber", getRandomNumber(20));
        getCurrentSession().put("clientBankReceiverName", getRandomCyrillicProperString(18));

        ulRegistrationPage.enterClientBankName((String) getCurrentSession().get("clientBankName"));
        ulRegistrationPage.enterClientBankBIK((String) getCurrentSession().get("clientBankBIK"));
        ulRegistrationPage.enterClientBankINN((String) getCurrentSession().get("clientBankINN"));
        ulRegistrationPage.enterClientBankKorNumber((String) getCurrentSession().get("clientBankKorNumber"));
        ulRegistrationPage.enterClientBankAccountNumber((String) getCurrentSession().get("clientAccountNumber"));
        ulRegistrationPage.enterClientBankReceiverName((String) getCurrentSession().get("clientBankReceiverName"));
    }
}