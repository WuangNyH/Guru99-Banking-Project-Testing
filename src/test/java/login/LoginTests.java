package login;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class LoginTests extends BaseTests {
    @Test
    @DisplayName("TC_001 - User-ID must not be blank")
    public void TC_001(){
        loginPage.setUserName("");
        loginPage.pressTAB();
        String messageError = loginPage.getMessage23();
        Assertions.assertEquals(messageError, "User-ID must not be blank", "Result message is incorrect!");
    }

    @Test
    @DisplayName("TC_002 - Password must not be blank")
    public void TC_002(){
        loginPage.setUserName("mngr596864");
        loginPage.setPassword("");
        loginPage.pressTAB();
        String messageError = loginPage.getMessage18();
        Assertions.assertEquals(messageError, "Password must not be blank", "Result message is incorrect!");
    }

    @Test
    @DisplayName("TC_003 - User-ID and Password is wrong")
    public void TC_003(){
        loginPage.setUserName("mngr596864");
        loginPage.setPassword("123456");
        loginPage.clickLoginButton();
        String messageError = loginPage.getAlertText();
        loginPage.clickAcceptAlert();
        Assertions.assertEquals(messageError, "User or Password is not valid", "Result message is incorrect!");
    }

    @Test
    @DisplayName("TC_004 - User-ID and Password is correct")
    public void TC_004(){
        loginPage.setUserName("mngr600464");
        loginPage.setPassword("pezabAn");
        HomePage homePage = loginPage.clickLoginButton();
        String currentUrl = homePage.getUrl();
        Assertions.assertTrue(currentUrl.contains("/manager/Managerhomepage.php"), "Result is incorrect!");
    }
}
