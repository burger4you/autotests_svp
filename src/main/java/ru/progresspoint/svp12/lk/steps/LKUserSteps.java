package ru.progresspoint.svp12.lk.steps;


import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.matchers.BeanMatcher;
import net.thucydides.core.steps.ScenarioSteps;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import ru.progresspoint.svp12.lk.pages.*;

import java.util.List;
import java.util.Map;

import static net.thucydides.core.matchers.BeanMatcherAsserts.shouldMatch;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Шаги конечного пользователя АРМа Личный Кабинет
 */
public class LKUserSteps extends ScenarioSteps {

    LKLoginPage loginPage;
    LKMainPage mainPage;
    LKVehiclesPage vehiclesPage;
    LKVehiclesGroupPage groupVehiclesPage;
    LKNewVehiclesGroupPage newVehiclesGroupPage;
    LKPaymentsPage paymentsPage;
    LKBalanceIncreasePage balanceIncreasePage;
    UnitellerPaymentsPage unitellerPage;


    private DateTimeFormatter getDateTimeFormatter;

    @Step("Вводит логин {0} и пароль {1}")
    public void entersLoginAndPassword(String login, String password) {
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
    }

    @Step("Жмет кнопку Войти")
    public void clicksToLoginButton() {
        loginPage.clickConfirmButton();
    }

    @Step("Выбирает в меню Транспортные средства")
    public void clicksToVehiclesItemMenu() {
        mainPage.clickToVehiclesItemMenu();
    }

    @Step("Жмет ссылку Группы транспортных средств")
    public void clicksToGroupsVehiclesLink() {
        vehiclesPage.clickToVehiclesGroupsLink();
    }

    @Step("Жмет ссылку Добавить новую группы транспортных средств")
    public void clicksToNewGroupVehiclesLink() {
        groupVehiclesPage.clickToNewVehiclesGroupLink();
    }

    @Step("Вводит название новой группы {0}")
    public void entersNameForNewGroupVehicles(String groupName) {
        newVehiclesGroupPage.enterVehiclesGroupName(groupName);
    }

    @Step("Выбирает {0} машин(ы) для новой группы")
    public void chooseVehiclesForGroup(int amountVehicles) {
        for (int vehicle = 0; vehicle < amountVehicles; vehicle++) {
            newVehiclesGroupPage.setForAddToGroupVehicle(vehicle);
        }

    }

    @Step("Кликает кнопку подтверждения")
    public void clicksToConfirmChooseButton() {
        newVehiclesGroupPage.clickConfirmButton();
    }

    @Step("Должен увидеть алерт, что группа {0} создана")
    public void shouldSeeConfirmAlert(String groupName) {
        newVehiclesGroupPage.waitForTextToAppear(String.format("Группа %s успешно создана.", groupName));
    }

    @Step("Жмет ссылку Пополнить счет")
    public void clicksToAddsFundsLink() {
        paymentsPage.clickToAddsFundsLink();
    }

    @Step("Вводит {0} рублей в окне Пополениние счета и жмет Оплатить")
    public void entersFundsAmount(String fundsAmount) {
        paymentsPage.shouldBeDisplayedAddFundsPopUp();
        // Запоминаем баланс лс до пополнения для следующей проверки
        Serenity.getCurrentSession().put("oldAccountBalance", paymentsPage.getCurrentAccountBalance());
        paymentsPage.enterFundsAmount(fundsAmount);
        paymentsPage.clickToPayPopUpLink();
    }

    @Step("Подтверждает платеж")
    public void confirmsPayment() {
        balanceIncreasePage.clickToConfirmButton();
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

    @Step("Возвращается на главную ЛК со страницы оплаты")
    public void comesBackToShop() {
        unitellerPage.clickToComesBackButton();
        mainPage.shouldBeDisplayed();
    }

    @Step("Вводит период тразакций с {0} по {1}")
    public void entersPeriodTransactionsDates(String startDate, String endDate) {
        paymentsPage.enterStartTransactionsDate(startDate);
        paymentsPage.enterEndTransactionsDate(endDate);
    }

    @Step("Указывает тип тразакций {0}")
    public void setsTransactionsType(String transactionsType) {
        paymentsPage.setTypeTransactions(transactionsType);
    }

    @Step("Видит отфильтрованные тразакции")
    public void shouldSeeTransactionsWhere(BeanMatcher... matchers) {
        List<Map<Object, String>> stringRows = paymentsPage.getSearchTransactions();
        System.out.println(stringRows);
        int rowsCount = stringRows.size();
        for (Map<Object, String> stringRow : stringRows) {
            DateTime date = getDateTimeFormatter.parseDateTime(stringRow.get("Дата и время"));
            System.out.println(date);
        }
        shouldMatch(stringRows, matchers);
    }
}