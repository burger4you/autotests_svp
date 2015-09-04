package ru.progresspoint.svp12.tso.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Главный экран АРМа ТСО
 */
@At("#HOST")
public class TSOMainPage extends PageObject {

    @FindBy (xpath = ".//*[@href='/auth/countries/']")
    WebElementFacade startButton;

    @FindBy (xpath = ".//*[@href='logic/info/']")
    WebElementFacade infoButton;

}
