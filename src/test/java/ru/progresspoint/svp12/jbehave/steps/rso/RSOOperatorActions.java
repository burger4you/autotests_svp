package ru.progresspoint.svp12.jbehave.steps.rso;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.rso.steps.RSOOperatorSteps;

/**
 * Шаги оператора АРМа РСО
 */
public class RSOOperatorActions {

    @Steps
    RSOOperatorSteps operator;

    @Steps
    NavigationSteps navigation;

    @When("оператор введет логин $login и пароль $password для авторизации в АРМ РСО")
    public void operatorEntersLoginAndPassword(String login, String password) {
        operator.entersLoginAndPassword(login, password);
        operator.clicksToConfirmButton();
    }

    @When("он выберет пункт $item в левом меню")
    public void operatorClicksToItemInMenu(String item) {
        navigation.clicksToTextButton(item);
    }

    @When("оператор найдет и откроет для просмотра ВТС $client с ЛС $account")
    public void operatorLookUpAndOpensClient(String client, String account) {
        navigation.opensRSOPage("Промсмотр ВТС");
        operator.entersClientAndAccountForLookUp(client, account);
        operator.shouldSeeClientInfo();
    }
}