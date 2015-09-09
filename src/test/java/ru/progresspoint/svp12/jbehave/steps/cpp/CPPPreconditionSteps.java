package ru.progresspoint.svp12.jbehave.steps.cpp;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.cpp.steps.CPPAdministratorSteps;
import ru.progresspoint.svp12.cpp.steps.CPPOperatorSteps;

/**
 * Шаги для приведения АРМа ЦИПП в исходные состояния
 */
public class CPPPreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Steps
    CPPOperatorSteps operator;

    @Steps
    CPPAdministratorSteps administrator;

    @Given("оператор находится на странице $page в АРМ ЦИПП")
    public void operatorIsOn(String page) {
        if (!page.equals("Авторизации")) {
            navigation.opensCPPPage("Главная");
            if (navigation.getCurrentURL().endsWith("sign_in")) {
                operator.entersLoginAndPassword("operator_himki", "1234567890");
                operator.clicksToConfirmButton();
            }
            navigation.opensCPPPage(page);
        } else navigation.opensCPPPage("Авторизации");
    }

    @Given("админ находится на странице $page в АРМ ЦИПП")
    public void adminIsOn(String page) {
        if (!page.equals("Авторизации")) {
            navigation.opensCPPPage("Главная");
            if (navigation.getCurrentURL().endsWith("sign_in")) {
                administrator.entersLoginAndPassword("Admin3", "Test123$");
                administrator.clicksToConfirmButton();
            }
            navigation.opensCPPPage(page);
        } else navigation.opensCPPPage("Авторизации");
    }
}
