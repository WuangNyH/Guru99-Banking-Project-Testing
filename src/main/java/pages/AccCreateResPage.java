package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccCreateResPage {
    private WebDriver driver;
    public By messageSuccess = By.xpath("//p[contains(text(), 'Account Generated Successfully!!!')]");

    public AccCreateResPage(WebDriver driver){
        this.driver = driver;
    }

    public String getMessageSuccess() {
        return driver.findElement(messageSuccess).getText();
    }
}