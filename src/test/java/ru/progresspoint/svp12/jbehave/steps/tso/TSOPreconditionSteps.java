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

    @Given("владелец ТС находится на стартовой странице терминала самообслуживания")
    public void userIsOnStartPage() {
        navigation.opensTSOStartPage();
    }
}
