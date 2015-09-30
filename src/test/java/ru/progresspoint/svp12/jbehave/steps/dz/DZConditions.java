package ru.progresspoint.svp12.jbehave.steps.dz;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Состояния АРМа ДЗ, к которым он приходит в результате действий пользователя
 */
public class DZConditions {

    @Steps
    NavigationSteps navigation;

    @Then("система предоставит доступ к АРМ ДЗ")
    public void dzShouldBeAvailableForUser() {
        navigation.isOnDZPage("Главная");
    }
}
