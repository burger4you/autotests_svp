package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.Map;

import static net.thucydides.core.pages.components.HtmlTable.rowsFrom;

/**
 * Окно истории текущего обращения АРМа ЦИПП
 */
public class CPPAppealHistoryPopUp extends PageObject {

    @FindBy(xpath = ".//*[@id='ShowHistoryModal']//table[@class='standart NoJStable']")
    WebElementFacade appealHistoryTable;

    @FindBy(xpath = ".//*[@id='ShowHistoryModal']//i")
    WebElementFacade closePopUpButton;

    public List<Map<Object, String>> getAppealHistory() {
        return rowsFrom(appealHistoryTable);
    }

    public void clickToClosePopUpButton() {
        closePopUpButton.click();
    }
}