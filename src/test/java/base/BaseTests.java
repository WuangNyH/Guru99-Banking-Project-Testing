package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class BaseTests {
    private WebDriver driver;
    protected LoginPage loginPage;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.demo.guru99.com/V4/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

//    @AfterEach
//    public void tearDown(){
//        driver.quit();
//    }

    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
