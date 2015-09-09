package ru.progresspoint.svp12.jbehave.steps.treasury;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Состояния АРМа Казначейства, к которым он приходит в результате действий пользователя
 */
public class TreasuryConditions {

    @Steps
    NavigationSteps navigation;

    @Then("система предоставляет доступ к АРМ Казначейства")
    public void treasuryShouldBeAvailableForUser() {
        navigation.isOnTreasuryPage("Главная");
    }
}
