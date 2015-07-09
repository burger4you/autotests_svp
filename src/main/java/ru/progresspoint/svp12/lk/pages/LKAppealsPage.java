package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;

/**
 * Страница обращений в Личном Кабинете
 */
@At("#HOST/appeals")
public class LKAppealsPage extends PageObject {

    @FindBy(xpath = ".//*[@href='/appeals/new']")
    WebElementFacade createAppealLink;

    @WhenPageOpens
    public void loading() {
        createAppealLink.shouldBeEnabled();
    }

    public void clickToCreateAppealLink() {
        createAppealLink.click();
    }
}