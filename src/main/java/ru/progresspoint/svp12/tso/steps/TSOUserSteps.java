package ru.progresspoint.svp12.tso.steps;


import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.progresspoint.svp12.tso.pages.TSOLoginPage;
import ru.progresspoint.svp12.tso.pages.TSOStartPage;

/**
 * Шаги пользователя АРМа ТСО
 */
public class TSOUserSteps extends ScenarioSteps {

    TSOStartPage startPage;
    TSOLoginPage loginPage;

    @Step("Нажимает на кнопку Начать использование")
    public void clicksToStartButton() {
        startPage.clickToStartButton();
    }

    @Step("Нажимает на кнопку Информация о системе")
    public void clicksToInfoButton() {
        startPage.clickToInfoButton();
    }

    @Step("Нажимает на кнопку Далее")
    public void clicksToNextButton() {
        getDriver().findElement(By.xpath(".//*[@class='go_next']")).click();
    }

    @Step("Нажимает на кнопку Назад")
    public void clicksToBackButton() {
        getDriver().findElement(By.xpath(".//*[@class='go_back']")).click();
    }

    @Step("Выбирает страну регистрации ТС {0}")
    public void selectVehicleCountry(String country) {
    }

    @Step("Вводит гос номер ТС {0} и номер свидетельства о регистрации ТС {1}")
    public void entersAuthorisationData(String grnz, String stsNumber) {
        loginPage.enterGRNZ(grnz);
        loginPage.enterStsNumber(stsNumber);
    }
}
