package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public By clickNewCustomerLink = By.xpath("//a[contains(text(), 'New Customer')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public AddCustomerPage clickNewCustomer(){
        driver.findElement(clickNewCustomerLink).click();
        return new AddCustomerPage(driver);
    }
}
