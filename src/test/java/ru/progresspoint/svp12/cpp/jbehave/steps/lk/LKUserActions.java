package ru.progresspoint.svp12.cpp.jbehave.steps.lk;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.lk.steps.LKUserSteps;

/**
 * Действия пользователя в Личном кабинете
 */
public class LKUserActions {

    @Steps
    LKUserSteps user;

    @When("пользователь регистрирует себя как $clientType ($clientEmail)")
    public void userSetTypeAndResidenceOfClient(String clientType, String clientEmail) {
        user.clicksToLink("Зарегистрироваться");
        user.entersAccountData(clientEmail);
        user.selectsOwnerType(clientType);
        user.selectsOwnerCountry("Российская Федерация");
        user.entersCaptcha("captcha");
        user.clicksToConfirmButton();
        user.entersOwnerData(clientEmail);
        user.clicksToConfirmButton();
//        user.uploadsOwnerDocumentsCopies("Скан-копии документов ВТС");
        user.entersVehicleData();
        user.uploadsVehicleDocumentsCopies();
        user.clicksToConfirmButton();
    }

    @When("пользователь вводит логин $login и пароль $password для авторизации в ЛК")
    public void userEntersLoginAndPassword(String login, String password) {
        user.entersLoginAndPassword(login, password);
        user.clicksToConfirmButton();
    }

    @When("пользователь объеденит $amountVehicles своих ТС в группу $groupName")
    public void userChooseVehiclesForGroup(int amountVehicles, String groupName) {
        user.clicksToLink("Список групп ТС");
        user.clicksToLink("Создать новую группу");
        user.entersNameForNewGroupVehicles(groupName);
        user.selectsVehiclesForGroup(amountVehicles);
        user.clicksToConfirmButton();
    }

    @When("он отфильтрует выписку операций с $startDate по $endDate")
    public void userSetsTransactionsPeriod(String startDate, String endDate) {
        user.clicksToLink("Выписка операций по счету");
        user.entersPeriodTransactionsDates(startDate, endDate);
    }

    @When("он пополнит счет на $fundsAmount рублей")
    public void userAddsFundsInAccount(String fundsAmount) {
        user.clicksToLink("Пополнить лицевой счет");
        user.entersFundsAmount(fundsAmount);
        user.clicksToConfirmButton();
        user.entersCardDataAndPay("123");
    }

    @When("он создаст обращение $title в рзаделе $theme с текстом $text")
    public void userCreatesNewAppeal(String title, String theme, String text) {
        user.clicksToLink("Подать новое обращение");
        user.entersAppealDetails(title, theme, text);
    }

//    @When("он создаст обращение <title> в рзаделе <theme> с текстом <text> и прикрепит файл <filename>")
//    public void userCreatesNewAppealWithUploadedFile(String title, String theme, String text, String filename) {
//        user.clicksToCreateNewAppealButton();
//        user.entersAppealDetails(title, theme, text);
//        user.clicksToUploadNewFileButtonAndUploadFile(filename);
//        user.clicksToSendAppealButton();
//    }
}