package ru.progresspoint.svp12.jbehave.steps.smk;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Состояния АРМа СМК, к которым он приходит в результате действий пользователя
 */
public class SMKConditions {

    @Steps
    NavigationSteps navigation;

    @Then("система предоставит доступ к АРМ СМК")
    public void smkShouldBeAvailableForUser() {
        navigation.isOnSMKPage("Главная");
    }
}
