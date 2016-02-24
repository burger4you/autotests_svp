package ru.progresspoint.svp12.jbehave.steps.tso;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.tso.steps.TSOUserSteps;

/**
 * Шаги пользователя АРМа ТСО
 */
public class TSOUserActions {

    @Steps
    TSOUserSteps user;

    @When("он введет ГРНЗ $grnz и номер СТС $stsNumber для авторизации в АРМ ТСО")
    public void userEntersGRNZAndSTS(String grnz, String stsNumber) {
        user.clicksToStartButton();
        user.selectVehicleCountry("Россия");
        user.clicksToNextButton();
        user.entersAuthorisationData(grnz, stsNumber);
        user.clicksToNextButton();
    }

    @When("он обратится за дополнительной информацией к терминалу")
    public void userClicksToInfoButton() {
        user.clicksToInfoButton();
    }
}