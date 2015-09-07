package ru.progresspoint.svp12.rso.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.progresspoint.svp12.dz.pages.DZLoginPage;

import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.name;

/**
 * Шаги оператора АРМа РСО
 */
public class RSOOperatorSteps extends ScenarioSteps {

    DZLoginPage loginPage;

    @Step("Нажимает на ссылку {0}")
    public void clicksToLink(String linkText) {
        getDriver().findElement(linkText(linkText));
    }

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
