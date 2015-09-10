package ru.progresspoint.svp12.tso.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Экран авторизации АРМа ТСО
 */
@At("#HOST/auth/")
public class TSOLoginPage extends TSOScreenObject {

    @FindBy(id = "grnz")
    WebElementFacade grnzField;

    @FindBy(id = "sts")
    WebElementFacade stsNumberField;

    @FindBy(id = "mobilePhone")
    WebElementFacade mobilePhoneField;

    public void enterGRNZ(String grnz) {
        switchToEnglishKeyboard();
        typeFromKeyboard(grnz, grnzField);
    }

    public void enterStsNumber(String stsNumber) {
        typeFromKeyboard(stsNumber, stsNumberField);
    }

    public void enterMobilePhone(String mobilePhone) {
        typeFromKeyboard(mobilePhone, mobilePhoneField);
    }


}
