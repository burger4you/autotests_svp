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

    @When("пользователь отметит в списке $amountVehicles своих ТС и назовет это объединение $groupName")
    public void userChooseVehiclesForGroup(int amountVehicles, String groupName) {
        user.clicksToVehiclesItemMenu();
        user.clicksToGroupsVehiclesLink();
        user.clicksToNewGroupVehiclesLink();
        user.entersNameForNewGroupVehicles(groupName);
        user.chooseVehiclesForGroup(amountVehicles);
        user.clicksToConfirmChooseButton();
    }

    @When("он пополнит счет на $fundsAmount рублей")
    public void userAddsFundsInAccount(String fundsAmount) {
        user.clicksToAddsFundsLink();
        user.entersFundsAmount(fundsAmount);
        user.confirmsPayment();
        user.entersCardDataAndPay("123");
    }
}