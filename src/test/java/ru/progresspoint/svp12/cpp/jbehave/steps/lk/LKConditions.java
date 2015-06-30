package ru.progresspoint.svp12.cpp.jbehave.steps.lk;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.lk.steps.LKUserSteps;

/**
 * Состояния системы, к которым она приходит в результате действий пользователя
 */
public class LKConditions {

    @Steps
    NavigationSteps navigation;

    @Steps
    LKUserSteps user;

    @Then("открывается страница $page")
    public void pageShouldBeDisplayed(String page) {
        navigation.isOnPage(page);
    }

    @Then("оператор входит в подсистему $title")
    public void operatorShouldBeLogin(String title) {
        navigation.isOnSystem(title);
    }

    @Then("система предоставляет доступ к его аккаунту в Личный кабинет пользователя")
    public void registrationVehicleShouldBeDisplayed() {
        navigation.isOnPage("");
    }

    @Then("система создаст группу для этих ТС с названием $groupName")
    public void vehiclesGroupShouldBeCreated(String groupName) {
        user.shouldSeeConfirmAlert(groupName);
    }
}
