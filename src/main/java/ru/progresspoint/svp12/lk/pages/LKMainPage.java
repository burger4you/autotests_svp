package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;

/**
 * Главная страница Личного Кабинета
 */
@At("#HOST")
public class LKMainPage extends PageObject {

    LKMainPageMenu menu;

    @FindBy(xpath = ".//*[@class='content dashboard']")
    WebElementFacade contentDashboard;

    @WhenPageOpens
    public void loading() {
        contentDashboard.shouldBeVisible();
    }

    public void clickToVehiclesItemMenu() {
        menu.clickToVehiclesItem();
    }

}
