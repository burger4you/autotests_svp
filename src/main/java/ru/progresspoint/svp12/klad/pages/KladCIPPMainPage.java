package ru.progresspoint.svp12.klad.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;

/**
 * Главная страница кладовщика ЦИППа АРМа Кладовщика
 */
@At("#HOST/device_requests")
public class KladCIPPMainPage extends PageObject {

    @FindBy(xpath = ".//h1[text()[contains(.,'sorry, but something went wrong')]]")
    WebElementFacade errorMessage;

    @WhenPageOpens
    public void loading() {
        errorMessage.shouldNotBePresent();
    }
}
