package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import org.openqa.selenium.By;

/**
 * Главная страница АРМа ЦИПП с диалоговым окном выбора действия
 */
@At("#HOST")
public class CPPMainPage extends PageObject {

    @FindBy(xpath = ".//h1[text()[contains(.,'sorry, but something went wrong')]]")
    WebElementFacade errorMessage;

    @FindBy(xpath = ".//*[@class='mca-one']")
    WebElementFacade selectActionDialog;

    public void loading() {
        errorMessage.expect("Простите, но что-то пошло не так...").shouldNotBePresent();
        if (isElementVisible(By.xpath(".//*[@id='end_button']"))) {
            clickOn(element(".//*[@id='end_button']"));
            waitFor(selectActionDialog);
        }
        selectActionDialog.expect("Не доступно диалоговое окно Выберите действие").shouldBePresent();
    }
}