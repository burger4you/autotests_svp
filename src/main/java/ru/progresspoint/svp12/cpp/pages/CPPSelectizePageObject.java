package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

/**
 * Класс расширяющий PageObject для работы с плагином selectize
 */
public class CPPSelectizePageObject extends PageObject {

    static final String DROP_DOWN_XPATH = ".//*[@id='%s']/..//input";
    static final String DROP_DOWN_ITEM_XPATH = ".//*[@class='selectize-dropdown-content']/*[text()[contains(.,'%s')]]";

    static final String INPUT_XPATH = ".//*[@id='%s']/..//*[@class='selectize-input items not-full']/input";
    static final String INPUT_ITEM_XPATH = ".//*[@id='%s']/..//div[@class='selectize-dropdown-content']/div[1]";

    public void selectForSelectizePlugin(String selectId, String selectingValue) {
        findBy(String.format(DROP_DOWN_XPATH, selectId)).click();
        waitFor(String.format(DROP_DOWN_ITEM_XPATH, selectingValue));
        findBy(String.format(DROP_DOWN_ITEM_XPATH, selectingValue)).click();
    }

    public void enterForSelectizePlugin(String inputId, String inputtingValue) {
        enter(inputtingValue).into(findBy(String.format(INPUT_XPATH, inputId)));
        waitABit(3000);
//        waitForAnyRenderedElementOf(By.xpath(String.format(INPUT_ITEM_XPATH, inputId)));
//        waitFor(String.format(INPUT_ITEM_XPATH, inputId));
//        findBy(String.format(INPUT_ITEM_XPATH, inputId)).click();
        clickOnInvisibleElement(findBy(String.format(INPUT_ITEM_XPATH, inputId)));
    }

    public void clickOnInvisibleElement(WebElement element) {

        String script = "var object = arguments[0];"
                + "var theEvent = document.createEvent(\"MouseEvent\");"
                + "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "object.dispatchEvent(theEvent);"
                ;
        getJavascriptExecutorFacade().executeScript(script, element);
    }
}
