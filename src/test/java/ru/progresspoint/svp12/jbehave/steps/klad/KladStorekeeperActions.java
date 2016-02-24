package ru.progresspoint.svp12.jbehave.steps.klad;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.klad.steps.KladStorekeeperSteps;

/**
 * Шаги кладовщика в АРМе Кладовщика
 */
public class KladStorekeeperActions {

    @Steps
    KladStorekeeperSteps storekeeper;

    @When("кладовщик введет логин $login и пароль $password для авторизации в АРМ Кладовщика")
    public void storekeeperEntersLoginAndPassword(String login, String password) {
        storekeeper.entersLoginAndPassword(login, password);
        storekeeper.clicksToConfirmButton();
    }
}