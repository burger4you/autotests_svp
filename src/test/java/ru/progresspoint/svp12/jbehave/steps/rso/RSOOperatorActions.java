package ru.progresspoint.svp12.jbehave.steps.rso;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.dz.steps.DZOperatorSteps;
import ru.progresspoint.svp12.rso.steps.RSOOperatorSteps;

/**
 * Шаги оператора АРМа РСО
 */
public class RSOOperatorActions {

    @Steps
    RSOOperatorSteps operator;

    @When("оператор вводит логин $login и пароль $password для авторизации в АРМ РСО")
    public void operatorEntersLoginAndPassword(String login, String password) {
        operator.entersLoginAndPassword(login, password);
        operator.clicksToConfirmButton();
    }
}