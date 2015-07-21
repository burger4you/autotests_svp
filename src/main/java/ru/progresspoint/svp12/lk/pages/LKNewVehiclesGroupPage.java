package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static net.thucydides.core.pages.components.HtmlTable.filterRows;
import static net.thucydides.core.pages.components.HtmlTable.rowsFrom;

/**
 * Страница создания новой группы ТС в Личном Кабинете
 */
@At("#HOST/client_accounts/.*/vehicle_groups/new")
public class LKNewVehiclesGroupPage extends PageObject {

    LKMainMenu menu;

    @FindBy(id = "vehicle_group_name")
    WebElementFacade vehiclesGroupNameField;

    @FindBy(id = "vehicle_group_limit_amount")
    WebElementFacade vehiclesGroupLimitField;

    @FindBy(xpath = "//*[@id='vehicles']/div/div/table")
    WebElement vehiclesTable;

    @FindBy(id = "search-vehicle")
    WebElementFacade searchVehicleField;

    @FindBy(name = "commit")
    WebElementFacade confirmButton;

    public List<Map<Object, String>> getSearchVehicles() {
        return rowsFrom(vehiclesTable);
    }

    public void setForAddToGroupVehicle(int orderNumber) {
        List<WebElement> matchingVehicles = filterRows(vehiclesTable);
        WebElement targetVehicle = matchingVehicles.get(orderNumber);
        WebElement addToGroupCheckBox = targetVehicle.findElement(By.xpath(".//i[@class,'checkbox__field')]"));
        addToGroupCheckBox.click();
    }

    public void clickConfirmButton() {
        confirmButton.click();
    }

    public void enterVehiclesGroupName(String vehiclesGroupName) {
        enter(vehiclesGroupName).into(vehiclesGroupNameField);
    }
}
