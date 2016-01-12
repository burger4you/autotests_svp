package ru.progresspoint.svp12.jbehave.steps.cpp;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.EmailUserSteps;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.cpp.steps.CPPUserSteps;
import ru.progresspoint.svp12.lk.steps.LKUserSteps;

import javax.mail.MessagingException;
import java.io.IOException;

import static net.serenitybdd.core.Serenity.getCurrentSession;

/**
 * Состояния системы, к которым она приходит в результате действий пользователя
 */
public class CPPConditions {

    @Steps
    NavigationSteps navigation;

    @Steps
    EmailUserSteps email;

    @Steps
    LKUserSteps user;

    @Steps
    CPPUserSteps operator;

    @Then("система откроет страницу $page в АРМ ЦИПП")
    public void pageShouldBeDisplayed(String page) {
        navigation.isOnCPPPage(page);
    }

    @Then("система предоставит доступ к АРМ ЦИПП для роли $role")
    public void cppShouldBeAvailableForUser(String role) {
        switch (role) {
            case "Оператор" :
            navigation.isOnCPPPage("Главная");
            break;
        }
    }

    @Then("система отправит на $email ссылку с доступом к ЛК")
    public void systemSentLinkToLKOn(String emailAddress) throws IOException, MessagingException {
        email.waitsForEmailWithSetLKPasswordLink(emailAddress);
//        email.clicksToLinkFromEmail();
//        user.entersPassword("!QAZ2wsx");
//        user.clicksToConfirmButton();
//        navigation.isOnLKPage("Транспортные средства");
    }

    @Then("система отправит на $emailAddress уведомление $notification")
    public void systemSentNotificationOn(String emailAddress, String notification) throws IOException, MessagingException {
        email.waitsForEmailWithNotification(emailAddress, notification);
    }

    @Then("система отобразит найденные по запросу $query ВТС")
    public void searchedClientsShouldBeDisplayed(String query) {
        operator.looksUpClientByQuery(query);
    }

    @Then("система сохранит событие $theme - $details - $status в истории текущего обращения")
    public void systemShouldUpdateAppealHistory(String theme, String details, String status) {
        operator.clicksToLink("История");
        operator.shouldSeeEventInCommonHistory(theme, details, status);
        operator.clicksToCloseHistoryPopUp();
    }
}
