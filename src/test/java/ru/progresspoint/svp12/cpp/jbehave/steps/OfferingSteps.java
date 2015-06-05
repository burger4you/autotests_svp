package ru.progresspoint.svp12.cpp.jbehave.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import ru.progresspoint.svp12.cpp.steps.OperatorSteps;

/**
 * Шаги оператора при работе с договорами
 */
public class OfferingSteps {

    @Steps
    OperatorSteps operator;

    @When("он выбирает тип клиента \"$clientType\" и резидентство \"$clientResidence\"")
    public void operatorSetTypeAndResidenceOfClient(String clientType, String clientResidence) {
        operator.setsClientType(clientType);
        operator.setsClientResidence(clientResidence);
    }

    @When("заполняет личные данные владельца: $clientSurname $clientName $clientPatronymic родился $clientBirthday")
    public void operatorFillsClientPersonalData(String clientSurname,
                                                String clientName,
                                                String clientPatronymic,
                                                String clientBirthday) {
        operator.fillsClientPersonalData(clientSurname, clientName, clientPatronymic);
        operator.fillsClientBirthday(clientBirthday);
    }

    @When("заполняет паспортные данные владельца: $passportSeriesAndNumber выдан $passportIssuedBy $passportIssuedWhen")
    public void operatorFillsClientPassportData(String passportSeriesAndNumber,
                                                String passportIssuedBy,
                                                String passportIssuedWhen) {
        operator.fillsClientPassportData(passportSeriesAndNumber, passportIssuedBy, passportIssuedWhen);
    }
}
