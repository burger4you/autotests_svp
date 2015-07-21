package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница Транспортные Средства Личного Кабинета
 */
@At("#HOST/client_accounts/.*/vehicles")
public class LKVehiclesGroupPage extends PageObject {

    LKMainMenu menu;

    @FindBy(linkText = "Добавить группу")
    WebElementFacade newVehiclesGroupLink;

    public void clickToNewVehiclesGroupLink() {
        newVehiclesGroupLink.click();
    }
}
