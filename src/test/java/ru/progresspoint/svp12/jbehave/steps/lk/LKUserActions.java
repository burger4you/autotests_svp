package ru.progresspoint.svp12.jbehave.steps.lk;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.lk.steps.LKUserSteps;

/**
 * Действия пользователя в Личном кабинете
 */
public class LKUserActions {

    @Steps
    LKUserSteps user;

    @When("пользователь зарегистрирует себя как $clientType ($clientEmail)")
    public void userSetTypeAndResidenceOfClient(String clientType, String clientEmail) {
        user.clicksToLink("Зарегистрироваться");
        user.entersAccountData(clientEmail);
        user.selectsClientType(clientType);
        user.selectsClientCountry("Российская Федерация");
        user.entersCaptcha("captcha");
        user.clicksToConfirmButton();
        switch (clientType) {
            case "Индивидуальный предприниматель":
                user.entersIPData(clientEmail);
                user.uploadsIPDocumentsCopies();
                break;
            case "Юридическое лицо":
                user.entersULData(clientEmail);
                user.uploadsULDocumentsCopies();
                break;
            case "Физическое лицо":
                user.entersFLData();
                user.uploadsFLDocumentsCopies();
                break;
        }
        user.clicksToConfirmButton();
        user.entersVehicleData();
        user.uploadsVehicleDocumentsCopies();
        user.clicksToConfirmButton();
    }

    @When("пользователь вводит логин $login и пароль $password для авторизации в ЛК")
    public void userEntersLoginAndPassword(String login, String password) {
        user.entersLoginAndPassword(login, password);
        user.clicksToConfirmButton();
    }

    @When("он зарегистрирует новое ТС")
    public void userRegistersNewVehicle() {
        user.clicksToLink("Зарегистрировать ТС");
        user.entersNewVehicleData();
        user.uploadsNewVehicleDocumentsCopies();
        user.clicksToConfirmButton();
    }

    @When("он нажмет на это ТС")
    public void userClicksToVehicle() {
        user.clicksToVehicleForDetail();
    }

    @When("пользователь объеденит $amountVehicles своих ТС в группу $groupName")
    public void userChooseVehiclesForGroup(int amountVehicles, String groupName) {
        user.clicksToLink("Группы");
        user.clicksToLink("Добавить группу");
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

    @When("он просмотрит историю своих обращений")
    public void userLookUpsAllAppeals() {
    }

    @When("он создаст новое обращение")
    public void userCreatesNewAppeal() {
        user.clicksToLink("Написать обращение");
        user.entersAppealDetails();
        user.uploadsAdditionalDocument();
        user.clicksToConfirmButton();
    }

    @When("он нажмет на это обращение")
    public void userClicksToAppeal() {
        user.clicksToAppealForDetail();
    }
}