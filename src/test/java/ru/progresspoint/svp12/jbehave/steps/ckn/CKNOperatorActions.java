package ru.progresspoint.svp12.jbehave.steps.ckn;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.ckn.steps.CKNOperatorSteps;
import ru.progresspoint.svp12.rso.steps.RSOOperatorSteps;

/**
 * Шаги оператора АРМа ЦКН
 */
public class CKNOperatorActions {

    @Steps
    CKNOperatorSteps operator;

    @When("оператор введет логин $login и пароль $password для авторизации в АРМ ЦКН")
    public void operatorEntersLoginAndPassword(String login, String password) {
        operator.entersLoginAndPassword(login, password);
        operator.clicksToConfirmButton();
    }
}