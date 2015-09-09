package ru.progresspoint.svp12.call_centre.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.progresspoint.svp12.call_centre.pages.CallCentreLoginPage;
import ru.progresspoint.svp12.call_centre.pages.CallCentreMainPage;
import ru.progresspoint.svp12.dz.pages.DZLoginPage;

import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.name;

/**
 * Шаги оператора 1-ой линии поддержки АРМа Колл Центра
 */
public class CallCentreFirstLineSteps extends ScenarioSteps {

    CallCentreLoginPage loginPage;

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
