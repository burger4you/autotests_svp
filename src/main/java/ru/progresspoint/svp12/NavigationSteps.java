package ru.progresspoint.svp12;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.progresspoint.svp12.cpp.pages.CPPLoginPage;
import ru.progresspoint.svp12.cpp.pages.CPPOwnerRegistrationPage;
import ru.progresspoint.svp12.lk.pages.LKLoginPage;
import ru.progresspoint.svp12.lk.pages.LKMainPage;
import ru.progresspoint.svp12.lk.pages.LKVehiclesPage;

/**
 * Шаги навигации по всей системе ПО СВП
 */
public class NavigationSteps extends ScenarioSteps {

    CPPLoginPage cppLoginPage;
    CPPOwnerRegistrationPage cppOwnerRegistrationPage;
    LKMainPage  lkMainPage;
    LKLoginPage lkLoginPage;
    LKVehiclesPage vehiclesPage;

    @Step("Открывает страницу {0}")
    public void opensPage(String page) {
        switch (page) {
            case "Авторизации в ЦИПП"              : cppLoginPage.open(); break;
            case "Регистрации ВТС в ЦИПП"          : cppOwnerRegistrationPage.open(); break;
            case "Авторизации в ЛК"                : lkLoginPage.open(); break;
            case "главной ЛК"                      : lkMainPage.open(); break;
            case "Транспортные средства"           : vehiclesPage.open(); break;
        }
    }

    @Step("Находится на странице {0}")
    public void isOnPage(String page) {
        switch (page) {
            case "Авторизации в ЦИПП"              : cppLoginPage.shouldBeDisplayed(); break;
            case "Регистрации ВТС в ЦИПП"          : cppOwnerRegistrationPage.shouldBeDisplayed(); break;
            case "Авторизации в ЛК"                : lkLoginPage.shouldBeDisplayed(); break;
            case "главной ЛК"                      : lkMainPage.shouldBeDisplayed(); break;
            case "Транспортные средства"           : vehiclesPage.shouldBeDisplayed(); break;
        }
    }

    @Step("Заголовок вкладки меняется на {0}")
    public boolean isOnSystem(String title) {
        return titleIs(title);
    }

    public boolean titleIs(String title) {
        waitABit(3000);
        return getDriver().getTitle().equals(title);
    }
}
