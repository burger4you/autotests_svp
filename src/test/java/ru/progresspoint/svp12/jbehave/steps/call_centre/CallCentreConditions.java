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

    @Then("система предоставит доступ к АРМ Колл Центра для роли $role")
    public void callCenterShouldBeAvailableForOperator(String role) {
        switch (role) {
            case "Руководитель" :
                navigation.isOnCallCentrePage("Главная Руководителя");
                break;
        }
        switch (role) {
            case "Оператор" :
                navigation.isOnCallCentrePage("Главная Оператора");
                break;
        }
    }
}
