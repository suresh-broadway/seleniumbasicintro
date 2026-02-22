package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hanlding {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement userNameField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()=' Login ']"));

        userNameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        loginButton.click();

        WebElement dropDownElement = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
        dropDownElement.click();
        WebElement logOutOption = driver.findElement(By.xpath("//a[text()='Logout']"));
        logOutOption.click();
    }
}
