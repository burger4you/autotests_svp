package ru.progresspoint.svp12.jbehave.steps.lk;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.BeforeStories;
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

    @BeforeStories
    public void beforeStory() throws MessagingException {
        email.deletesAllMessagesFromProgresspoint("ultestowner@gmail.com");
        email.deletesAllMessagesFromProgresspoint("iptestowner@gmail.com");
        email.deletesAllMessagesFromProgresspoint("fltestowner@gmail.com");
    }

    @Given("пользователь находится на странице $page в ЛК")
    public void userIsOnLKPage(String page) {
        if (!page.equals("Авторизации")) {
            navigation.opensLKPage("Главная");
            if (navigation.getCurrentURL().endsWith("sign_in")) {
                user.entersLoginAndPassword("okapustina", "!QAZ2wsc");
                user.clicksToConfirmButton();
            }
            navigation.opensLKPage(page);
        } else
            navigation.opensLKPage("Авторизации");
    }
}