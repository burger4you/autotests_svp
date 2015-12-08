package ru.progresspoint.svp12.ckn.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;

/**
 * Главная страница АРМа ЦКН
 */
@At("#HOST/vehicles/operator")
public class CKNMainPage extends PageObject {
    @WhenPageOpens
    public void loading() {
        $(".//h1[text()=\"We're sorry, but something went wrong.\"]").shouldNotBeCurrentlyVisible();
    }
}