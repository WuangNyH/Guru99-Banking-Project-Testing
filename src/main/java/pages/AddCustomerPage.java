package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AddCustomerPage {
    private WebDriver driver;
    public By customerNameElement = By.xpath("//input[@name='name']");
    public By addressElement = By.xpath("//textarea[@name='addr']");
    public By cityElement = By.xpath("//input[@name='city']");
    public By stateElement = By.xpath("//input[@name='state']");
    public By PINElement = By.xpath("//input[@name='pinno']");
    public By mobileElement = By.xpath("//input[@name='telephoneno']");
    public By emailElement = By.xpath("//input[@name='emailid']");
    public By dateElement = By.xpath("//input[@name='dob']");
    public By passwordElement = By.xpath("//input[@name='password']");
    public By submitButton = By.xpath("//input[@name='sub']");

    public AddCustomerPage(WebDriver driver){
        this.driver = driver;
    }

    public void setCustomerNameElement(String customerName) {
        driver.findElement(customerNameElement).sendKeys(customerName);
    }

    public void setAddressElement(String address){
        driver.findElement(addressElement).sendKeys(address);
    }

    public void setCityElement(String city){
        driver.findElement(cityElement).sendKeys(city);
    }

    public void setStateElement(String state){
        driver.findElement(stateElement).sendKeys(state);
    }

    public void setPINElement(String pin){
        driver.findElement(PINElement).sendKeys(pin);
    }

    public void setMobileElement(String mobile){
        driver.findElement(mobileElement).sendKeys(mobile);
    }

    public void setEmailElement(String email){
        driver.findElement(emailElement).sendKeys(email);
    }

    public void setDateElement(String date){
        driver.findElement(dateElement).sendKeys(date);
    }

    public void setPasswordElement(String password){
        driver.findElement(passwordElement).sendKeys(password);
    }

    public String getMessageError(By messageError){
        return driver.findElement(messageError).getText();
    }

    public CustomerResPage clickSubmitButton(){
        driver.findElement(submitButton).click();
        return new CustomerResPage(driver);
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
