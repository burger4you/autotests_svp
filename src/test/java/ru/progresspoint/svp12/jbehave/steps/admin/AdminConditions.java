package ru.progresspoint.svp12.jbehave.steps.admin;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Состояния АРМа Администратора, к которым он приходит в результате действий администратора
 */
public class AdminConditions {

    @Steps
    NavigationSteps navigation;

    @Then("система предоставит доступ к АРМ Администратора")
    public void adminShouldBeAvailableForAdministrator() {
        navigation.isOnAdminPage("Главная");
    }
}
