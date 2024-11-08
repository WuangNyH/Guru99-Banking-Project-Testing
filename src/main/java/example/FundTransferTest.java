package example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class FundTransferTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\KH1-24-25\\Testing\\TestCode\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.demo.guru99.com/V4/");

        driver.findElement(By.name("uid")).sendKeys("validUser");
        driver.findElement(By.name("password")).sendKeys("validPassword");
        driver.findElement(By.name("btnLogin")).click();
    }

    @Test
    public void testFundTransferValidData() {
        driver.findElement(By.linkText("Fund Transfer")).click();

        driver.findElement(By.name("payersaccount")).sendKeys("12345");
        driver.findElement(By.name("payeeaccount")).sendKeys("67890");
        driver.findElement(By.name("ammount")).sendKeys("200");
        driver.findElement(By.name("desc")).sendKeys("Fund transfer test");

        driver.findElement(By.name("AccSubmit")).click();

        String successMessage = driver.findElement(By.xpath("//table[@id='transfer']//td[1]")).getText();
        assertTrue(successMessage.contains("Fund transfer successful"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

