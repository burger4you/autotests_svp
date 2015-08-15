package ru.progresspoint.svp12.jbehave.steps.dz;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.dz.steps.DZOperatorSteps;

/**
 * Шаги для приведения АРМа ДЗ в исходные состояния
 */
public class DZPreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Steps
    DZOperatorSteps operator;

    @Given("оператор находится на странице $page в АРМ ДЗ")
    public void operatorIsOn(String page) {
        if (!page.equals("Авторизации")) {
            navigation.opensDZPage("Главная");
            if (navigation.getCurrentURL().endsWith("sign_in")) {
                operator.entersLoginAndPassword("Admin3", "Test123$");
                operator.clicksToConfirmButton();
            }
            navigation.opensDZPage(page);
        } else navigation.opensDZPage("Авторизации");
    }
}
