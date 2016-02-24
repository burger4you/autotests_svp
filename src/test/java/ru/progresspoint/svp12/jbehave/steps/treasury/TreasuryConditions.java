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

    @Then("система предоставит доступ к АРМ Казначейства для роли $role")
    public void treasuryShouldBeAvailableForUser(String role) {
        switch (role) {
            case "Оператор":
                navigation.isOnTreasuryPage("Главная оператора");
                break;
            case "Первая подпись":
                navigation.isOnTreasuryPage("Главная c правом первой подписи");
                break;
            case "Вторая подпись":
                navigation.isOnTreasuryPage("Главная c правом второй подписи");
                break;
        }
    }
}