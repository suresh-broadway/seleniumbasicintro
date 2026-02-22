package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandlingCheckBoxes {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

//        List<WebElement> daysCheckboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
//
//        for(WebElement checkBox : daysCheckboxes){
//            checkBox.click();
//        }
        List<WebElement> daysValues = driver.findElements(By.xpath("//label[@class='form-check-label']"));
        for(WebElement day : daysValues){
            String dayValue = day.getText();
            if(dayValue.equals("Tuesday")){
                day.click();
            }
            if(dayValue.equals("Saturday")){
                day.click();
            }
            if(dayValue.equals("Male")){
                day.click();
            }
        }
    }
}
