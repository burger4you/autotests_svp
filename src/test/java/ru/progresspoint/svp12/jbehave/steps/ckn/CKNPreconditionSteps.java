package ru.progresspoint.svp12.jbehave.steps.ckn;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Шаги для приведения АРМа ЦКН в исходные состояния
 */
public class CKNPreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Given("оператор находится на странице $page в АРМ ЦКН")
    public void operatorIsOn(String page) {
        navigation.opensCKNPage(page);
    }
}
