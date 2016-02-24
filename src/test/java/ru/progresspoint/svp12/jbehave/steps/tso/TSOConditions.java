package ru.progresspoint.svp12.jbehave.steps.tso;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Состояния АРМа ТСО, к которым он приходит в результате действий пользователя
 */
public class TSOConditions {

    @Steps
    NavigationSteps navigation;

    @Then("система предоставит доступ к личному кабинету АРМа ТСО")
    public void tsoShouldBeAvailableForUser() {
        navigation.isOnTSOPage("личного кабинета");
    }

    @Then("терминал самообслуживания отобразит экран со справочной информацией о системе")
    public void infoShouldBeAvailableForUser() {
        navigation.isOnTSOPage("информации о системе");
    }
}
