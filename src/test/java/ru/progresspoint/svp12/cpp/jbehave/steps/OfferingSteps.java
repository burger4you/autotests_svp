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

    @When("заполняет адрес регистрации: $addressIndex; $addressCityAndStreet; д. $addressHome; кв. $addressApartment")
    public void operatorFillsClientAddressData(String addressIndex,
                                               String addressCityAndStreet,
                                               String addressHome,
                                               String addressApartment) {
        operator.fillsClientAddressData(addressIndex, addressCityAndStreet, addressHome, addressApartment);
    }

    @When("указывает, что фактический адрес совпадает с адресом регистрации")
    public void operatorFillsClientAddressData() {
        operator.setMatchedTheAddresses();
    }

    @When("заполняет личные данные контактного лица: $contactSurname $contactName $contactPatronymic")
    public void operatorFillsContactPersonalData(String contactSurname,
                                                String contactName,
                                                String contactPatronymic) {
        operator.fillsContactPersonalData(contactSurname, contactName, contactPatronymic);
    }

    @When("заполняет основные контакты: телефон $contactMainPhone и email $contactMainEmail")
    public void operatorFillsContactPersonalData(String contactMainPhone,
                                                 String contactMainEmail) {
        operator.fillsContactPhoneAndEmail(contactMainPhone, contactMainEmail);
    }

    @When("подтверждает регистрацию")
    public void operatorConfirmRegistration() {
        operator.clickRegistrationButton();
    }
}
