package ru.progresspoint.svp12.jbehave.steps.klad;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.klad.steps.KladStorekeeperSteps;

/**
 * Шаги оператора АРМа Кладовщика
 */
public class KladOperatorActions {

    @Steps
    KladStorekeeperSteps storekeeper;

    @When("кладовщик вводит логин $login и пароль $password для авторизации в АРМ Кладовщика")
    public void operatorEntersLoginAndPassword(String login, String password) {
        storekeeper.entersLoginAndPassword(login, password);
        storekeeper.clicksToConfirmButton();
    }
}