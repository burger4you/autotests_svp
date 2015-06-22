package ru.progresspoint.svp12.cpp.jbehave.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.cpp.steps.OperatorSteps;

/**
 * Шаги навигации, для приведения системы в исходные состояния
 */
public class NavigationSteps {

    @Steps
    OperatorSteps operator;

    @Given("оператор находится на странице \"$page\"")
    public void operatorIsOn(String page) {
        if (!operator.isOnSystem("АРМ ЦИПП") && !page.equals("Авторизация")) {
            operator.opensPage("Авторизация");
            operator.entersLoginAndPassword("Operator", "!Test1");
            operator.clickLoginButton();
        }
        operator.opensPage(page);
    }
}
