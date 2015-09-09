package ru.progresspoint.svp12.tso.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Экран авторизации АРМа ТСО
 */
@At("#HOST/auth/")
public class TSOLoginPage extends PageObject {

    @FindBy (id = "grnz")
    WebElementFacade grnzField;

    @FindBy (id = "sts")
    WebElementFacade stsNumberField;

    @FindBy (id = "sts_date")
    WebElementFacade stsDateField;

    public void enterGRNZ(String grnz) {
        enter(grnz).into(grnzField);
    }

    public void enterStsNumber(String stsNumber) {
        enter(stsNumber).into(stsNumberField);
    }

    public void enterStsDate(String stsDate) {
        enter(stsDate).into(stsDateField);
    }
}
