package ru.progresspoint.svp12.jbehave.steps.call_centre;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Состояния АРМа Колл Центра, к которым он приходит в результате действий пользователей
 */
public class CallCentreConditions {

    @Steps
    NavigationSteps navigation;

    @Then("система предоставит доступ к АРМ Колл Центра")
    public void callCenterShouldBeAvailableForOperator() {
        navigation.isOnCallCentrePage("Главная");
    }
}
