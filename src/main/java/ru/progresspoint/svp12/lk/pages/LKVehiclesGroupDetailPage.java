package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/**
 * Страница открытой группы ТС в АРМ ЛК
 */
@At("#HOST/accounts/.*/vehicle_groups/.*")
public class LKVehiclesGroupDetailPage extends PageObject {

    @FindBy(xpath = ".//*[@class='headline__title']")
    WebElementFacade vehiclesGroupNameField;

    @FindBy(xpath = ".//*[text()[contains(.,'Лимит расходов в месяц')]]/../p")
    WebElementFacade vehiclesGroupLimitField;

    @FindBy(xpath = ".//*[text()[contains(.,'Менеджер группы')]]/../p")
    WebElementFacade vehiclesGroupManagerField;

    public String getVehiclesGroupName() {
        return vehiclesGroupNameField.getText();
    }

    public String getVehiclesGroupLimit() {
        return vehiclesGroupLimitField.getText();
    }

    public String getVehiclesGroupManager() {
        return vehiclesGroupManagerField.getText();
    }
}