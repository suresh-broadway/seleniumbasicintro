package waitsinselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement usernameField = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        WebElement passwordField = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        WebElement loginButton = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();
    }
}
