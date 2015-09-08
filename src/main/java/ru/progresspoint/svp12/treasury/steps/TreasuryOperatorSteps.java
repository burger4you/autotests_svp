package ru.progresspoint.svp12.treasury.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.progresspoint.svp12.dz.pages.DZLoginPage;
import ru.progresspoint.svp12.treasury.pages.TreasuryLoginPage;

import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.name;

/**
 * Шаги оператора АРМа Казначейства
 */
public class TreasuryOperatorSteps extends ScenarioSteps {

    TreasuryLoginPage loginPage;

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