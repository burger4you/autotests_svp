package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница создания обращения в Личном Кабинете
 */
@At("#HOST/appeals/new")
public class LKNewAppealPage extends LKSelectizePageObject {

    final static String APPEAL_THEM_DROP_DOWN_ID = "itop_service_appeal_servicesubcategory_id";

    @FindBy(id = "itop_service_appeal_title")
    WebElementFacade appealTitleField;

    @FindBy(id = "itop_service_appeal_description")
    WebElementFacade appealTextField;

    public void setAppealTheme(String appealTheme) {
        selectForSelectizePlugin(APPEAL_THEM_DROP_DOWN_ID, appealTheme);
    }

    public void enterAppealTitle(String appealTitle) {
        enter(appealTitle).into(appealTitleField);
    }

    public void enterAppealText(String appealText) {
        enter(appealText).into(appealTextField);
    }
}