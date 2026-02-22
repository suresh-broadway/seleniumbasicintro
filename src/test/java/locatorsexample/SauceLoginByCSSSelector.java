package locatorsexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SauceLoginByCSSSelector {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
        WebElement loginButton = driver.findElement(By.cssSelector("input.submit-button"));
//        WebElement userNameField = driver.findElement(By.cssSelector("input#user-name"));
        WebElement userNameField = driver.findElement(By.cssSelector("input.input_error[data-test='username']"));
//        WebElement passwordField = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input#password[name='password']"));
        userNameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();
    }
}
