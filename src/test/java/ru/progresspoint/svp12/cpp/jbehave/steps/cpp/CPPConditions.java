package ru.progresspoint.svp12.cpp.jbehave.steps.cpp;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.cpp.steps.CPPOperatorSteps;

/**
 * Состояния системы, к которым она приходит в результате действий пользователя
 */
public class CPPConditions {

    @Steps
    NavigationSteps navigation;

    @Steps
    CPPOperatorSteps operator;

    @Then("открывается страница $page")
    public void pageShouldBeDisplayed(String page) {
        navigation.isOnPage(page);
    }

    @Then("система предоставляет доступ к АРМ ЦИПП")
    public void operatorShouldBeLogin(String title) {
        navigation.isOnPage("Главная страница ЦИПП");
    }

    @Then("система регистрирует ВТС с этими данными")
    public void registrationVehicleShouldBeDisplayed() {
        operator.shouldSeeInviteToRegistrationVehicle();
    }
}
