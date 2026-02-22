package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingAlerts {
    WebDriver driver = new ChromeDriver();
    public void setUp(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement tabText = driver.findElement(By.xpath("//h2[text()='Tabs']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()",tabText);
    }
    public void simpleAlert(){
        setUp();
        WebElement simpleAlert = driver.findElement(By.xpath("//button[text()='Simple Alert']"));
        simpleAlert.click();
        driver.switchTo().alert().accept();
    }
    public void confirmationAlert(){
        setUp();
        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[text()='Confirmation Alert']"));
        confirmationAlertButton.click();

        driver.switchTo().alert().accept();
//        driver.switchTo().alert().dismiss();
    }
    public void promptAlert(){
        setUp();
        WebElement promptAlertButton = driver.findElement(By.xpath("//button[text()='Prompt Alert']"));
        promptAlertButton.click();

        driver.switchTo().alert().sendKeys("Ram");
//        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
    }

    public static void main(String[] args) {
        HandlingAlerts ht = new HandlingAlerts();
//        ht.simpleAlert();
//        ht.confirmationAlert();
        ht.promptAlert();
    }
}
