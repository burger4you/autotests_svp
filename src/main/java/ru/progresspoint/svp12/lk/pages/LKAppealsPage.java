package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.matchers.BeanMatcher;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static net.thucydides.core.pages.components.HtmlTable.filterRows;
import static net.thucydides.core.pages.components.HtmlTable.rowsFrom;

/**
 * Страница обращений в АРМ ЛК
 */
@At("#HOST/appeals")
public class LKAppealsPage extends PageObject {

    @FindBy(xpath = ".//*[@class='b-table b-table_full']")
    WebElementFacade appealsTable;

    WebElementFacade startAppealsDateField;

    WebElementFacade endAppealsDateField;

    public void enterStartAppealsDate(String startDate) {
        enter(startDate).into(startAppealsDateField);
    }

    public void enterEndAppealsDate(String endDate) {
        enter(endDate).into(endAppealsDateField);
    }

    public List<Map<Object, String>> getSearchAppeals() {
        return rowsFrom(appealsTable);
    }

    public void clickOnAppeal(BeanMatcher... matchers) {
        List<WebElement> matchingRows = filterRows(appealsTable, matchers);
        WebElement targetRow = matchingRows.get(0);
        targetRow.click();
    }
}