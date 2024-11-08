package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AddAccountPage {
    private WebDriver driver;
    public By customerIdElement = By.xpath("//input[@name='cusid']");
    public By initialDepositElement = By.xpath("//input[@name='inideposit']");
    public By submitButton = By.xpath("//input[@name='button2']");

    public AddAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void setCustomerIdElement(String customerId){
        driver.findElement(customerIdElement).sendKeys(customerId);
    }

    public void setInitialDepositElement(String initialDeposit){
        driver.findElement(initialDepositElement).sendKeys(initialDeposit);
    }

    public String getMessageError(By messageError){
        return driver.findElement(messageError).getText();
    }

    public AccCreateResPage clickSubmitButton(){
        driver.findElement(submitButton).click();
        return new AccCreateResPage(driver);
    }

    public void pressTAB() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void clickAcceptAlert() {
        driver.switchTo().alert().accept();
    }
}
