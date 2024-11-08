package example;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class WithdrawTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        // Set path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\KH1-24-25\\Testing\\TestCode\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the demo URL
        driver.get("http://www.demo.guru99.com/V4/");

        // Log in with valid credentials (change these credentials)
        driver.findElement(By.name("uid")).sendKeys("mngr600486");
        driver.findElement(By.name("password")).sendKeys("tEzugYs");
        driver.findElement(By.name("btnLogin")).click();

        // Wait for login to complete and navigate to Withdraw page
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Withdrawl")));
        driver.findElement(By.linkText("Withdrawl")).click();
    }

    @Test
    public void testAccountNoBlank() {
        driver.findElement(By.name("accountno")).clear();
        driver.findElement(By.name("amount")).sendKeys("5000");
        driver.findElement(By.name("desc")).sendKeys("Withdrawal Test");
        driver.findElement(By.name("submit")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//label[contains(text(), 'Account Number must not be blank')]"));
        assertNotNull(errorMessage, "Account Number must not be blank error should appear");
    }

    @Test
    public void testSpecialCharacterInAccountNo() {
        driver.findElement(By.name("accountno")).clear();
        driver.findElement(By.name("accountno")).sendKeys("@#$%");
        driver.findElement(By.name("amount")).sendKeys("5000");
        driver.findElement(By.name("desc")).sendKeys("Withdrawal Test");
        driver.findElement(By.name("submit")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//label[contains(text(), 'Special characters are not allowed')]"));
        assertNotNull(errorMessage, "Special characters are not allowed error should appear");
    }

    @Test
    public void testLettersInAccountNo() {
        driver.findElement(By.name("accountno")).clear();
        driver.findElement(By.name("accountno")).sendKeys("abcDEF");
        driver.findElement(By.name("amount")).sendKeys("5000");
        driver.findElement(By.name("desc")).sendKeys("Withdrawal Test");
        driver.findElement(By.name("submit")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//label[contains(text(), 'Characters are not allowed')]"));
        assertNotNull(errorMessage, "Characters are not allowed error should appear");
    }

    @Test
    public void testAmountFieldBlank() {
        driver.findElement(By.name("accountno")).clear();
        driver.findElement(By.name("accountno")).sendKeys("123456");
        driver.findElement(By.name("amount")).clear();
        driver.findElement(By.name("desc")).sendKeys("Withdrawal Test");
        driver.findElement(By.name("submit")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//label[contains(text(), 'Amount field must not be blank')]"));
        assertNotNull(errorMessage, "Amount field must not be blank error should appear");
    }

    @Test
    public void testLettersInAmount() {
        driver.findElement(By.name("accountno")).clear();
        driver.findElement(By.name("accountno")).sendKeys("123456");
        driver.findElement(By.name("amount")).sendKeys("abcDEF");
        driver.findElement(By.name("desc")).sendKeys("Withdrawal Test");
        driver.findElement(By.name("submit")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//label[contains(text(), 'Characters are not allowed')]"));
        assertNotNull(errorMessage, "Characters are not allowed error should appear in Amount");
    }

    @Test
    public void testSpecialCharacterInAmount() {
        driver.findElement(By.name("accountno")).clear();
        driver.findElement(By.name("accountno")).sendKeys("123456");
        driver.findElement(By.name("amount")).sendKeys("@!#$");
        driver.findElement(By.name("desc")).sendKeys("Withdrawal Test");
        driver.findElement(By.name("submit")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//label[contains(text(), 'Special characters are not allowed')]"));
        assertNotNull(errorMessage, "Special characters are not allowed error should appear in Amount");
    }

    @Test
    public void testDescriptionBlank() {
        driver.findElement(By.name("accountno")).clear();
        driver.findElement(By.name("accountno")).sendKeys("123456");
        driver.findElement(By.name("amount")).sendKeys("5000");
        driver.findElement(By.name("desc")).clear();
        driver.findElement(By.name("submit")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//label[contains(text(), 'Description cannot be blank')]"));
        assertNotNull(errorMessage, "Description cannot be blank error should appear");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
