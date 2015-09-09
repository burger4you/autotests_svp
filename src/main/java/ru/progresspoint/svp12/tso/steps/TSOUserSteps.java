package ru.progresspoint.svp12.tso.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.progresspoint.svp12.treasury.pages.TreasuryLoginPage;
import ru.progresspoint.svp12.tso.pages.TSOLoginPage;
import ru.progresspoint.svp12.tso.pages.TSOStartPage;

import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.name;

/**
 * Шаги пользователя АРМа ТСО
 */
public class TSOUserSteps extends ScenarioSteps {

    TSOLoginPage loginPage;

    @Step("Нажимает на кнопку {0}")
    public void clicksToButton(String linkText) {
        getDriver().findElement(linkText(linkText));
    }

    @Step("Вводит гос номер ТС {0}, номер {1} и дату выдачи {2} свидетельства о регистрации ТС")
    public void entersAuthorisationData(String grnz, String stsNumber, String stsDate) {
        loginPage.enterGRNZ(grnz);
        loginPage.enterStsNumber(stsNumber);
        loginPage.enterStsDate(stsDate);
    }

    @Step("Выбирает страну регистрации ТС {0}")
    public void selectVehicleCountry(String country) {
    }
}
