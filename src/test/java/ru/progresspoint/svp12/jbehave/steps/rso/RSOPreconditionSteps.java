package ru.progresspoint.svp12.jbehave.steps.rso;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Шаги для приведения АРМа РСО в исходные состояния
 */
public class RSOPreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Given("оператор находится на странице $page в АРМ РСО")
    public void operatorIsOn(String page) {
            navigation.opensRSOPage(page);
    }
}
