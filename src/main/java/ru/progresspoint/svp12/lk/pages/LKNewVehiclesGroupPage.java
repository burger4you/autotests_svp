package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

import java.util.List;

/**
 * Страница создания новой группы ТС в Личном Кабинете
 */
@At("#HOST/client_accounts/.*/vehicle_groups/new")
public class LKNewVehiclesGroupPage extends PageObject {

    LKMainPageMenu menu;

    @FindBy(id = "vehicle_group_name")
    WebElementFacade vehiclesGroupNameField;

    @FindBy(id = "vehicle_group_limit_amount")
    WebElementFacade vehiclesGroupLimitField;

    @FindBy(id = ".//*[@class='checkbox__field']")
    List<WebElementFacade> vehiclesCheckBoxes;

    @FindBy(id = "search-vehicle")
    WebElementFacade searchVehicleField;

    @FindBy(name = "commit")
    WebElementFacade confirmButton;

    public void checkForGroupRandomVehicles(int amountVehicles) {
        for (int i = 0; i < amountVehicles; i++)
            vehiclesCheckBoxes.get(i+1).click();
    }

    public void clickConfirmButton() {
        confirmButton.click();
    }










    public void enterVehiclesGroupName(String vehiclesGroupName) {
        enter(vehiclesGroupName).into(vehiclesGroupNameField);
    }
}
