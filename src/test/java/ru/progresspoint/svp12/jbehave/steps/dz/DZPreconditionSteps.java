package ru.progresspoint.svp12.jbehave.steps.dz;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.dz.steps.DZUserSteps;

/**
 * Шаги для приведения АРМа ДЗ в исходные состояния
 */
public class DZPreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Given("аналитик находится на странице $page в АРМ ДЗ")
    public void analystIsOn(String page) {
        navigation.opensDZPage(page);
    }
}
