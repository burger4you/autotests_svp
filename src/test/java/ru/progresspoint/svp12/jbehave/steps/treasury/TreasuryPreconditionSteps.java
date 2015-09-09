package ru.progresspoint.svp12.jbehave.steps.treasury;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.dz.steps.DZOperatorSteps;
import ru.progresspoint.svp12.treasury.steps.TreasuryOperatorSteps;

/**
 * Шаги для приведения АРМа Казначейства в исходные состояния
 */
public class TreasuryPreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Steps
    TreasuryOperatorSteps operator;

    @Given("оператор находится на странице $page в АРМ Казначейства")
    public void operatorIsOn(String page) {
        if (!page.equals("Авторизации")) {
            navigation.opensTreasuryPage("Главная");
            if (navigation.getCurrentURL().endsWith("sign_in")) {
                operator.entersLoginAndPassword("Admin3", "Test123$");
                operator.clicksToConfirmButton();
            }
            navigation.opensTreasuryPage(page);
        } else navigation.opensTreasuryPage("Авторизации");
    }
}
