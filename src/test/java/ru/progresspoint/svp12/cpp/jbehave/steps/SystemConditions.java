package ru.progresspoint.svp12.cpp.jbehave.steps;

import org.jbehave.core.annotations.Then;
import ru.progresspoint.svp12.cpp.pages.CreateNewOfferPage;
import ru.progresspoint.svp12.cpp.pages.LoginPage;

/**
 * Состояния системы, к которым она приходит в результате действий оператора
 */
public class SystemConditions {

    LoginPage loginPage;
    CreateNewOfferPage newOfferPage;

    @Then("открывается страница \"$page\"")
    public void pageShouldBeDisplayed(String page) {
        switch (page) {
            case "Авторизация"             : loginPage.shouldBeDisplayed(); break;
            case "Заключить новый договор" : newOfferPage.shouldBeDisplayed(); break;
        }
    }
}
