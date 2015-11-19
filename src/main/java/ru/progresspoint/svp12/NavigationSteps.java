package ru.progresspoint.svp12;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import ru.progresspoint.svp12.admin.pages.AdminLoginPage;
import ru.progresspoint.svp12.admin.pages.AdminMainPage;
import ru.progresspoint.svp12.call_centre.pages.CallCentreLoginPage;
import ru.progresspoint.svp12.call_centre.pages.CallCentreMainPage;
import ru.progresspoint.svp12.cpp.pages.*;
import ru.progresspoint.svp12.dz.pages.DZLoginPage;
import ru.progresspoint.svp12.dz.pages.DZMainPage;
import ru.progresspoint.svp12.klad.pages.KladLoginPage;
import ru.progresspoint.svp12.klad.pages.KladMainPage;
import ru.progresspoint.svp12.lk.pages.*;
import ru.progresspoint.svp12.rso.pages.RSOLoginPage;
import ru.progresspoint.svp12.rso.pages.RSOMainPage;
import ru.progresspoint.svp12.treasury.pages.TreasuryLoginPage;
import ru.progresspoint.svp12.treasury.pages.TreasuryMainPage;
import ru.progresspoint.svp12.tso.pages.TSOCabinetPage;
import ru.progresspoint.svp12.tso.pages.TSOInfoPage;
import ru.progresspoint.svp12.tso.pages.TSOStartPage;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.name;

/**
 * Шаги навигации по всей системе ПО СВП
 */
public class NavigationSteps extends ScenarioSteps {

    CPPLoginPage cppLoginPage;
    CPPClientRegistrationPage cppOwnerRegistrationPage;
    CPPMainPage cppMainPage;
    CPPMainMenu cppMainMenu;
    CPPSelectActionDialog cppSelectActionDialog;
    CPPAccountsBalancePage cppAccountsBalancePage;
    CPPDevicesInfoPage cppDevicesInfoPage;
    CPPRoutMapsInfoPage cppRoutMapsInfoPage;
    CPPWikiSearchPage cppWikiSearchPage;
    CPPRegistrationInfoPage cppRegistrationInfoPage;

    LKMainMenu lkMainMenu;
    LKLoginPage lkLoginPage;
    LKVehiclesPage lkVehiclesPage;
    LKMainHeader lkMainHeader;

    KladLoginPage kladLoginPage;
    KladMainPage kladMainPage;

    DZLoginPage dzLoginPage;
    DZMainPage dzMainPage;

    AdminLoginPage adminLoginPage;
    AdminMainPage adminMainPage;

    CallCentreMainPage callCentreMainPage;
    CallCentreLoginPage callCentreLoginPage;

    TSOStartPage tsoStartPage;
    TSOCabinetPage tsoCabinetPage;
    TSOInfoPage tsoInfoPage;

    TreasuryLoginPage treasuryLoginPage;
    TreasuryMainPage treasuryMainPage;

    RSOLoginPage rsoLoginPage;
    RSOMainPage rsoMainPage;

    @Step("Открывает страницу {0} АРМа РСО")
    public void opensRSOPage(String page) {
        switch (page) {
            case "Авторизации":
                getDriver().get("http://svp-www1-arm-rso.svp.test/sign_out");
                rsoLoginPage.shouldBeDisplayed();
                break;
            case "Главная":
                openBaseRSOUrl();
                break;
        }
    }

    private void openBaseRSOUrl() {
        getDriver().get("http://svp-www1-arm-rso.svp.test");
        if (getCurrentURL().endsWith("sign_in")) {
            rsoLoginPage.enterLogin("Admin3");
            rsoLoginPage.enterPassword("Test123$");
            getDriver().findElement(name("commit")).click();
        }
    }

    @Step("Открывает страницу {0} АРМа Казначейства")
    public void opensTreasuryPage(String page) {
        switch (page) {
            case "Авторизации":
                getDriver().get("http://svp-www1-arm-treasury.svp.test/sign_out");
                treasuryLoginPage.shouldBeDisplayed();
                break;
            case "Главная":
                openBaseTreasuryUrl();
                break;
        }
    }

    private void openBaseTreasuryUrl() {
        getDriver().get("http://svp-www1-arm-treasury.svp.test");
        if (getCurrentURL().endsWith("sign_in")) {
            treasuryLoginPage.enterLogin("Admin3");
            treasuryLoginPage.enterPassword("Test123$");
            getDriver().findElement(name("commit")).click();
        }
    }

    @Step("Открывает стартовую страницу АРМа ТСО")
    public void opensTSOStartPage() {
        tsoStartPage.openAt("http://svp-www-tco.svp.test");
    }

    @Step("Открывает страницу {0} АРМа Колл Центра")
    public void opensCallCenterPage(String page) {
        switch (page) {
            case "Авторизации":
                getDriver().get("http://svp-www-callcenter.svp.test/sign_out");
                callCentreLoginPage.shouldBeDisplayed();
                break;
            case "Главная":
                callCentreMainPage.openAt("http://svp-www-callcenter.svp.test");
                break;
        }
    }

    @Step("Открывает страницу {0} АРМа Администратора")
    public void opensAdminPage(String page) {
        switch (page) {
            case "Авторизации":
                getDriver().get("http://svp-www1-arm-administrator.svp.test/sign_out");
                adminLoginPage.shouldBeDisplayed();
                break;
            case "Главная":
                openBaseAdminUrl();
                break;
        }
    }

    private void openBaseAdminUrl() {
        getDriver().get("http://svp-www1-arm-administrator.svp.test");
        if (getCurrentURL().endsWith("sign_in")) {
            adminLoginPage.enterLogin("Admin3");
            adminLoginPage.enterPassword("Test123$");
            getDriver().findElement(name("commit")).click();
        }
    }

    @Step("Открывает страницу {0} АРМа ДЗ")
    public void opensDZPage(String page) {
        switch (page) {
            case "Авторизации":
                getDriver().get("http://svp-www1-arm-dz.svp.test/sign_out");
                dzLoginPage.shouldBeDisplayed();
                break;
            case "Главная":
                openBaseDZUrl();
                break;
        }
    }

    private void openBaseDZUrl() {
        getDriver().get("http://svp-www1-arm-dz.svp.test");
        if (getCurrentURL().endsWith("sign_in")) {
            dzLoginPage.enterLogin("Admin3");
            dzLoginPage.enterPassword("Test123$");
            getDriver().findElement(name("commit")).click();
        }
    }

    @Step("Открывает страницу {0} АРМа Кладовщика")
    public void opensKladPage(String page) {
        switch (page) {
            case "Авторизации":
                getDriver().get("http://svp-www1-arm-warehouse.svp.test/sign_out");
                kladLoginPage.shouldBeDisplayed();
                break;
            case "Главная":
                openBaseKladUrl();
                break;
        }
    }

    private void openBaseKladUrl() {
        getDriver().get("http://svp-www1-arm-warehouse.svp.test");
        if (getCurrentURL().endsWith("sign_in")) {
            kladLoginPage.enterLogin("Admin3");
            kladLoginPage.enterPassword("Test123$");
            getDriver().findElement(name("commit")).click();
        }
    }

    @Step("Открывает страницу {0} АРМа ЦИПП")
    public void opensCPPPage(String page) {
        switch (page) {
            case "Авторизации":
                getDriver().get("http://10.0.12.236/sign_out");
                cppLoginPage.shouldBeDisplayed();
                break;
            case "Выбора действия":
                openBaseCPPUrl();
                cppMainPage.loading();
                break;
            case "Регистрации ВТС":
                openBaseCPPUrl();
                cppMainPage.loading();
                cppSelectActionDialog.clickToOwnerRegistrationLink();
                break;
            case "Расчеты":
                openBaseCPPUrl();
                cppMainMenu.clickToPaymentsTab();
                break;
            case "Бортовые устройства":
                openBaseCPPUrl();
                cppMainMenu.clickToDevicesTab();
                break;
            case "Маршрутные карты":
                openBaseCPPUrl();
                cppMainMenu.clickToRouteMapsTab();
                break;
            case "Общие сведения":
                openBaseCPPUrl();
                cppMainMenu.clickToWikiTab();
                break;
            case "Регистрация":
                openBaseCPPUrl();
                cppMainMenu.clickToRegistrationTab();
                break;
            case "Обратная связь":
                openBaseCPPUrl();
                cppMainMenu.clickToAppealsTab();
                break;
        }
    }

    private void openBaseCPPUrl() {
        getDriver().get("http://10.0.12.236");
        if (getCurrentURL().endsWith("sign_in")) {
            cppLoginPage.enterLogin("operator_vitya");
            cppLoginPage.enterPassword("1qaz@WSX");
            getDriver().findElement(name("commit")).click();
        }
    }

    @Step("Открывает страницу {0} АРМа ЛК")
    public void opensLKPage(String page) {
        switch (page) {
            case "Авторизации":
                getDriver().get("http://svp-www-lk.svp.test/sign_out");
                lkLoginPage.shouldBeDisplayed();
                break;
            case "Транспортные средства":
                openBaseLKUrl();
                lkMainMenu.clickToVehiclesItem();
                break;
            case "Маршрутные карты":
                openBaseLKUrl();
                lkMainMenu.clickToRouteMapsItem();
                break;
            case "Платежи":
                openBaseLKUrl();
                lkMainMenu.clickToPaymentsItem();
                break;
            case "Профиль":
                openBaseLKUrl();
                lkMainMenu.clickToProfileItem();
                break;
            case "Обращения":
                openBaseLKUrl();
                lkMainMenu.clickToAppealsItem();
                break;
        }
    }

    private void openBaseLKUrl() {
        getDriver().get("http://svp-www-lk.svp.test");
        if (getCurrentURL().endsWith("sign_in")) {
            lkLoginPage.enterLogin("iptestowner+ip008@gmail.com");
            lkLoginPage.enterPassword("!QAZ2wsx");
            getDriver().findElement(name("commit")).click();
        }
        lkMainMenu.loading();
    }

    @Step("Находится на странице {0} АРМа РСО")
    public void isOnRSOPage(String page) {
        switch (page) {
            case "Авторизации":
                rsoLoginPage.shouldBeDisplayed();
                break;
            case "Главная":
                rsoMainPage.shouldBeDisplayed();
                break;
        }
    }

    @Step("Находится на странице {0} АРМа Казначейства")
    public void isOnTreasuryPage(String page) {
        switch (page) {
            case "Авторизации":
                treasuryLoginPage.shouldBeDisplayed();
                break;
            case "Главная":
                treasuryMainPage.shouldBeDisplayed();
                break;
        }
    }

    @Step("Находится на странице {0} АРМа ТСО")
    public void isOnTSOPage(String page) {
        switch (page) {
            case "личного кабинета":
                tsoCabinetPage.shouldBeDisplayed();
                break;
            case "информации о системе":
                tsoInfoPage.shouldBeDisplayed();
                break;
        }
    }

    @Step("Находится на странице {0} АРМа Колл Центра")
    public void isOnCallCentrePage(String page) {
        switch (page) {
            case "Авторизации":
                callCentreLoginPage.shouldBeDisplayed();
                break;
            case "Главная":
                callCentreMainPage.shouldBeDisplayed();
                break;
        }
    }

    @Step("Находится на странице {0} АРМа Администратора")
    public void isOnAdminPage(String page) {
        switch (page) {
            case "Авторизации":
                adminLoginPage.shouldBeDisplayed();
                break;
            case "Главная":
                adminMainPage.shouldBeDisplayed();
                break;
        }
    }

    @Step("Находится на странице {0} АРМа ДЗ")
    public void isOnDZPage(String page) {
        switch (page) {
            case "Авторизации":
                dzLoginPage.shouldBeDisplayed();
                break;
            case "Главная":
                dzMainPage.shouldBeDisplayed();
                break;
        }
    }

    @Step("Находится на странице {0} АРМа Кладовщика")
    public void isOnKladPage(String page) {
        switch (page) {
            case "Авторизации":
                kladLoginPage.shouldBeDisplayed();
                break;
            case "Главная":
                kladMainPage.shouldBeDisplayed();
                break;
        }
    }

    @Step("Находится на странице {0} АРМа ЦИПП")
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
            case "Баланс ЛС":
                cppAccountsBalancePage.shouldBeDisplayed();
                break;
            case "Информация о БУ ВТС":
                cppDevicesInfoPage.shouldBeDisplayed();
                break;
            case "Информация о МК ВТС":
                cppRoutMapsInfoPage.shouldBeDisplayed();
                break;
            case "Поиск по базе знаний":
                cppWikiSearchPage.shouldBeDisplayed();
                break;
            case "Информация о ВТС":
                cppRegistrationInfoPage.shouldBeDisplayed();
                break;
        }
    }

    @Step("Находится на странице {0} АРМа ЛК")
    public void isOnLKPage(String page) {
        switch (page) {
            case "Авторизации":
                lkLoginPage.shouldBeDisplayed();
                break;
            case "Транспортные средства":
                lkVehiclesPage.shouldBeDisplayed();
                break;
        }
    }

    @Step("Нажимает на кнопку Ок в окне подтверждения")
    public void clicksToOkInConfirmationPopUp(String message) {
        getDriver().findElement(By.xpath(String.format("//h2[.='%s']", message)));
        waitABit(1000);
        getDriver().findElement(By.xpath(".//*[@class='b-link__icon svp svp-ok']")).click();
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
