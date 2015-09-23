package ru.progresspoint.svp12.jbehave.steps.lk;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.EmailUserSteps;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.lk.steps.LKUserSteps;

import javax.mail.MessagingException;
import java.io.IOException;

import static org.joda.time.DateTime.parse;
import static org.joda.time.format.DateTimeFormat.forPattern;

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

    @Then("система предоставит доступ к личному кабинету пользователя")
    public void lkShouldBeAvailableForUser() {
        navigation.isOnLKPage("Транспортные средства");
    }

    @Then("система отобразит его в общем списке ТС")
    public void systemShouldDisplaysVehicle() {
        navigation.clicksToOkInConfirmationPopUp("ТС зарегистрировано");
        user.shouldSeeVehicleInCommonList();
    }

    @Then("ТС откроется для просмотра деталей")
    public void systemShouldDisplaysVehicleDetails() {
        user.shouldSeeCorrectVehicleDetail();
    }

    @Then("система отобразит её в общем списке групп ТС")
    public void systemShouldDisplaysVehiclesGroup() {
        navigation.clicksToOkInConfirmationPopUp("Группа создана");
        user.shouldSeeVehiclesGroupInCommonList();
    }

    @Then("группа ТС откроется для просмотра деталей")
    public void systemShouldDisplaysVehiclesGroupDetails() {
        user.shouldSeeCorrectVehiclesGroupDetail();
    }

    @Then("система увеличит баланс лицевого счета на $fundsAmount рублей")
    public void fundsShouldBeAdded(String fundsAmount) {
        navigation.messageShouldDisplayed("Ваш платеж банковской картой совершен успешно.");
        user.clicksToComesBackToShopButton();
    }

    @Then("система покажет в выписке все операции с $startDate по $endDate")
    public void shouldBeDisplayedTransactionsInPeriod(String startDay, String endDate) {
        user.shouldSeeTransactionsDatesBetween(parse(startDay, forPattern("dd.MM.yyyy")), parse(endDate, forPattern("dd.MM.yyyy")));
    }

    @Then("система отобразит это обращение в общем списке обращений")
    public void systemShouldDisplaysAppeal() {
        navigation.clicksToOkInConfirmationPopUp("Обращение подано");
        user.shouldSeeAppealInCommonList();
    }

    @Then("найдет только обращения, поданные за последние три месяца")
    public void systemShouldDisplaysAppealForLastThreeMonth() {
        user.shouldSeeAppealForLastThreeMonth();
    }

    @Then("обращение откроется для просмотра деталей")
    public void systemShouldDisplaysAppealDetails() {
        user.shouldSeeCorrectAppealDetail();
    }

    @Then("система предоставит пользователю доступ к личному кабинету ($userEmail)")
    public void shouldSendEmailWithLoginLink(String userEmail) throws IOException, MessagingException {
        email.waitsForEmailWithConfirmationLink(userEmail);
        email.clicksToConfirmationLink();
        user.entersPassword("!QAZ2wsx");
        user.clicksToConfirmButton();
        navigation.isOnLKPage("Транспортные средства");
    }
}

