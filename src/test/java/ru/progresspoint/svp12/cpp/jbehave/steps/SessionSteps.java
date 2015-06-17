package ru.progresspoint.svp12.cpp.jbehave.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.cpp.steps.OperatorSteps;

/**
 * Шаги оператора при работе с сессией (авторизация, смена пароля)
 */
public class SessionSteps {

    @Steps
    OperatorSteps operator;

    @When("он вводит логин $login и пароль $password для авторизации")
    public void operatorEntersLoginAndPassword(String login, String password) {
        operator.entersLoginAndPassword(login, password);
        operator.clickLoginButton();
    }


}