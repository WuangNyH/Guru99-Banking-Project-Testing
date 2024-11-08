package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Đặt đường dẫn đến ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\\KH1-24-25\\Testing\\TestCode\\chromedriver\\chromedriver.exe");

        // Tạo tùy chọn cho Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Khởi tạo ChromeDriver với tùy chọn
        WebDriver driver = new ChromeDriver(options);

        // Đặt thời gian chờ tối đa
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            // Điều hướng đến trang đăng nhập
            driver.get("https://demo.guru99.com/V4/");

            // Tìm và điền tên đăng nhập
            WebElement usernameField = driver.findElement(By.name("uid"));
            usernameField.sendKeys("mngr600486");

            // Tìm và điền mật khẩu
            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("tEzugYs");

            // Tìm và click vào nút đăng nhập
            WebElement loginButton = driver.findElement(By.name("btnLogin"));
            loginButton.click();

            // Xử lý các bước tiếp theo ở đây
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}
