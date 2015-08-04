package ru.progresspoint.svp12.jbehave.steps.cpp;

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

    @Then("открывается страница $page в ЦИПП")
    public void pageShouldBeDisplayed(String page) {
        navigation.isOnCPPPage(page);
    }

    @Then("система предоставляет доступ к АРМ ЦИПП")
    public void cppShouldBeAvailableForUser() {
        navigation.isOnCPPPage("Главная");
    }

    @Then("система регистрирует ВТС с этими данными")
    public void registrationVehicleShouldBeDisplayed() {
        operator.shouldSeeInviteToRegistrationVehicle();
    }
}
