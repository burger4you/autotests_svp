package ru.progresspoint.svp12.jbehave.steps.lk;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.lk.steps.LKUserSteps;

/**
 * Действия пользователя в АРМ ЛК
 */
public class LKUserActions {

    @Steps
    LKUserSteps user;

    @When("пользователь зарегистрирует себя как $clientType ($clientEmail)")
    public void userSetTypeAndResidenceOfClient(String clientType, String clientEmail) {
        user.clicksToLink("Зарегистрироваться");
        user.selectsClientType(clientType);
        user.selectsClientCountry("Российская Федерация");
        switch (clientType) {
            case "Индивидуальный предприниматель":
                user.entersIPData(clientEmail);
//                operator.uploadsIPDocumentsCopies();
                break;
            case "Юридическое лицо":
                user.entersULData(clientEmail);
//                operator.uploadsULDocumentsCopies();
                break;
            case "Физическое лицо":
                user.entersFLData(clientEmail);
//                operator.uploadsFLDocumentsCopies();
                break;
        }
        user.entersAddressesData();
        user.entersBankData();
        user.confirmsAgreeCheckboxes();
        user.entersCaptcha("Captcha");
        user.clicksToConfirmButton();
        user.entersVehicleData();
        user.uploadsVehicleDocumentsCopies();
        user.clicksToConfirmButton();
    }

    @When("владелец ТС введет логин $login и пароль $password соответствующей роли для авторизации в АРМ ЛК")
    public void userEntersLoginAndPassword(String login, String password) {
        user.entersLoginAndPassword(login, password);
        user.clicksToConfirmButton();
    }

//    @Composite("владелец ТС введет логин и пароль для авторизации в АРМ ЛК неверно 5 раз подряд")

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

    @When("он зарегистрирует новую группу ТС для $amountVehicles -х своих ТС")
    public void userRegistersNewVehiclesGroup(int amountVehicles) {
        user.clicksToLink("Группы");
        user.clicksToLink("Добавить группу");
        user.entersNewVehiclesGroupData();
        user.selectsVehiclesForGroup(amountVehicles);
        user.clicksToConfirmButton();
    }

    @When("он нажмет на эту группу ТС")
    public void userClicksToVehiclesGroup() {
        user.clicksToVehiclesGroupForDetail();
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