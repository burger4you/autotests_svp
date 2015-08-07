package ru.progresspoint.svp12.jbehave.steps.lk;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.EmailUserSteps;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.lk.steps.LKUserSteps;

import javax.mail.MessagingException;
import java.io.IOException;

import static org.joda.time.DateTime.parse;

/**
 * Состояния системы, к которым она приходит в результате действий пользователя
 */
public class LKConditions {

    @Steps
    NavigationSteps navigation;

    @Steps
    EmailUserSteps email;

    @Steps
    LKUserSteps user;

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
    }

    @Then("система покажет в выписке все операции с $startDate по $endDate")
    public void shouldBeDisplayedTransactionsInPeriod(String startDay, String endDate) {
        user.shouldSeeTransactionsDatesBetween(parse(startDay), parse(endDate));
    }

    @Then("система отобразит его в общем списке обращений")
    public void systemShouldDisplaysAppeal() {
        user.shouldSeeAppealInCommonList();
    }

    @Then("найдет только обращения, поданные за последние три месяца")
    public void systemShouldDisplaysAppealForLastThreeMonth() {
        user.shouldSeeAppealForLastThreeMonth();
    }

    @Then("оно откроется для просмотра деталей")
    public void systemShouldDisplaysAppealDetails() {
        user.shouldSeeCorrectAppealDetail();
    }

    @Then("система предоставляет пользователю доступ к личному кабинету ($userEmail)")
    public void shouldSendEmailWithLoginLink(String userEmail) throws IOException, MessagingException {
        email.waitsForEmailWithConfirmationLink(userEmail);
        email.clicksToConfirmationLink();
        user.entersPassword("!QAZ2wsx");
        user.clicksToConfirmButton();
        navigation.isOnLKPage("Главная");
    }
}

