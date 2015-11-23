package ru.progresspoint.svp12.jbehave.steps.treasury;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Шаги для приведения АРМа Казначейства в исходные состояния
 */
public class TreasuryPreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Given("оператор находится на странице $page в АРМ Казначейства")
    public void operatorIsOn(String page) {
        navigation.opensTreasuryPage(page);
    }
}
