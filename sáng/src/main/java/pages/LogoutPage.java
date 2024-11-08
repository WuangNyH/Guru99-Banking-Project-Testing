package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
    private WebDriver driver;
    public By userIdElement = By.xpath("//input[@name='uid']");
    public By passwordIdElement = By.xpath("//input[@name='password']");
    public By loginButton = By.xpath("//input[@name='btnLogin']");
    public By message23 = By.id("message23");
    public By message18 = By.id("message18");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String userName) {
        driver.findElement(userIdElement).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordIdElement).sendKeys(password);
    }

    public HomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public String getMessage23() {
        return driver.findElement(message23).getText();
    }

    public void pressTAB() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
    }

    public String getMessage18() {
        return driver.findElement(message18).getText();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void clickAcceptAlert() {
        driver.switchTo().alert().accept();
    }
}
