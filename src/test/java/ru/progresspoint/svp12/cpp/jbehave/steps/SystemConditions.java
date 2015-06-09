package ru.progresspoint.svp12.cpp.jbehave.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.cpp.steps.OperatorSteps;

/**
 * Состояния системы, к которым она приходит в результате действий оператора
 */
public class SystemConditions {

    @Steps
    OperatorSteps operator;

    @Then("открывается страница \"$page\"")
    public void pageShouldBeDisplayed(String page) {
        operator.isOnPage(page);
    }
}
