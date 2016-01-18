package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница создания обращения в АРМ ЛК
 */
@At("#HOST/appeals/new")
public class LKNewAppealPage extends PageObject {

    @FindBy(id = "itop_service_appeal_title")
    WebElementFacade appealTitleField;

    @FindBy(id = "itop_service_appeal_description")
    WebElementFacade appealTextField;

    @FindBy(id = "itop_service_appeal_attachments")
    WebElementFacade appealAdditionalDocument;

    public void enterAppealTitle(String appealTitle) {
        enter(appealTitle).into(appealTitleField);
    }

    public void enterAppealText(String appealText) {
        enter(appealText).into(appealTextField);
    }

    public void uploadAdditionalDocument(String fileName) {
        // Меняем атрибут display у инпута, для возможности загружать файлы
        evaluateJavascript("document.getElementById('itop_service_appeal_attachments').setAttribute('Style','display:block');");
        upload(fileName).to(appealAdditionalDocument);
    }
}