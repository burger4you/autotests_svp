package ru.progresspoint.svp12.jbehave.steps.klad;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Состояния АРМа Кладовщика, к которым он приходит в результате действий пользователя
 */
public class KladConditions {

    @Steps
    NavigationSteps navigation;

    @Then("система предоставляет доступ к АРМ Кладовщика")
    public void kladShouldBeAvailableForUser() {
        navigation.isOnKladPage("Главная");
    }
}
