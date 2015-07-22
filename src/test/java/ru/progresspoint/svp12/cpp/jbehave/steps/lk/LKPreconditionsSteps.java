package ru.progresspoint.svp12.cpp.jbehave.steps.lk;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.lk.steps.LKUserSteps;

/**
 * Шаги для приведения АРМа ЛК в исходные состояния
 */
public class LKPreconditionsSteps {

    @Steps
    NavigationSteps navigation;

    @Steps
    LKUserSteps user;

    @Given("пользователь находится на странице $page в ЛК")
    public void userIsOnLKPage(String page) {
        if (!page.equals("Авторизации")) {
            navigation.opensLKPage("Главная");
            if (navigation.getTitle().endsWith("sign_in")) {
                user.entersLoginAndPassword("okapustina", "!QAZ2wsc");
                user.clicksToLoginButton();
            } else navigation.opensLKPage(page);
        } else navigation.opensLKPage("Авторизации");
    }
}