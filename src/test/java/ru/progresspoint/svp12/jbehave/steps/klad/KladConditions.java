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

    @Then("система предоставит доступ к АРМ Кладовщика для роли $role")
    public void kladShouldBeAvailableForUser(String role) {
        switch (role) {
            case "Кладовщик ЦО":
                navigation.isOnKladPage("Главная ЦО");
                break;
            case "Кладовщик ЦИПП":
                navigation.isOnKladPage("Главная ЦИПП");
                break;
            case "Кладовщик филиала":
                navigation.isOnKladPage("Главная филиала");
                break;
        }
    }
}
