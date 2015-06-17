package ru.progresspoint.svp12.cpp.jbehave.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.cpp.steps.OperatorSteps;

/**
 * Состояния системы, к которым она приходит в результате действий пользователя
 */
public class SystemConditions {

    @Steps
    OperatorSteps operator;

    @Then("открывается страница $page")
    public void pageShouldBeDisplayed(String page) {
        operator.isOnPage(page);
    }

    @Then("оператор входит в подсистему $title")
    public void operatorShouldBeLogin(String title) {
        operator.isOnSystem(title);
    }

    @Then("оператору предлагается зарегистрировать транспортное средство")
    public void registrationVehicleShouldBeDisplayed() {
        operator.shouldSeeInviteToRegistrationVehicle();
    }
}
