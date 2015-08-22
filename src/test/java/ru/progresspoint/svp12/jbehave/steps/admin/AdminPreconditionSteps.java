package ru.progresspoint.svp12.jbehave.steps.admin;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;
import ru.progresspoint.svp12.admin.steps.AdminAdministratorSteps;

/**
 * Шаги для приведения АРМа Администратора в исходные состояния
 */
public class AdminPreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Steps
    AdminAdministratorSteps administrator;

    @Given("администратор находится на странице $page в АРМ Администратора")
    public void administratorIsOn(String page) {
        if (!page.equals("Авторизации")) {
            navigation.opensAdminPage("Главная");
            if (navigation.getCurrentURL().endsWith("sign_in")) {
                administrator.entersLoginAndPassword("Admin3", "Test123$");
                administrator.clicksToConfirmButton();
            }
            navigation.opensAdminPage(page);
        } else navigation.opensAdminPage("Авторизации");
    }
}
