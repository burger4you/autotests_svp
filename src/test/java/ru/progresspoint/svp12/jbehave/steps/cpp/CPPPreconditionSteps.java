package ru.progresspoint.svp12.jbehave.steps.cpp;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.cpp.steps.CPPUserSteps;

/**
 * Шаги для приведения АРМа ЦИПП в исходные состояния
 */
public class CPPPreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Steps
    CPPUserSteps operator;

    @Given("пользователь находится на странице $page в АРМ ЦИПП")
    @Alias("оператор находится на странице $page в АРМ ЦИПП")
    public void operatorIsOn(String page) {
            navigation.opensCPPPage(page);
    }

    @Given("в ЦИПП обратился зарегистрированный ВТС $owner")
    public void operatorWorksWithOwner(String owner) {
        navigation.opensCPPPage("Выбора действия");
        operator.selectsByAndEntersQueryForSearch("Наименование/ФИО", owner);
        operator.clicksToTextButton("Искать");
        operator.selectsClientByQuery(owner);
    }
}
