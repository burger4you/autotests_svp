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

    @Then("система предоставит доступ к АРМ ЦКН")
    public void cknShouldBeAvailableForUser() {
        navigation.isOnCKNPage("Главная");
    }
}
