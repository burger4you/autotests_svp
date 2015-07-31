package ru.progresspoint.svp12.lk.steps;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.matchers.BeanMatcher;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebElement;
import ru.progresspoint.svp12.lk.pages.*;

import java.util.List;
import java.util.Map;

import static net.thucydides.core.matchers.BeanMatcherAsserts.shouldMatch;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.name;

/**
 * Шаги конечного пользователя АРМа Личный Кабинет
 */
public class LKUserSteps extends ScenarioSteps {

    LKLoginPage loginPage;
    LKMainPage mainPage;
    LKNewVehiclesGroupPage newVehiclesGroupPage;
    LKPaymentsPage paymentsPage;
    UnitellerPaymentsPage unitellerPage;
    LKAppealsPage appealsPage;
    LKNewAppealPage newAppealPage;
    LKAccountPage accountPage;
    LKBasicInfoPage basicInfoPage;
    LKPasswordPage passwordPage;
    LKNewVehiclePage newVehiclePage;
    LKMainHeader mainHeader;


    @Step("Нажимает на ссылку {0}")
    public void clicksToLink(String linkText) {
        getDriver().findElement(linkText(linkText));
    }

    @Step("Вводит данные учетной записи")
    public void entersAccountData(String accountData) {
        accountPage.enterAccountData(accountData);
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
    public void entersOwnerData(String ownerData) {
        basicInfoPage.enterOwnerData(ownerData);
    }

    @Step("Прикладывает скан-копии документов ВТС")
    public void uploadsOwnerDocumentsCopies(String filename) {
        basicInfoPage.uploadOwnerDocumentsCopies(filename);
    }

    @Step("Вводит данные ТС")
    public void entersVehicleData(String vehicleData) {
        basicInfoPage.enterVehicleData(vehicleData);
    }

    @Step("Прикладывает скан-копии документов ТС")
    public void uploadsVehicleDocumentsCopies(String filename) {
        basicInfoPage.uploadVehicleDocumentsCopies(filename);
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
}