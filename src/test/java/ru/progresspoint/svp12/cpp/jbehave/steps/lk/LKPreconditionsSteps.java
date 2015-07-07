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

    @Given("пользователь находится на странице $page")
    public void userIsOn(String page) {
        if (!page.equals("Авторизации в ЛК")) {
            navigation.opensPage("Авторизации в ЛК");
            user.entersLoginAndPassword("okapustina", "!QAZ2wsx");
            user.clickLoginButton();
        }
        navigation.opensPage(page);

    }
}
