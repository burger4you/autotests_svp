package ru.progresspoint.svp12.cpp.jbehave.steps.lk;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.lk.steps.LKUserSteps;

/**
 * Действия пользователя в Личном кабинете
 */
public class LKUserActions {

    @Steps
    LKUserSteps user;


    @When("пользователь вводит логин $login и пароль $password для авторизации в ЛК")
    public void userEntersLoginAndPassword(String login, String password) {
        user.entersLoginAndPassword(login, password);
        user.clicksToLoginButton();
    }

    @When("пользователь объеденит $amountVehicles своих ТС в группу $groupName")
    public void userChooseVehiclesForGroup(int amountVehicles, String groupName) {
        user.clicksToGroupsVehiclesLink();
        user.clicksToNewGroupVehiclesLink();
        user.entersNameForNewGroupVehicles(groupName);
        user.chooseVehiclesForGroup(amountVehicles);
        user.clicksToConfirmChooseButton();
    }

    @When("он укажет период операций с $startDate по $endDate")
    public void userSetsTransactionsPeriod(String startDate, String endDate) {
        user.entersPeriodTransactionsDates(startDate, endDate);
    }

    @When("он пополнит счет на $fundsAmount рублей")
    public void userAddsFundsInAccount(String fundsAmount) {
        user.clicksToAddsFundsLink();
        user.entersFundsAmount(fundsAmount);
        user.confirmsPayment();
        user.entersCardDataAndPay("123");
    }
}