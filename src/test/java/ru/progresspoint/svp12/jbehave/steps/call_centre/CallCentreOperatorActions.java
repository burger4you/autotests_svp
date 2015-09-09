package ru.progresspoint.svp12.jbehave.steps.call_centre;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.call_centre.steps.CallCentreCuratorSteps;
import ru.progresspoint.svp12.call_centre.steps.CallCentreFirstLineSteps;
import ru.progresspoint.svp12.call_centre.steps.CallCentreSecondLineSteps;
import ru.progresspoint.svp12.call_centre.steps.CallCentreTeamLeadSteps;

/**
 * Шаги пользователей АРМа Колл Центра
 */
public class CallCentreOperatorActions {

    @Steps
    CallCentreFirstLineSteps operatorFirstLine;

    @Steps
    CallCentreSecondLineSteps operatorSecondLine;

    @Steps
    CallCentreTeamLeadSteps teamLead;

    @Steps
    CallCentreCuratorSteps curator;


    @When("оператор 1-ой линии находится на странице Авторизации в АРМ Колл Центра")
     public void operatorFirstLineEntersLoginAndPassword(String login, String password) {
        operatorFirstLine.entersLoginAndPassword(login, password);
        operatorFirstLine.clicksToConfirmButton();
    }

    @When("оператор 2-ой линии находится на странице Авторизации в АРМ Колл Центра")
    public void operatorSecondLineEntersLoginAndPassword(String login, String password) {
        operatorSecondLine.entersLoginAndPassword(login, password);
        operatorSecondLine.clicksToConfirmButton();
    }

    @When("руководитель группы поддержки находится на странице Авторизации в АРМ Колл Центра")
    public void teamLeadEntersLoginAndPassword(String login, String password) {
        teamLead.entersLoginAndPassword(login, password);
        teamLead.clicksToConfirmButton();
    }

    @When("куратор находится на странице Авторизации в АРМ Колл Центра")
    public void curatorEntersLoginAndPassword(String login, String password) {
        curator.entersLoginAndPassword(login, password);
        curator.clicksToConfirmButton();
    }
}