package ru.progresspoint.svp12.jbehave.steps.smk;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.smk.steps.SMKDispatcherSteps;

/**
 * Шаги диспетчера АРМа СМК
 */
public class SMKDispatcherActions {

    @Steps
    SMKDispatcherSteps dispatcher;

    @When("диспетчер введет логин $login и пароль $password для авторизации в АРМ СМК")
    public void dispatcherEntersLoginAndPassword(String login, String password) {
        dispatcher.entersLoginAndPassword(login, password);
        dispatcher.clicksToConfirmButton();
    }
}