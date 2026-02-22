package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NestedFrameExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.automationtesting.in/Frames.html");

        WebElement nestedFrameButton = driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
        nestedFrameButton.click();

        WebElement firstFrame = driver.findElement(By.xpath("//div[@id='Multiple']/child::iframe"));
        driver.switchTo().frame(firstFrame);

        WebElement secondFrame = driver.findElement(By.xpath("//div[@class='iframe-container']/child::iframe"));
        driver.switchTo().frame(secondFrame);

        WebElement textField = driver.findElement(By.tagName("input"));
        textField.sendKeys("Broadway");

        driver.switchTo().defaultContent();

        WebElement singleFrameButton = driver.findElement(By.xpath("//a[text()='Single Iframe ']"));
        singleFrameButton.click();

        driver.switchTo().frame("singleframe");

        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("Broadway");
    }
}
