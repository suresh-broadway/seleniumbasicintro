package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingIFrames {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice-automation.com/iframes/");

        driver.switchTo().frame("iframe-1");
        WebElement apiText = driver.findElement(By.xpath("//a[text()='API']"));
        apiText.click();

        driver.switchTo().defaultContent(); // back from the iframe and stays on the automate now site
        WebElement meTooText = driver.findElement(By.xpath("//p[text()='Me too!']"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()",meTooText);

        WebElement nextFrame = driver.findElement(By.xpath("//iframe[@name='bottom-iframe']"));
        driver.switchTo().frame(nextFrame);
        WebElement downloadText = driver.findElement(By.xpath("//span[text()='Downloads']"));
        downloadText.click();

    }
}
