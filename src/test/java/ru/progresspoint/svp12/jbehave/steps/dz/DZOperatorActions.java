package ru.progresspoint.svp12.jbehave.steps.dz;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.dz.steps.DZOperatorSteps;

/**
 * Шаги оператора АРМа ДЗ
 */
public class DZOperatorActions {

    @Steps
    DZOperatorSteps operator;

    @When("оператор вводит логин $login и пароль $password для авторизации в АРМ ДЗЗ")
    public void operatorEntersLoginAndPassword(String login, String password) {
        operator.entersLoginAndPassword(login, password);
        operator.clicksToConfirmButton();
    }
}