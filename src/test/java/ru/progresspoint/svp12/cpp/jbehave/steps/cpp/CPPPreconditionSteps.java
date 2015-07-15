package ru.progresspoint.svp12.cpp.jbehave.steps.cpp;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.cpp.steps.CPPOperatorSteps;

/**
 * Шаги для приведения АРМа ЦИПП в исходные состояния
 */
public class CPPPreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Steps
    CPPOperatorSteps operator;

    @Given("оператор находится на странице $page в ЦИПП")
    public void operatorIsOn(String page) {
        if (!page.contains("Авторизации")) {
            navigation.opensCPPPage("Авторизации");
            operator.entersLoginAndPassword("operator.cpp", "Test123!");
            operator.clickLoginButton();
        }
        navigation.opensCPPPage(page);
    }
}
