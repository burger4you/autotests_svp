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


    @When("пользователь вводит логин $login и пароль $password для авторизации")
    public void userEntersLoginAndPassword(String login, String password) {
        user.entersLoginAndPassword(login, password);
        user.clickLoginButton();
    }

    @When("пользователь отметит в списке $amountVehicles своих ТС и назовет это объединение $groupName")
    public void userChooseVehiclesForGroup(int amountVehicles, String groupName) {
        user.clickToGroupsVehiclesLink();
        user.clickToNewGroupVehiclesLink();
        user.enterNameForNewGroupVehicles(groupName);
        user.chooseVehiclesForGroup(amountVehicles);
        user.clickToConfirmButton();
    }
}