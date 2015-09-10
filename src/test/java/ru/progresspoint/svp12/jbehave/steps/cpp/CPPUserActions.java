package ru.progresspoint.svp12.jbehave.steps.cpp;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.EmailUserSteps;
import ru.progresspoint.svp12.cpp.steps.CPPAdministratorSteps;
import ru.progresspoint.svp12.cpp.steps.CPPOperatorSteps;

import javax.mail.MessagingException;

/**
 * Шаги пользователя АРМа ЦИПП
 */
public class CPPUserActions {

    @Steps
    CPPOperatorSteps operator;

    @Steps
    CPPAdministratorSteps admin;

    @Steps
    EmailUserSteps email;

    @When("оператор вводит логин $login и пароль $password для авторизации в АРМ ЦИПП")
    public void operatorEntersLoginAndPassword(String login, String password) {
        operator.entersLoginAndPassword(login, password);
        operator.clicksToConfirmButton();
    }

    @When("админ вводит логин $login и пароль $password для авторизации в АРМ ЦИПП")
    public void adminEntersLoginAndPassword(String login, String password) {
        admin.entersLoginAndPassword(login, password);
        admin.clicksToConfirmButton();
    }

    @When("оператор зарегистрирует ВТС как $clientType ($clientEmail)")
    public void operatorRegistersNewClient(String clientType, String clientEmail) throws MessagingException {
        email.deletesAllMessagesFromPlaton(clientEmail);
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
        operator.clicksToConfirmVehicleRegistrationDialogButton();
        operator.clicksToTextButton("Завершить");
    }

    @When("оператор зарегистрирует ВТС нерезидента РФ как $clientType ($clientEmail)")
    public void operatorRegistersUserData(String clientType, String clientEmail) throws MessagingException {
        email.deletesAllMessagesFromPlaton(clientEmail);
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