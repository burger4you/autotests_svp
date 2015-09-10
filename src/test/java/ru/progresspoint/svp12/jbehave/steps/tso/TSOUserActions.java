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

    @When("пользователь вводит ГРНЗ $grnz и номер СТС $stsNumber выданный $stsDate для авторизации в АРМ ТСО")
    public void operatorEntersLoginAndPassword(String grnz, String stsNumber, String stsDate) {
        user.clicksToButton("Начать использование");
        user.selectVehicleCountry("Россия");
        user.clicksToButton("Далее");
        user.entersAuthorisationData(grnz, stsNumber, stsDate);
        user.clicksToButton("Далее");
    }
}