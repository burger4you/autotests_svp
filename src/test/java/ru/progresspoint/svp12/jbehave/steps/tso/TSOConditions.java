package ru.progresspoint.svp12.jbehave.steps.tso;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Состояния АРМа ТСО, к которым он приходит в результате действий пользователя
 */
public class TSOConditions {

    @Steps
    NavigationSteps navigation;

    @Then("система предоставляет доступ к личному кабинету АРМа ТСО")
    public void tsoShouldBeAvailableForUser() {
        navigation.isOnTSOPage("Личного Кабинета");
    }
}
