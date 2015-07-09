package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;

/**
 * Главная страница АРМа ЦИПП
 */
@At("#HOST")
public class CPPMainPage extends PageObject {

    @FindBy(xpath = ".//*[@href='/create_session']")
    WebElementFacade ownerRegistrationLink;

    @WhenPageOpens
    public void loading() {
        ownerRegistrationLink.shouldBeEnabled();
    }

    public void clickOwnerRegistrationLink() {
        ownerRegistrationLink.click();
    }
}
