package ru.progresspoint.svp12.jbehave.steps.rso;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Состояния АРМа РСО, к которым он приходит в результате действий пользователя
 */
public class RSOConditions {

    @Steps
    NavigationSteps navigation;

    @Then("система предоставит доступ к АРМ РСО")
    public void rsoShouldBeAvailableForUser() {
        navigation.isOnRSOPage("Главная");
    }

    @Then("система откроет страницу $page в АРМ РСО")
    public void pageShouldBeDisplayed(String page) {
        navigation.isOnRSOPage(page);
    }
}
