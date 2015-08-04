package ru.progresspoint.svp12;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import ru.progresspoint.svp12.cpp.pages.CPPLoginPage;
import ru.progresspoint.svp12.cpp.pages.CPPMainPage;
import ru.progresspoint.svp12.cpp.pages.CPPOwnerRegistrationPage;
import ru.progresspoint.svp12.lk.pages.*;

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
    LKMainMenu lkMainMenu;
    LKLoginPage lkLoginPage;
    LKVehiclesPage lkVehiclesPage;
    LKMainHeader lkMainHeader;

    @Step("Открывает страницу {0} в ЦИПП")
    public void opensCPPPage(String page) {
        switch (page) {
            case "Авторизации":
                cppLoginPage.openAt("http://cpp-stage.progresspoint.ru/sign_in");
                break;
            case "Главная":
                cppMainPage.openAt("http://cpp-stage.progresspoint.ru");
                break;
            case "Регистрации ВТС":
                cppMainPage.loading();
                cppMainPage.clickOwnerRegistrationLink();
                break;
        }
    }

    @Step("Открывает страницу {0} в ЛК")
    public void opensLKPage(String page) {
        switch (page) {
            case "Авторизации":
                lkLoginPage.openAt("http://lk-stage.progresspoint.ru/sign_in");
                break;
            case "Главная":
                lkMainPage.openAt("http://lk-stage.progresspoint.ru");
                break;
            case "Транспортные средства":
                lkMainMenu.loading();
                lkMainMenu.clickToVehiclesItem();
                break;
            case "Маршрутные карты":
                lkMainMenu.loading();
                lkMainMenu.clickToRouteMapsItem();
                break;
            case "Платежи":
                lkMainMenu.loading();
                lkMainMenu.clickToPaymentsItem();
                break;
            case "Профиль":
                lkMainMenu.loading();
                lkMainMenu.clickToProfileItem();
                break;
            case "Обращения":
                lkMainMenu.loading();
                lkMainMenu.clickToAppealsItem();
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

    @Step("Устанавливается размер окна браузера {0}х{1}")
    public void setBrowserSizeOn(int width, int height) {
        getDriver().manage().window().setSize(new Dimension(width, height));
    }

    @Step("Отображается заголовок страницы {0}")
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

    @Step("Отображается {0} уведомлений")
    public void notificationCounterShouldDisplayed(String notificationsCounter) {
        String currentNotificationsCounter = lkMainHeader.getNotificationsCounter();
        assertThat(currentNotificationsCounter)
                .overridingErrorMessage(format("В шапке отображается %s уведомлений, а не %s", currentNotificationsCounter, notificationsCounter))
                .isEqualTo(notificationsCounter);
    }

    @Step("Устанавливается {0} язык интерфейса")
    public void setInterfaceLanguage(String language) {
        getDriver().findElement(By.id(""));
    }

    public String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }

    public String getTitle() {
        return getDriver().getTitle();
    }
}
