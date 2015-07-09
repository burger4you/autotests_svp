package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница создания обращения в Личном Кабинете
 */
@At("#HOST/appeals/new")
public class LKNewAppealPage extends PageObject {

    static final String DROP_DOWN_XPATH = ".//*[@id='%s']/..//*[@class='item']";
    static final String DROP_DOWN_ITEM_XPATH = ".//*[@class='selectize-dropdown-content']/*[text()='%s']";

    String appealThemeDropDown = "itop_service_appeal_servicesubcategory_id";

    @FindBy(id = "itop_service_appeal_title")
    WebElementFacade appealTitleField;

    @FindBy(id = "itop_service_appeal_description")
    WebElementFacade appealTextField;

    @FindBy(name = "commit")
    WebElementFacade confirmButton;

    public void selectAppealTheme(String appealTheme) {
        selectForSelectizePlugin(appealThemeDropDown, appealTheme);
    }

    public void enterAppealTitle(String appealTitle) {
        enter(appealTitle).into(appealTitleField);
    }

    public void enterAppealText(String appealText) {
        enter(appealText).into(appealTextField);
    }

    public void clickConfirmButton() {
        confirmButton.click();
    }

    private void selectForSelectizePlugin(String selectId, String selectingValue) {
        findBy(String.format(DROP_DOWN_XPATH, selectId)).click();
        waitFor(String.format(DROP_DOWN_ITEM_XPATH, selectingValue));
        findBy(String.format(DROP_DOWN_ITEM_XPATH, selectingValue)).click();
    }
}