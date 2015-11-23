package ru.progresspoint.svp12.jbehave.steps.dz;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.dz.steps.DZUserSteps;

/**
 * Шаги аналитика АРМа ДЗ
 */
public class DZAnalystActions {

    @Steps
    DZUserSteps analyst;

    @When("аналитик введет логин $login и пароль $password для авторизации в АРМ ДЗ")
    public void operatorEntersLoginAndPassword(String login, String password) {
        analyst.entersLoginAndPassword(login, password);
        analyst.clicksToConfirmButton();
    }
}