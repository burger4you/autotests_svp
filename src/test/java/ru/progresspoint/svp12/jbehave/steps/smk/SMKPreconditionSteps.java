package ru.progresspoint.svp12.jbehave.steps.smk;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Шаги для приведения АРМа СМК в исходные состояния
 */
public class SMKPreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Given("диспетчер находится на странице $page в АРМ СМК")
    public void dispatcherIsOn(String page) {
        navigation.opensSMKPage(page);
    }
}
