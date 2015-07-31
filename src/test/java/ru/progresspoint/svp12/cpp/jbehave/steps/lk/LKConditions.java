package ru.progresspoint.svp12.cpp.jbehave.steps.lk;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.EmailUserSteps;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.lk.steps.LKUserSteps;

import static net.thucydides.core.matchers.BeanMatchers.the;
import static ru.progresspoint.utils.StringTimeIsBetweenMatcher.isBetween;


/**
 * Состояния системы, к которым она приходит в результате действий пользователя
 */
public class LKConditions {

    @Steps
    NavigationSteps navigation;

    @Steps
    LKUserSteps user;

    @Steps
    EmailUserSteps email;

    @Then("открывается страница $page в ЛК")
    public void pageShouldBeDisplayed(String page) {
        navigation.isOnLKPage(page);
    }

    @Then("система предоставляет доступ к личному кабинету пользователя")
    public void lkShouldBeAvailableForUser() {
        navigation.isOnLKPage("Главная");
    }

    @Then("система создаст группу для этих ТС с названием $groupName")
    public void vehiclesGroupShouldBeCreated(String groupName) {
        navigation.messageShouldDisplayed(groupName);
    }

    @Then("система увеличит баланс лицевого счета на $fundsAmount рублей")
    public void fundsShouldBeAdded(String fundsAmount) {
        navigation.messageShouldDisplayed("Ваш платеж банковской картой совершен успешно.");
        user.clicksToComesBackToShopButton();
        user.shouldSeeBalancesDifference();
    }

    @Then("система покажет в выписке все операции с $startDate по $endDate")
    public void shouldBeDisplayedTransactionsInPeriod(String startDay, String endDate) {
        user.shouldSeeTransactionsWhere(the("ДАТА И ВРЕМЯ", isBetween(startDay, endDate)));
    }

    @Then("система зарегистрирует обращение со заголовком <title>")
    public void shouldBeDisplayedAppealWithTitle(String title) {

    }

    @Then("система предоставляет пользователю доступ к личному кабинету")
    public void shouldSendEmailWithLoginLink() {
        email.waitForEmailWithVerification();
        email.clickToLoginLink();
        user.entersPassword("Новый пароль");
        user.clicksToConfirmButton();
        navigation.isOnLKPage("Главная");
    }
}

