package ru.progresspoint.svp12.cpp.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.progresspoint.svp12.cpp.pages.CPPLoginPage;

import static org.openqa.selenium.By.name;

/**
 * Шаги администратора АРМа ЦИПП
 */
public class CPPAdministratorSteps extends ScenarioSteps {

    CPPLoginPage CPPLoginPage;

    @Step("Вводит логин {0} и пароль {1}")
    public void entersLoginAndPassword(String login, String password) {
        CPPLoginPage.enterLogin(login);
        CPPLoginPage.enterPassword(password);
    }

    @Step("Нажимает на кнопку подтверждения")
    public void clicksToConfirmButton() {
        getDriver().findElement(name("commit")).click();
    }
}
