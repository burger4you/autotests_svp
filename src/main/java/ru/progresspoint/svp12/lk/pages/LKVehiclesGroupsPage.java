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
 * Страница Транспортные Средства - Группы в АРМ ЛК
 */
@At("#HOST/accounts/.*/vehicles")
public class LKVehiclesGroupsPage extends PageObject {

    @FindBy(id = "vehicle_groups")
    WebElementFacade vehiclesGroupsTable;

    public List<Map<Object, String>> getSearchVehiclesGroups() {
        return rowsFrom(vehiclesGroupsTable);
    }

    public void clickOnVehiclesGroup(BeanMatcher... matchers) {
        List<WebElement> matchingRows = filterRows(vehiclesGroupsTable, matchers);
        WebElement targetRow = matchingRows.get(0);
        targetRow.click();
    }
}
