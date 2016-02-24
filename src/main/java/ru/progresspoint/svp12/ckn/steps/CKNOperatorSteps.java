package ru.progresspoint.svp12.ckn.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.progresspoint.svp12.ckn.pages.CKNLoginPage;

import static org.openqa.selenium.By.name;

/**
 * Шаги оператора АРМа ЦКН
 */
public class CKNOperatorSteps extends ScenarioSteps {

    CKNLoginPage loginPage;

    @Step("Вводит логин {0} и пароль {1}")
    public void entersLoginAndPassword(String login, String password) {
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
    }

    @Step("Нажимает на кнопку подтверждения")
    public void clicksToConfirmButton() {
        getDriver().findElement(name("commit")).click();
    }

}
