package addcustomer;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import pages.AddCustomerPage;
import pages.CustomerResPage;
import pages.HomePage;

public class AddCustomerTests extends BaseTests {
    protected HomePage homePage;
    protected AddCustomerPage addCustomerPage;
    protected CustomerResPage customerResPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        loginPage.setUserName("mngr600464");
        loginPage.setPassword("pezabAn");
        homePage = loginPage.clickLoginButton();
        addCustomerPage = homePage.clickNewCustomer();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CustomerNameData.csv")
    @DisplayName("Customer Name Validation – Invalid Inputs")
    public void testCustomerNameInvalidInputs(String customerName, String expectedErrorMessage) {
        By messageErrorCustomerName = By.id("message");
        addCustomerPage.setCustomerNameElement(customerName);
        addCustomerPage.pressTAB();
        String errorMessage = addCustomerPage.getMessageError(messageErrorCustomerName);
        Assertions.assertEquals(expectedErrorMessage, errorMessage, "Result is incorrect");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/AddressData.csv")
    @DisplayName("Address Validation – Invalid Inputs")
    public void testAddressInvalidInputs(String address, String expectedErrorMessage) {
        By messageErrorAddress = By.id("message3");
        addCustomerPage.setAddressElement(address);
        addCustomerPage.pressTAB();
        String errorMessage = addCustomerPage.getMessageError(messageErrorAddress);
        Assertions.assertEquals(expectedErrorMessage, errorMessage, "Result is incorrect");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CityData.csv")
    @DisplayName("City Validation – Invalid Inputs")
    public void testCityInvalidInputs(String city, String expectedErrorMessage) {
        By messageErrorAddress = By.id("message4");
        addCustomerPage.setCityElement(city);
        addCustomerPage.pressTAB();
        String errorMessage = addCustomerPage.getMessageError(messageErrorAddress);
        Assertions.assertEquals(expectedErrorMessage, errorMessage, "Result is incorrect");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/StateData.csv")
    @DisplayName("State Validation – Invalid Inputs")
    public void testStateInvalidInputs(String state, String expectedErrorMessage) {
        By messageErrorAddress = By.id("message5");
        addCustomerPage.setStateElement(state);
        addCustomerPage.pressTAB();
        String errorMessage = addCustomerPage.getMessageError(messageErrorAddress);
        Assertions.assertEquals(expectedErrorMessage, errorMessage, "Result is incorrect");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/PINData.csv")
    @DisplayName("PIN Validation – Invalid Inputs")
    public void testPINInvalidInputs(String pin, String expectedErrorMessage) {
        By messageErrorAddress = By.id("message6");
        addCustomerPage.setPINElement(pin);
        addCustomerPage.pressTAB();
        String errorMessage = addCustomerPage.getMessageError(messageErrorAddress);
        Assertions.assertEquals(expectedErrorMessage, errorMessage, "Result is incorrect");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/MobileData.csv")
    @DisplayName("Mobile Validation – Invalid Inputs")
    public void testMobileInvalidInputs(String mobile, String expectedErrorMessage) {
        By messageErrorAddress = By.id("message7");
        addCustomerPage.setMobileElement(mobile);
        addCustomerPage.pressTAB();
        String errorMessage = addCustomerPage.getMessageError(messageErrorAddress);
        Assertions.assertEquals(expectedErrorMessage, errorMessage, "Result is incorrect");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/EmailData.csv")
    @DisplayName("Email Validation – Invalid Inputs")
    public void testEmailInvalidInputs(String email, String expectedErrorMessage) {
        By messageErrorAddress = By.id("message9");
        addCustomerPage.setEmailElement(email);
        addCustomerPage.pressTAB();
        String errorMessage = addCustomerPage.getMessageError(messageErrorAddress);
        Assertions.assertEquals(expectedErrorMessage, errorMessage, "Result is incorrect");
    }

    @Test
    @DisplayName("TC_033 - Submit with incorrect data")
    public void testSubmitIncorrectData() {
        addCustomerPage.setCustomerNameElement("QuanTLM");
        addCustomerPage.setAddressElement("53 Nguyen Duc Canh");
        addCustomerPage.setCityElement("@DaNang");
        addCustomerPage.setStateElement("None");
        addCustomerPage.setPINElement("123456");
        addCustomerPage.setMobileElement("0979702058");
        addCustomerPage.setEmailElement("kayzz0979@gmail.com");
        addCustomerPage.setDateElement("10/02/2003");
        addCustomerPage.setPasswordElement("hang151021");
        addCustomerPage.clickSubmitButton();
        String errorMessage = addCustomerPage.getAlertText();
        addCustomerPage.clickAcceptAlert();
        Assertions.assertEquals(errorMessage, "please fill all fields", "Result is incorrect");
    }

    @Test
    @DisplayName("TC_033 - Submit with incorrect data")
    public void testSubmitCorrectData() {
        addCustomerPage.setCustomerNameElement("QuanTLM");
        addCustomerPage.setAddressElement("53 Nguyen Duc Canh");
        addCustomerPage.setCityElement("DaNang");
        addCustomerPage.setStateElement("None");
        addCustomerPage.setPINElement("123456");
        addCustomerPage.setMobileElement("0979702058");
        addCustomerPage.setEmailElement("kayzz1510@gmail.com");
        addCustomerPage.setDateElement("10/02/2003");
        addCustomerPage.setPasswordElement("hang151021");
        customerResPage = addCustomerPage.clickSubmitButton();
        Assertions.assertTrue(customerResPage.getMessageSuccess().contains("Customer Registered Successfully!!!"), "Result is incorrect");
    }
}
