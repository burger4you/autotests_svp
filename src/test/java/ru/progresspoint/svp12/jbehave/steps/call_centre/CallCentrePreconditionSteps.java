package ru.progresspoint.svp12.jbehave.steps.call_centre;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.admin.steps.AdminAdministratorSteps;
import ru.progresspoint.svp12.call_centre.steps.CallCentreCuratorSteps;
import ru.progresspoint.svp12.call_centre.steps.CallCentreFirstLineSteps;
import ru.progresspoint.svp12.call_centre.steps.CallCentreSecondLineSteps;
import ru.progresspoint.svp12.call_centre.steps.CallCentreTeamLeadSteps;

/**
 * Шаги для приведения АРМа Колл Центра в исходные состояния
 */
public class CallCentrePreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Steps
    CallCentreFirstLineSteps operatorFirstLine;

    @Steps
    CallCentreSecondLineSteps operatorSecondLine;

    @Steps
    CallCentreTeamLeadSteps teamLead;

    @Steps
    CallCentreCuratorSteps curator;

    @Given("оператор 1-ой линии находится на странице $page в АРМ Колл Центра")
    public void operatorFirstLineIsOn(String page) {
        if (!page.equals("Авторизации")) {
            navigation.opensCallCenterPage("Главная");
            if (navigation.getCurrentURL().endsWith("sign_in")) {
                operatorFirstLine.entersLoginAndPassword("Admin3", "Test123$");
                operatorFirstLine.clicksToConfirmButton();
            }
            navigation.opensCallCenterPage(page);
        } else navigation.opensCallCenterPage("Авторизации");
    }

    @Given("оператор 2-ой линии находится на странице $page в АРМ Колл Центра")
    public void operatorSecondLineIsOn(String page) {
        if (!page.equals("Авторизации")) {
            navigation.opensCallCenterPage("Главная");
            if (navigation.getCurrentURL().endsWith("sign_in")) {
                operatorSecondLine.entersLoginAndPassword("Admin3", "Test123$");
                operatorSecondLine.clicksToConfirmButton();
            }
            navigation.opensCallCenterPage(page);
        } else navigation.opensCallCenterPage("Авторизации");
    }

    @Given("руководитель группы поддержки находится на странице $page в АРМ Колл Центра")
    public void teamLeadIsOn(String page) {
        if (!page.equals("Авторизации")) {
            navigation.opensCallCenterPage("Главная");
            if (navigation.getCurrentURL().endsWith("sign_in")) {
                teamLead.entersLoginAndPassword("Admin3", "Test123$");
                teamLead.clicksToConfirmButton();
            }
            navigation.opensCallCenterPage(page);
        } else navigation.opensCallCenterPage("Авторизации");
    }

    @Given("куратор находится на странице $page в АРМ Колл Центра")
    public void curatorIsOn(String page) {
        if (!page.equals("Авторизации")) {
            navigation.opensCallCenterPage("Главная");
            if (navigation.getCurrentURL().endsWith("sign_in")) {
                curator.entersLoginAndPassword("Admin3", "Test123$");
                curator.clicksToConfirmButton();
            }
            navigation.opensCallCenterPage(page);
        } else navigation.opensCallCenterPage("Авторизации");
    }
}