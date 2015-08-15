package ru.progresspoint.svp12.klad.steps;


import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import ru.progresspoint.svp12.klad.pages.KladLoginPage;

import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.name;

/**
 * Шаги кладовщика
 */
public class KladStorekeeperSteps extends PageObject {

    KladLoginPage loginPage;

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
