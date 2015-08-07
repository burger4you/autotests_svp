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
 * Страница Транспортные Средства - Список в личном кабинете
 */
@At("#HOST/accounts/.*/vehicles")
public class LKVehiclesPage extends PageObject {

    @FindBy(xpath = "//*[@id='vehicles']/table")
    WebElementFacade vehiclesTable;

    public List<Map<Object, String>> getSearchVehicles() {
        return rowsFrom(vehiclesTable);
    }

    public void clickOnVehicle(BeanMatcher... matchers) {
        List<WebElement> matchingRows = filterRows(vehiclesTable, matchers);
        WebElement targetRow = matchingRows.get(0);
        targetRow.click();
    }
}
