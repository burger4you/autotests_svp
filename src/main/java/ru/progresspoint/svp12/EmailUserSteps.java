package ru.progresspoint.svp12;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Шаги пользователя системы ПО СВП при работе с электронной почтой
 */
public class EmailUserSteps extends ScenarioSteps {

    @Step("Получает письмо с уведомлением о результатах верификации владельца ТС")
    public void waitForEmailWithVerification() {
    }

    @Step("Нажимает на ссылку подтверждения в письме")
    public void clickToLoginLink() {
    }

    @Step("Получает письмо с историей подачи и обработки всех обращений данного пользователя")
    public void waitForEmailWithVAppealsHistory() {
    }
}