package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Меню на главной странице Личного Кабинета
 */
public class LKMainPageMenu extends PageObject {

    @FindBy(linkText = "Транспортные средства")
    WebElementFacade vehiclesItem;

   public void clickToVehiclesItem() {
       vehiclesItem.click();
   }
}
