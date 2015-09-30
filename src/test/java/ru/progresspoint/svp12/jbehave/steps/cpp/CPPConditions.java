package ru.progresspoint.svp12.jbehave.steps.cpp;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.EmailUserSteps;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.cpp.steps.CPPOperatorSteps;
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
    CPPOperatorSteps operator;

    @Then("система откроет страницу $page в АРМ ЦИПП")
    public void pageShouldBeDisplayed(String page) {
        navigation.isOnCPPPage(page);
    }

    @Then("система предоставит доступ к АРМ ЦИПП")
    public void cppShouldBeAvailableForUser() {
        navigation.isOnCPPPage("Главная");
    }

    @Then("система отправит на $email ссылку с доступом к ЛК")
    public void systemSentLinkToLKOn(String emailAddress) throws IOException, MessagingException {
        email.waitsForEmailWithAccessLink(emailAddress);
        navigation.opensLKPage("Авторизации");
        user.entersLoginAndPassword((String) getCurrentSession().get("login"), (String) getCurrentSession().get("password"));
        user.clicksToConfirmButton();
        navigation.isOnLKPage("Главная");
        email.deletesAllMessagesFromPlaton(emailAddress);
    }

    @Then("система отправит на $emailAddress уведомление $notification")
    public void systemSentNotificationOn(String emailAddress, String notification) throws IOException, MessagingException {
        email.waitsForEmailWithNotification(emailAddress);
        email.deletesAllMessagesFromSVP12(emailAddress);
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
