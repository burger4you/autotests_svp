package ru.progresspoint.svp12.lk.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Главная страница Личного Кабинета
 */
@DefaultUrl("http://lk-stage.progresspoint.ru")
public class LKMainPage extends PageObject {

    @FindBy(xpath = ".//*[@class='content dashboard']")
    WebElementFacade contentDashboard;

    @FindBy(xpath = ".//*[text()='Баланс лицевого счета:']/span[@class='tab__value']")
    WebElementFacade accountBalanceField;

    public String getsCurrentAccountBalance() {
        return accountBalanceField.getText();
    }
}
