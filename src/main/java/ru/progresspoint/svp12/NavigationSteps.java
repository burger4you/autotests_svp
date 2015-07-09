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
    LKMainPage lkMainPage;
    LKLoginPage lkLoginPage;
    LKVehiclesPage lkVehiclesPage;

    @Step("Открывает страницу {0}")
    public void opensPage(String page) {
        switch (page) {
            case "Авторизации в ЦИПП"              : cppLoginPage.openAt("http://10.0.12.227/sign_in"); break;
            case "Регистрации ВТС в ЦИПП"          : cppOwnerRegistrationPage.openAt("http://10.0.12.227/clients/draft"); break;


            case "Авторизации в ЛК"                : lkLoginPage.openAt("http://10.0.12.225/sign_in"); break;
            case "главной ЛК"                      : lkMainPage.openAt("http://10.0.12.225"); break;
            case "Транспортные средства"           : lkMainPage.loading();
                                                     lkMainPage.clickToVehiclesItemMenu(); break;
            case "Маршрутные карты"                : lkMainPage.loading();
                                                     lkMainPage.clickToMapsItemMenu(); break;
            case "Платежи"                         : lkMainPage.loading();
                                                     lkMainPage.clickToPaymentsItemMenu(); break;
            case "Профиль"                         : lkMainPage.loading();
                                                     lkMainPage.clickToProfileItemMenu(); break;
            case "Обращения"                       : lkMainPage.loading();
                                                     lkMainPage.clickToAppealsItemMenu(); break;
        }
    }

    @Step("Находится на странице {0}")
    public void isOnPage(String page) {
        switch (page) {
            case "Авторизации в ЦИПП"              : cppLoginPage.shouldBeDisplayed(); break;
            case "Регистрации ВТС в ЦИПП"          : cppOwnerRegistrationPage.shouldBeDisplayed(); break;
            case "Авторизации в ЛК"                : lkLoginPage.shouldBeDisplayed(); break;
            case "главной ЛК"                      : lkMainPage.shouldBeDisplayed(); break;
            case "Транспортные средства"           : lkVehiclesPage.shouldBeDisplayed(); break;
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
