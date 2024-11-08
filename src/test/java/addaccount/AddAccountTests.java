package addaccount;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import pages.AccCreateResPage;
import pages.AddAccountPage;
import pages.HomePage;

public class AddAccountTests extends BaseTests {
    protected HomePage homePage;
    protected AddAccountPage addAccountPage;
    protected AccCreateResPage accCreateResPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        loginPage.setUserName("mngr600464");
        loginPage.setPassword("pezabAn");
        homePage = loginPage.clickLoginButton();
        addAccountPage = homePage.clickNewAccount();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CustomerIdData.csv")
    @DisplayName("Customer ID Validation – Invalid Inputs")
    public void testCustomerIdInvalidInputs(String customerId, String expectedErrorMessage) {
        By messageErrorCustomerName = By.id("message14");
        addAccountPage.setCustomerIdElement(customerId);
        addAccountPage.pressTAB();
        String errorMessage = addAccountPage.getMessageError(messageErrorCustomerName);
        Assertions.assertEquals(expectedErrorMessage, errorMessage, "Result is incorrect");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/InitialDepositData.csv")
    @DisplayName("Initial deposit Validation – Invalid Inputs")
    public void testInitialDepositInvalidInputs(String initialDeposit, String expectedErrorMessage) {
        By messageErrorCustomerName = By.id("message19");
        addAccountPage.setInitialDepositElement(initialDeposit);
        addAccountPage.pressTAB();
        String errorMessage = addAccountPage.getMessageError(messageErrorCustomerName);
        Assertions.assertEquals(expectedErrorMessage, errorMessage, "Result is incorrect");
    }

    @Test
    @DisplayName("TC_042 - Submit with wrong Customer ID")
    public void testSubmitWrongID(){
        addAccountPage.setCustomerIdElement("12345");
        addAccountPage.setInitialDepositElement("12345");
        addAccountPage.clickSubmitButton();
        String errorMessage = addAccountPage.getAlertText();
        addAccountPage.clickAcceptAlert();
        Assertions.assertEquals(errorMessage, "Customer does not exist!!", "Result is incorrect");
    }

    @Test
    @DisplayName("TC_043 - Submit with correct Customer ID")
    public void testSubmitCorrectID(){
        addAccountPage.setCustomerIdElement("70940");
        addAccountPage.setInitialDepositElement("12345");
        accCreateResPage = addAccountPage.clickSubmitButton();
        Assertions.assertTrue(accCreateResPage.getMessageSuccess().contains("Account Generated Successfully!!!"), "Result is incorrect");
    }
}
