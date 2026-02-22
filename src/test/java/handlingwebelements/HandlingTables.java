package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandlingTables {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement tableText = driver.findElement(By.xpath("//h2[text()='Static Web Table']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()",tableText);

        List<WebElement> tableData = driver.findElements(By.xpath("//table[@name=\"BookTable\"]/tbody/tr/td"));

        for(WebElement tData : tableData){
            String tableDataText = tData.getText();
            System.out.println(tableDataText);
        }
    }
}
