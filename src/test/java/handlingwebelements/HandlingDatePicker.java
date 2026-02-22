package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandlingDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

        driver.switchTo().frame(frame);
        WebElement datePicker = driver.findElement(By.id("datepicker"));
//        datePicker.sendKeys("02/16/2026");
        datePicker.click();
        String year = "2030";
        String month = "December";
        String day = "31";

        while(true){
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            if(actualMonth.equals(month) && actualYear.equals(year)){
                break;
            }else{
                WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
                nextButton.click();
            }
        }
        List<WebElement> calendarDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for(WebElement calendarDay : calendarDays){
            String dayValue = calendarDay.getText();
            if(dayValue.equals(day)){
                calendarDay.click();
            }
        }
    }
}
