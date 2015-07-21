package ru.progresspoint.svp12.cpp.jbehave.steps.lk;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.joda.time.DateTime;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.lk.steps.LKUserSteps;

import static net.thucydides.core.matchers.BeanMatchers.the;
import static net.thucydides.core.matchers.dates.DateMatchers.isBetween;

/**
 * Состояния системы, к которым она приходит в результате действий пользователя
 */
public class LKConditions {

    @Steps
    NavigationSteps navigation;

    @Steps
    LKUserSteps user;

    @Then("открывается страница $page в ЛК")
    public void pageShouldBeDisplayed(String page) {
        navigation.isOnLKPage(page);
    }

    @Then("система предоставляет доступ к личному кабинету пользователя")
    public void registrationVehicleShouldBeDisplayed() {
        navigation.isOnLKPage("Главная");
    }

    @Then("система создаст группу для этих ТС с названием $groupName")
    public void vehiclesGroupShouldBeCreated(String groupName) {
        user.shouldSeeConfirmAlert(groupName);
    }

    @Then("система увеличит баланс лицевого счета на $fundsAmount рублей")
    public void fundsShouldBeAdded(String fundsAmount) {
        navigation.messageShouldDisplayed("Ваш платеж банковской картой совершен успешно.");
        user.comesBackToShop();
        user.shouldSeeBalancesDifference();
    }

    @Then("система покажет в выписке все операции с $startDay.$startMonth.$startYear по $endDay.$endMonth.$endYear")
    public void shouldBeDisplayedTransactionsInPeriod(int startDay,
                                                      int startMonth,
                                                      int startYear,
                                                      int endDay,
                                                      int endMonth,
                                                      int endYear) {
        DateTime yodaStartDate = new DateTime(startYear, startDay, startMonth, 12, 0).toDateTime();
        DateTime yodaEndDate = new DateTime(endYear, endMonth, endDay, 12, 0).toDateTime();
        user.shouldSeeTransactionsWhere(the("Дата и время", isBetween(yodaStartDate, yodaEndDate)));
    }
}
