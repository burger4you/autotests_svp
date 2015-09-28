package ru.progresspoint.svp12.jbehave.steps.cpp;

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

    @Given("оператор находится на странице $page в АРМ ЦИПП")
    public void operatorIsOn(String page) {
            navigation.opensCPPPage(page);
    }

    @Given("в ЦИПП поступило обращение от зарегистрированного ВТС $owner")
    public void operatorWorksWithOwner(String owner) {
        navigation.opensCPPPage("Выбора действия");
        operator.searchClientByQuery(owner);
        operator.selectsClientByQuery(owner);
    }

    @Given("админ находится на странице $page в АРМ ЦИПП")
    public void adminIsOn(String page) {
            navigation.opensCPPPage(page);
    }
}
