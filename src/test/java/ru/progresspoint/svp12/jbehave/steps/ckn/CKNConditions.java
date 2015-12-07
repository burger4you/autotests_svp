package ru.progresspoint.svp12.jbehave.steps.ckn;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Состояния АРМа ЦКН, к которым он приходит в результате действий пользователя
 */
public class CKNConditions {

    @Steps
    NavigationSteps navigation;

    @Then("система предоставит доступ к АРМ ЦКН для роли $role")
    public void cknShouldBeAvailableForUser(String role) {
        switch (role) {
            case "Оператор":
                navigation.isOnCKNPage("Главная");
                break;
        }
    }
}
