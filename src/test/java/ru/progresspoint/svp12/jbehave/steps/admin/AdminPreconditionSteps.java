package ru.progresspoint.svp12.jbehave.steps.admin;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Шаги для приведения АРМа Администратора в исходные состояния
 */
public class AdminPreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Given("администратор находится на странице $page в АРМ Администратора")
    public void administratorIsOn(String page) {
        navigation.opensAdminPage(page);
    }
}
