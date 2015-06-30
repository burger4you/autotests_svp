package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница Транспортные Средства Личного Кабинета
 */
@At("#HOST/client_accounts/.*/vehicles")
public class LKVehiclesPage extends PageObject {

    LKMainPageMenu menu;

    @FindBy(linkText = "Список групп ТС")
    WebElementFacade VehiclesGroupsLink;

    public void clickToVehiclesGroupsLink() {
        VehiclesGroupsLink.click();
    }
}
