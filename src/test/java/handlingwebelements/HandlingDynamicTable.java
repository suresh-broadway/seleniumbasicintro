package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandlingDynamicTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.expandtesting.com/dynamic-table");

        List<WebElement> numberOfRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
        System.out.println("The total number of rows: "+numberOfRows.size());
        List<WebElement> numberOfColumns = driver.findElements(By.xpath("//table[@class='table table-striped']/thead/tr/th"));
        System.out.println("The total number of columns: "+numberOfColumns.size());

        for(int row=1; row<=numberOfRows.size(); row++){
            WebElement columnValue = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+row+"]/td[1]"));
            if(columnValue.getText().equals("Chrome")){
                String cpuLoadValue = driver.findElement(By.xpath("//td[text()='Chrome']/following-sibling::td[contains(text(),'%')]")).getText();
                String yelloLabelText = driver.findElement(By.id("chrome-cpu")).getText();
                if(yelloLabelText.contains(cpuLoadValue)) {
                    System.out.println("The value on both is same and it is: " + cpuLoadValue);
                }
            }
        }

    }
}
