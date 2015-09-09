package ru.progresspoint.svp12.jbehave.steps.rso;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.dz.steps.DZOperatorSteps;
import ru.progresspoint.svp12.rso.steps.RSOOperatorSteps;

/**
 * Шаги для приведения АРМа РСО в исходные состояния
 */
public class RSOPreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Steps
    RSOOperatorSteps operator;

    @Given("оператор находится на странице $page в АРМ РСО")
    public void operatorIsOn(String page) {
        if (!page.equals("Авторизации")) {
            navigation.opensRSOPage("Главная");
            if (navigation.getCurrentURL().endsWith("sign_in")) {
                operator.entersLoginAndPassword("Admin3", "Test123$");
                operator.clicksToConfirmButton();
            }
            navigation.opensRSOPage(page);
        } else navigation.opensRSOPage("Авторизации");
    }
}
