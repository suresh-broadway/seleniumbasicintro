package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingFileUpload {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement uploadFileText = driver.findElement(By.xpath("//h2[text()='Upload Files']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()",uploadFileText);

        WebElement singleFileInputButton = driver.findElement(By.id("singleFileInput"));
        singleFileInputButton.sendKeys("/home/suresh/Downloads/dojocat.jpg");

        WebElement fileUploadButton = driver.findElement(By.xpath("//button[text()='Upload Single File']"));
        fileUploadButton.click();
    }
}
