package ru.progresspoint.svp12;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.progresspoint.svp12.cpp.pages.CPPLoginPage;
import ru.progresspoint.svp12.cpp.pages.CPPMainPage;
import ru.progresspoint.svp12.cpp.pages.CPPOwnerRegistrationPage;
import ru.progresspoint.svp12.lk.pages.LKLoginPage;
import ru.progresspoint.svp12.lk.pages.LKMainPage;
import ru.progresspoint.svp12.lk.pages.LKVehiclesPage;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Шаги навигации по всей системе ПО СВП
 */
public class NavigationSteps extends ScenarioSteps {

    CPPLoginPage cppLoginPage;
    CPPOwnerRegistrationPage cppOwnerRegistrationPage;
    CPPMainPage cppMainPage;

    LKMainPage lkMainPage;
    LKLoginPage lkLoginPage;
    LKVehiclesPage lkVehiclesPage;

    @Step("Открывает страницу {0} в ЦИПП")
    public void opensCPPPage(String page) {
        switch (page) {
            case "Авторизации":
                cppLoginPage.openAt("http://cpp-stage.progresspoint.ru/sign_in");
                break;
            case "Регистрации ВТС":
                cppMainPage.open();
                cppMainPage.clickOwnerRegistrationLink();
                break;
        }
    }

    @Step("Открывает страницу {0} в ЛК")
    public void opensLKPage(String page) {
        switch (page) {
            case "Авторизации":
                lkLoginPage.open();
                break;
            case "Главная":
                lkMainPage.loading();
                break;
            case "Транспортные средства":
                lkMainPage.loading();
                lkMainPage.clickToVehiclesItemMenu();
                break;
            case "Маршрутные карты":
                lkMainPage.loading();
                lkMainPage.clickToMapsItemMenu();
                break;
            case "Платежи":
                lkMainPage.loading();
                lkMainPage.clickToPaymentsItemMenu();
                break;
            case "Профиль":
                lkMainPage.loading();
                lkMainPage.clickToProfileItemMenu();
                break;
            case "Обращения":
                lkMainPage.loading();
                lkMainPage.clickToAppealsItemMenu();
                break;
        }
    }

    @Step("Находится на странице {0} в ЦИПП")
    public void isOnCPPPage(String page) {
        switch (page) {
            case "Авторизации":
                cppLoginPage.shouldBeDisplayed();
                break;
            case "Главная":
                cppMainPage.shouldBeDisplayed();
                break;
            case "Регистрации ВТС":
                cppOwnerRegistrationPage.shouldBeDisplayed();
                break;
        }
    }

    @Step("Находится на странице {0} в ЛК")
    public void isOnLKPage(String page) {
        switch (page) {
            case "Авторизации":
                lkLoginPage.shouldBeDisplayed();
                break;
            case "Главная":
                lkMainPage.shouldBeDisplayed();
                break;
            case "Транспортные средства":
                lkVehiclesPage.shouldBeDisplayed();
                break;
        }
    }

    @Step("Заголовок вкладки {0}")
    public void titleShouldBe(String title) {
        String currentTitle = getDriver().getTitle();
        assertThat(currentTitle)
                .overridingErrorMessage(format("Заголовок вкладки %s, а не %s", currentTitle, title))
                .isEqualToIgnoringCase(title);
    }

    @Step("Отображается сообщение {0}")
    public void messageShouldDisplayed(String message) {
        assertThat(getDriver().getPageSource())
                .overridingErrorMessage(format("Сообщение %s не отображается на странице", message))
                .contains(message);
    }

    public String getTitle() {
        return getDriver().getTitle();
    }
}
