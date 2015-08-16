package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.thucydides.core.pages.components.HtmlTable.filterRows;

/**
 * Страница создания новой группы ТС в Личном Кабинете
 */
@At("#HOST/client_accounts/.*/vehicle_groups/new")
public class LKNewVehiclesGroupPage extends LKSelectizePageObject {

    LKMainMenu menu;

    @FindBy(id = "vehicle_group_name")
    WebElementFacade vehiclesGroupNameField;

    @FindBy(id = "vehicle_group_limit_amount")
    WebElementFacade vehiclesGroupLimitField;

    private static final String vehiclesGroupManagerField = "select_manager";

    @FindBy(xpath = "//*[@id='vehicles']/div/div/table")
    WebElement vehiclesTable;

    @FindBy(id = "search-vehicle")
    WebElementFacade searchVehicleField;

    public List<WebElement> getAllVehicles() {
        return filterRows(vehiclesTable);
    }

    public void enterVehiclesGroupName(String vehiclesGroupName) {
        enter(vehiclesGroupName).into(vehiclesGroupNameField);
    }

    public void enterVehiclesGroupLimit(String groupLimit) {
        enter(groupLimit).into(vehiclesGroupLimitField);
    }

    public void selectVehiclesGroupManager(String groupManager) {
        selectForSelectizePlugin(vehiclesGroupManagerField, groupManager);
    }
}
