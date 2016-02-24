package ru.progresspoint.svp12.jbehave.steps.admin;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.admin.steps.AdminAdministratorSteps;

/**
 * Шаги администратора в АРМе Администратора
 */
public class AdminOperatorActions {

    @Steps
    AdminAdministratorSteps administrator;

    @When("администратор введет логин $login и пароль $password для авторизации в АРМ Администратора")
    public void administratorEntersLoginAndPassword(String login, String password) {
        administrator.entersLoginAndPassword(login, password);
        administrator.clicksToConfirmButton();
    }
}