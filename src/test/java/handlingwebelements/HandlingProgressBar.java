package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingProgressBar {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/progress-bar");

        WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));

        By startButton = By.id("startStopButton");
        By resetButton = By.id("resetButton");

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(startButton)).click();
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(resetButton)).click();
    }
}
