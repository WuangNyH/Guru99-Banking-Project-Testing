package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerResPage {
    private WebDriver driver;
    public By messageSuccess = By.xpath("//p[contains(text(), 'Customer Registered Successfully!!!')]");

    public CustomerResPage(WebDriver driver){
        this.driver = driver;
    }

    public String getMessageSuccess() {
        return driver.findElement(messageSuccess).getText();
    }
}
