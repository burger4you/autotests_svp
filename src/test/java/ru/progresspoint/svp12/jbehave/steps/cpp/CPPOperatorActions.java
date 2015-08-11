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
    public void operatorSetTypeAndResidenceOfClient(String clientType, String clientEmail) {
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
        operator.uploadsClientDocumentsCopies();
        operator.clicksToTextButton("Подтвердить");
//        operator.entersVehicleData();
//        operator.uploadsVehicleDocumentsCopies();
//        operator.clicksToConfirmButton();
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