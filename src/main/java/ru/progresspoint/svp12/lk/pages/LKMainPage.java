package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;

/**
 * Главная страница Личного Кабинета
 */
@At("#HOST")
public class LKMainPage extends PageObject {

    LKMainMenu mainMenu;

    @FindBy(xpath = ".//*[@class='content dashboard']")
    WebElementFacade contentDashboard;

    @FindBy(xpath = ".//*[text()='Баланс лицевого счета:']/span[@class='tab__value']")
    WebElementFacade accountBalanceField;

    @WhenPageOpens
    public void loading() {
        mainMenu.loading();
    }

    public String getsCurrentAccountBalance() {
        return accountBalanceField.getText();
    }
}
