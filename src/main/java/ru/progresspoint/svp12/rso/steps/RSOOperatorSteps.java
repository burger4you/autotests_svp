package ru.progresspoint.svp12.rso.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.progresspoint.svp12.rso.pages.RSOClientPage;
import ru.progresspoint.svp12.rso.pages.RSOLoginPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.name;

/**
 * Шаги оператора АРМа РСО
 */
public class RSOOperatorSteps extends ScenarioSteps {

    RSOLoginPage loginPage;
    RSOClientPage clientPage;

    @Step("Вводит логин {0} и пароль {1}")
    public void entersLoginAndPassword(String login, String password) {
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
    }

    @Step("Нажимает на кнопку подтверждения")
    public void clicksToConfirmButton() {
        getDriver().findElement(name("commit")).click();
    }

    @Step("Ищет ВТС {0} с ЛС {1} для просмотра")
    public void entersClientAndAccountForLookUp(String client, String account) {
        clientPage.enterSearchClient(client);
        clientPage.enterSearchAccount(account);
    }

    @Step("Видит информацию по ВТС")
    public void shouldSeeClientInfo() {
        assertThat(clientPage.hasClientInfo())
                .overridingErrorMessage("Информация по ВТС не отображается")
                .isTrue();
    }

}
