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

    @Given("оператор находится на странице $page")
    public void operatorIsOn(String page) {
        if (!navigation.titleIs("АРМ ЦИПП") && !page.contains("Авторизации")) {
            navigation.opensPage("Авторизации в ЦИПП");
            operator.entersLoginAndPassword("Operator", "!Test1");
            operator.clickLoginButton();
        }
        navigation.opensPage(page);
    }
}
