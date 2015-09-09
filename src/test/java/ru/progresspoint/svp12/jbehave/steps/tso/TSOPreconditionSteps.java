package ru.progresspoint.svp12.jbehave.steps.tso;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.dz.steps.DZOperatorSteps;

/**
 * Шаги для приведения АРМа ТСО в исходные состояния
 */
public class TSOPreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Given("пользователь находится на странице начала использования АРМа ТСО")
    public void userIsOnStartPage(String page) {
        navigation.opensTSOStartPage();
    }
}
