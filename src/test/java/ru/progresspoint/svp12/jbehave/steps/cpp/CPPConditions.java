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

    @Then("открывается страница $page в ЦИПП")
    public void pageShouldBeDisplayed(String page) {
        navigation.isOnCPPPage(page);
    }

    @Then("система предоставляет доступ к АРМ ЦИПП")
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

    @Then("система отобразит найденные по запросу $query ВТС")
    public void searchedClientsShouldBeDisplayed(String query) {
        operator.looksUpClientByQuery(query);
    }
}
