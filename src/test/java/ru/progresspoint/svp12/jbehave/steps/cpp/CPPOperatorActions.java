package ru.progresspoint.svp12.jbehave.steps.cpp;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.cpp.steps.CPPOperatorSteps;

/**
 * Шаги оператора АРМа ЦИПП
 */
public class CPPOperatorActions {

    @Steps
    CPPOperatorSteps operator;

    @When("он вводит логин $login и пароль $password для авторизации в ЦИПП")
    public void operatorEntersLoginAndPassword(String login, String password) {
        operator.entersLoginAndPassword(login, password);
        operator.clicksToConfirmButton();

    }

    @When("оператор зарегистрирует ВТС как $clientType ($clientEmail)")
    public void operatorRegistersNewClient(String clientType, String clientEmail) {
        operator.selectsClientCountry("Российская Федерация");
        operator.selectsClientType(clientType);
        operator.clicksToRegistrationButton();
        switch (clientType) {
            case "Индивидуальный предприниматель":
                operator.entersIPData(clientEmail);
//                operator.uploadsIPDocumentsCopies();
                break;
            case "Юридическое лицо":
                operator.entersULData(clientEmail);
//                operator.uploadsULDocumentsCopies();
                break;
            case "Физическое лицо":
                operator.entersFLData(clientEmail);
//                operator.uploadsFLDocumentsCopies();
                break;
        }
        operator.clicksToTextButton("Завершить регистрацию");
        operator.clicksToTextButton("Управление документами ВТС");
        operator.uploadsClientDocumentsCopies();
        operator.clicksToTextButton("Подтвердить");
        operator.clicksToTextButton("Регистрация ТС");
        operator.entersVehicleData();
        operator.clicksToTextButton("Зарегистрировать");
//        operator.uploadsVehicleDocumentsCopies();
//        operator.clicksToConfirmButton();
        operator.clicksToTextButton("OK");
        operator.clicksToTextButton("Завершить");
    }

    @When("оператор зарегистрирует ВТС нерезидента РФ как $clientType ($clientEmail)")
    public void operatorRegistersUserData(String clientType, String clientEmail) {
        operator.selectsClientCountry("Украина");
        operator.selectsClientType(clientType);
        operator.clicksToRegistrationButton();
        switch (clientType) {
            case "Индивидуальный предприниматель":
                operator.entersIPNonresidentData(clientEmail);
//                operator.uploadsIPDocumentsCopies();
                break;
            case "Юридическое лицо":
                operator.entersULNonresidentData(clientEmail);
//                operator.uploadsULDocumentsCopies();
                break;
            case "Физическое лицо":
                operator.entersFLNonresidentData(clientEmail);
//                operator.uploadsFLDocumentsCopies();
                break;
        }
        operator.clicksToTextButton("Завершить регистрацию");
//        operator.uploadsClientDocumentsCopies();
//        operator.clicksToTextButton("Подтвердить");
        operator.clicksToTextButton("Регистрация ТС");
        operator.entersVehicleData();
        operator.clicksToTextButton("Зарегистрировать");
//        operator.uploadsVehicleDocumentsCopies();
//        operator.clicksToConfirmButton();
        operator.clicksToConfirmVehicleRegistrationDialogButton();
        operator.clicksToTextButton("Завершить");
    }

    @When("оператор проводит верификацию данных пользователя")
    public void operatorVerifiesUserData() {
        operator.clicksToLink("Регистрация");
        operator.clicksToLink("Верификация");
        operator.findsOwnerVerificationRequest();
        operator.conductOwnerVerificationRequest();
        operator.findsVehicleVerificationRequest();
        operator.conductVehicleVerificationRequest();
    }
}