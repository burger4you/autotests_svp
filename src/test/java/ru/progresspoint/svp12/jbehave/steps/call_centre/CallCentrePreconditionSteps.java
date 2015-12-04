package ru.progresspoint.svp12.jbehave.steps.call_centre;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import ru.progresspoint.svp12.NavigationSteps;

/**
 * Шаги для приведения АРМа Колл Центра в исходные состояния
 */
public class CallCentrePreconditionSteps {

    @Steps
    NavigationSteps navigation;

    @Given("руководитель группы поддержки находится на странице $page в АРМ Колл Центра")
    @Aliases(values={"оператор 1-ой линии находится на странице $page в АРМ Колл Центра",
                     "оператор 2-ой линии находится на странице $page в АРМ Колл Центра",
                     "куратор находится на странице $page в АРМ Колл Центра"})
    public void userIsOn(String page) {
        navigation.opensCallCenterPage(page);
    }
}