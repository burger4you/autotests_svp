package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница открытого обращения в Личном Кабинете
 */
@At("#HOST/appeals/.*")
public class LKAppealDetailPage extends PageObject {

    @FindBy(xpath = ".//h2")
    WebElementFacade appealTitleField;

    @FindBy(xpath = ".//*[@class='b-text']")
    WebElementFacade appealTextField;

    @FindBy(xpath = ".//*[@class='file__title']")
    WebElementFacade appealFileField;

    public String getAppealTitle() {
        return appealTitleField.getText();
    }

    public String getAppealText() {
        return appealTextField.getText();
    }

    public String getAppealAdditionalFileName() {
        return appealFileField.getText();
    }
}