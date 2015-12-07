package ru.progresspoint.svp12.jbehave.steps.call_centre;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.call_centre.steps.CallCentreUserSteps;

/**
 * Шаги пользователей АРМа Колл Центра
 */
public class CallCentreUserActions {

    @Steps
    CallCentreUserSteps user;

    @When("пользователь введет логин $login и пароль $password для авторизации в АРМ Колл Центра")
     public void operatorFirstLineEntersLoginAndPassword(String login, String password) {
        user.entersLoginAndPassword(login, password);
        user.clicksToConfirmButton();
    }
}