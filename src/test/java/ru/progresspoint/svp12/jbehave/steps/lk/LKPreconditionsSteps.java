package ru.progresspoint.svp12.jbehave.steps.lk;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.EmailUserSteps;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.lk.steps.LKUserSteps;

import javax.mail.MessagingException;

/**
 * Шаги для приведения АРМа ЛК в исходные состояния
 */
public class LKPreconditionsSteps {

    @Steps
    NavigationSteps navigation;

    @Steps
    LKUserSteps user;

    @Steps
    EmailUserSteps email;

    @Given("в его почтовом ящике нет писем от СВП Платон")
    public void userHaveNoEmailFromPlaton() throws MessagingException {
        email.deletesAllMessagesFromPlaton("ultestowner@gmail.com");
        email.deletesAllMessagesFromPlaton("iptestowner@gmail.com");
        email.deletesAllMessagesFromPlaton("fltestowner@gmail.com");
    }

    @Given("пользователь находится на странице $page в ЛК")
    public void userIsOnLKPage(String page) {
        if (!page.equals("Авторизации")) {
            navigation.getDriver().get("http://10.0.12.225");
            if (navigation.getCurrentURL().endsWith("sign_in")) {
                user.entersLoginAndPassword("okapustina", "!QAZ2wsc");
                user.clicksToConfirmButton();
            }
            navigation.opensLKPage(page);
        } else
            navigation.opensLKPage("Авторизации");
    }
}