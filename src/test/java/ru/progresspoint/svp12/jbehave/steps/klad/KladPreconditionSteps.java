package ru.progresspoint.svp12.jbehave.steps.klad;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.klad.steps.KladStorekeeperSteps;

/**
 * Шаги для приведения АРМа Кладовщика в исходные состояния
 */
public class KladPreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Steps
    KladStorekeeperSteps storekeeper;

    @Given("кладовщик находится на странице $page в АРМ Кладовщика")
    public void operatorIsOn(String page) {
        if (!page.equals("Авторизации")) {
            navigation.opensKladPage("Главная");
            if (navigation.getCurrentURL().endsWith("sign_in")) {
                storekeeper.entersLoginAndPassword("Admin3", "Test123$");
                storekeeper.clicksToConfirmButton();
            }
            navigation.opensKladPage(page);
        } else navigation.opensKladPage("Авторизации");
    }
}
