package ru.progresspoint.svp12.lk.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.progresspoint.svp12.lk.pages.*;

/**
 * Шаги конечного пользователя АРМа Личный Кабинет
 */
public class LKUserSteps extends ScenarioSteps {

    LKLoginPage loginPage;
    LKMainPage mainPage;
    LKVehiclesPage vehiclesPage;
    LKVehiclesGroupPage groupVehiclesPage;
    LKNewVehiclesGroupPage newVehiclesGroupPage;

    @Step("Вводит логин {0} и пароль {1}")
    public void entersLoginAndPassword(String login, String password) {
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
    }

    @Step("Жмет кнопку Войти")
    public void clickLoginButton() {
        loginPage.clickConfirmButton();
    }

    @Step("Выбирает в меню Транспортные средства")
    public void clickToVehiclesItemMenu() {
        mainPage.clickToVehiclesItemMenu();
    }

    @Step("Жмет ссылку Группы транспортных средств")
    public void clickToGroupsVehiclesLink() {
        vehiclesPage.clickToVehiclesGroupsLink();
    }

    @Step("Жмет ссылку Добавить новую группы транспортных средств")
    public void clickToNewGroupVehiclesLink() {
        groupVehiclesPage.clickToNewVehiclesGroupLink();
    }

    @Step("Вводит название новой группы {0}")
    public void enterNameForNewGroupVehicles(String groupName) {
        newVehiclesGroupPage.enterVehiclesGroupName(groupName);
    }

    @Step("Выбирает {0} машин(ы) для новой группы")
    public void chooseVehiclesForGroup(int amountVehicles) {
        newVehiclesGroupPage.chooseForGroupRandomVehicles(amountVehicles);
    }

    @Step("Кликает кнопку подтверждения")
    public void clickToConfirmButton() {
        newVehiclesGroupPage.clickConfirmButton();
    }

    @Step("Должен увидеть алерт, что группа {0} создана")
    public void shouldSeeConfirmAlert(String groupName) {
        newVehiclesGroupPage.waitForTextToAppear(String.format("Группа %s успешно создана.", groupName));
    }
}