package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import org.openqa.selenium.By;

/**
 * Главная страница АРМа ЦИПП
 */
@At("#HOST")
public class CPPMainPage extends PageObject {

    @FindBy(xpath = ".//*[@class='mca-one']")
    WebElementFacade selectActionDialog;

    public void loading() {
        if(isElementVisible(By.xpath(".//*[text()='Завершить']"))) {
            clickOn(element(".//*[text()='Завершить']"));
            waitForTextToDisappear("Завершить");
        }
        selectActionDialog.expect("Не доступно диалоговое окно Выберите действие").shouldBePresent();
    }
}
