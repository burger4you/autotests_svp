package ru.progresspoint.svp12.jbehave.steps.treasury;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.treasury.steps.TreasuryOperatorSteps;

/**
 * Шаги оператора АРМа Казначейства
 */
public class TreasuryOperatorActions {

    @Steps
    TreasuryOperatorSteps operator;

    @When("оператор введет логин $login и пароль $password для авторизации в АРМ Казначейства")
    public void operatorEntersLoginAndPassword(String login, String password) {
        operator.entersLoginAndPassword(login, password);
        operator.clicksToConfirmButton();
    }
}