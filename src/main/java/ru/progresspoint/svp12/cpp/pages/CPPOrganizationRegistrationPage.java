package ru.progresspoint.svp12.cpp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import org.openqa.selenium.WebElement;

/**
 * Страница Регистрации ВТС - юридическое лицо
 */
@At("#HOST/clients/draft")
public class CPPOrganizationRegistrationPage extends CPPSelectizePageObject {

    //ДАННЫЕ ЮРИДИЧЕСКОГО ЛИЦА
    private static final String organizationOPFField = "client_okopf_id";
    private static final String organizationLanguageField = "client_language_id";

    @FindBy(id = "client_ogrn")
    WebElementFacade organizationOGRNField;

    @FindBy(id = "client_inn")
    WebElementFacade organizationINNField;

    @FindBy(id = "client_kpp")
    WebElementFacade organizationKPPField;

    @FindBy(id = "client_name")
    WebElementFacade organizationNameField;

    @FindBy(id = "client_short_name")
    WebElementFacade organizationShortNameField;

    @FindBy(id = "client_main_phone_attributes_name")
    WebElementFacade organizationMainPhoneField;

    @FindBy(id = "client_main_email_attributes_name")
    WebElementFacade organizationMainEmailField;

    @FindBy(id = "client_country_reg_num")
    WebElementFacade organizationRegistrationNumberField;

    public void selectOrganizationOPF(String organizationOPF) {
        selectForSelectizePlugin(organizationOPFField, organizationOPF);
    }

    public void enterOrganizationOGRN(String organizationOGRN) {
        enter(organizationOGRN).into(organizationOGRNField);
    }

    public void enterOrganizationINN(String organizationINN) {
        enter(organizationINN).into(organizationINNField);
    }

    public void enterOrganizationKPP(String organizationKPP) {
        enter(organizationKPP).into(organizationKPPField);
    }

    public void enterOrganizationName(String organizationName) {
        enter(organizationName).into(organizationNameField);
    }

    public void enterOrganizationShortName(String organizationShortName) {
        enter(organizationShortName).into(organizationShortNameField);
    }

    public void enterOrganizationMainPhone(String organizationPhone) {
        enter(organizationPhone).into(organizationMainPhoneField);
    }

    public void enterOrganizationMainEmail(String organizationEmail) {
        enter(organizationEmail).into(organizationMainEmailField);
    }

    public void selectOrganizationLanguage(String organizationLanguage) {
        selectForSelectizePlugin(organizationLanguageField, organizationLanguage);
    }

    public void enterOrganizationRegistrationNumber(String organizationRegistrationNumber) {
        enter(organizationRegistrationNumber).into(organizationRegistrationNumberField);
    }

    //АДРЕС РЕГИСТРАЦИИ
    private static final String clientAddressRegionField = "client_reg_address_attributes_region";
    private static final String clientAddressDistrictField = "client_reg_address_attributes_district";
    private static final String clientAddressCityField = "client_reg_address_attributes_city";
    private static final String clientAddressSettlementField = "client_reg_address_attributes_settlement";
    private static final String clientAddressStreetField = "client_reg_address_attributes_street";

    @FindBy(id = "client_reg_address_attributes_house")
    WebElementFacade clientAddressHouseField;

    @FindBy(id = "client_reg_address_attributes_housing")
    WebElementFacade clientAddressHousingField;

    @FindBy(id = "client_reg_address_attributes_building")
    WebElementFacade clientAddressBuildingField;

    @FindBy(id = "client_reg_address_attributes_room")
    WebElementFacade clientAddressRoomField;

    @FindBy(id = "client_reg_address_attributes_index")
    WebElementFacade clientAddressIndexField;

    public void selectClientRegistrationAddressRegion(String clientAddressRegion) {
        if (!clientAddressRegion.isEmpty()) enterForSelectizePlugin(clientAddressRegionField, clientAddressRegion);
    }

    public void selectClientRegistrationAddressDistrict(String clientAddressDistrict) {
        if (!clientAddressDistrict.isEmpty())enterForSelectizePlugin(clientAddressDistrictField, clientAddressDistrict);
    }

    public void selectClientRegistrationAddressCity(String clientAddressCity) {
        if (!clientAddressCity.isEmpty())enterForSelectizePlugin(clientAddressCityField, clientAddressCity);
    }

    public void selectClientRegistrationAddressSettlement(String clientAddressSettlement) {
        if (!clientAddressSettlement.isEmpty())enterForSelectizePlugin(clientAddressSettlementField, clientAddressSettlement);
    }

    public void selectClientRegistrationAddressStreet(String clientAddressStreet) {
        if (!clientAddressStreet.isEmpty()) {
//            enterForSelectizePlugin(clientAddressStreetField, clientAddressStreet);
            //TODO: Костыль, пока не сделают нормальное поле для улицы.
            enter(clientAddressStreet).into(findBy(String.format(INPUT_XPATH, clientAddressStreetField)));
            waitABit(3000);
            clickOnInvisibleElement(findBy(String.format(INPUT_ITEM_XPATH, clientAddressStreetField)));
        }
    }

    public void enterClientRegistrationAddressHouse(String clientAddressHouse) {
        enter(clientAddressHouse).into(clientAddressHouseField);
    }

    public void enterClientRegistrationAddressHousing(String clientAddressHousing) {
        enter(clientAddressHousing).into(clientAddressHousingField);
    }

    public void enterClientRegistrationAddressBuilding(String clientAddressBuilding) {
        enter(clientAddressBuilding).into(clientAddressBuildingField);
    }

    public void enterClientRegistrationAddressRoom(String clientAddressRoom) {
        enter(clientAddressRoom).into(clientAddressRoomField);
    }

    public void enterClientRegistrationAddressIndex(String clientAddressIndex) {
        enter(clientAddressIndex).into(clientAddressIndexField);
    }

    //АДРЕС МЕСТОНАХОЖДЕНИЯ
    @FindBy(xpath = ".//*[@for='client_location_address_attributes_same_as_reg']/div")
    WebElementFacade locationAddressSameAsRegistrationCheckBox;

    private static final String locationAddressRegionField = "client_location_address_attributes_region";
    private static final String locationAddressDistrictField = "client_location_address_attributes_district";
    private static final String locationAddressCityField = "client_location_address_attributes_city";
    private static final String locationAddressSettlementField = "client_location_address_attributes_settlement";
    private static final String locationAddressStreetField = "client_location_address_attributes_street";

    @FindBy(id = "client_location_address_attributes_house")
    WebElementFacade locationAddressHouseField;

    @FindBy(id = "client_location_address_attributes_housing")
    WebElementFacade locationAddressHousingField;

    @FindBy(id = "client_location_address_attributes_building")
    WebElementFacade locationAddressBuildingField;

    @FindBy(id = "client_location_address_attributes_room")
    WebElementFacade locationAddressRoomField;

    @FindBy(id = "client_location_address_attributes_post_index")
    WebElementFacade locationAddressIndexField;

    public void clickToLocationAddressSameAsRegistrationCheckBox() {
        locationAddressSameAsRegistrationCheckBox.click();
    }

    public void selectClientLocationAddressRegion(String locationAddressRegion) {
        if (!locationAddressRegion.isEmpty()) enterForSelectizePlugin(locationAddressRegionField, locationAddressRegion);
    }

    public void selectClientLocationAddressDistrict(String locationAddressDistrict) {
        if (!locationAddressDistrict.isEmpty()) enterForSelectizePlugin(locationAddressDistrictField, locationAddressDistrict);
    }

    public void selectClientLocationAddressCity(String locationAddressCity) {
        if (!locationAddressCity.isEmpty()) enterForSelectizePlugin(locationAddressCityField, locationAddressCity);
    }

    public void selectClientLocationAddressSettlement(String locationAddressSettlement) {
        if (!locationAddressSettlement.isEmpty()) enterForSelectizePlugin(locationAddressSettlementField, locationAddressSettlement);
    }

    public void selectClientLocationAddressStreet(String locationAddressStreet) {
        if (!locationAddressStreet.isEmpty()) enterForSelectizePlugin(locationAddressStreetField, locationAddressStreet);
    }

    public void enterClientLocationAddressHouse(String locationAddressHouse) {
        enter(locationAddressHouse).into(locationAddressHouseField);
    }

    public void enterClientLocationAddressHousing(String locationAddressHousing) {
        enter(locationAddressHousing).into(locationAddressHousingField);
    }

    public void enterClientLocationAddressBuilding(String locationAddressBuilding) {
        enter(locationAddressBuilding).into(locationAddressBuildingField);
    }

    public void enterClientLocationAddressRoom(String locationAddressRoom) {
        enter(locationAddressRoom).into(locationAddressRoomField);
    }

    public void enterClientLocationAddressIndex(String locationAddressIndex) {
        enter(locationAddressIndex).into(locationAddressIndexField);
    }

    private void clickOnInvisibleElement(WebElement element) {
        String script = "var object = arguments[0];"
                + "var theEvent = document.createEvent(\"MouseEvent\");"
                + "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "object.dispatchEvent(theEvent);";
        getJavascriptExecutorFacade().executeScript(script, element);
    }

    //ЛИЧНЫЕ ДАННЫЕ РУКОВОДИТЕЛЯ
    private static final String directorDocumentTypeField = "client_ceo_persons_attributes_0_authority_doc_attributes_doc_type_id";
    private static final String directorPositionField = "client_ceo_persons_attributes_0_job_name";
    private static final String directorRoleField = "client_ceo_persons_attributes_0_contact_role";

    @FindBy(id = "client_ceo_persons_attributes_0_surname")
    WebElementFacade directorSurnameField;

    @FindBy(id = "client_ceo_persons_attributes_0_name")
    WebElementFacade directorNameField;

    @FindBy(id = "client_ceo_persons_attributes_0_patronymic")
    WebElementFacade directorPatronymicField;

    @FindBy(id = "client_ceo_persons_attributes_0_authority_doc_attributes_number")
    WebElementFacade directorDocumentNumberField;

    @FindBy(id = "client_ceo_persons_attributes_0_authority_doc_attributes_start_date")
    WebElementFacade directorDocumentDateField;

    @FindBy(id = "client_ceo_persons_attributes_0_authority_doc_attributes_end_date")
    WebElementFacade directorDocumentValidityField;

    @FindBy(id = "client_ceo_persons_attributes_0_authority_doc_attributes_issue_date")
    WebElementFacade directorDocumentIssuedDateField;

    @FindBy(id = "client_ceo_persons_attributes_0_main_email_attributes_name")
    WebElementFacade directorEmailField;

    public void enterDirectorSurname(String directorSurname) {
        enter(directorSurname).into(directorSurnameField);
    }

    public void enterDirectorName(String directorName) {
        enter(directorName).into(directorNameField);
    }

    public void enterDirectorPatronymic(String directorPatronymic) {
        enter(directorPatronymic).into(directorPatronymicField);
    }

    public void selectDirectorDocumentType(String directorDocumentType) {
        selectForSelectizePlugin(directorDocumentTypeField, directorDocumentType);
    }

    public void enterDirectorDocumentNumber(String directorDocumentNumber) {
        enter(directorDocumentNumber).into(directorDocumentNumberField);
    }

    public void enterDirectorDocumentDate(String directorDocumentDate) {
        enter(directorDocumentDate).into(directorDocumentDateField);
    }

    public void enterDirectorDocumentValidity(String directorDocumentValidity) {
        enter(directorDocumentValidity).into(directorDocumentValidityField);
    }

    public void enterDirectorDocumentIssuedDate(String directorDocumentIssuedDate) {
        enter(directorDocumentIssuedDate).into(directorDocumentIssuedDateField);
    }

    public void enterDirectorEmail(String directorEmail) {
        enter(directorEmail).into(directorEmailField);
    }

    public void selectDirectorPosition(String directorPosition) {
        selectForSelectizePlugin(directorPositionField, directorPosition);
    }

    public void selectDirectorRole(String directorRole) {
        selectForSelectizePlugin(directorRoleField, directorRole);
    }
}
