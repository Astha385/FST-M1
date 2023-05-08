package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity13 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/tables");
        System.out.println(driver.getTitle());

        int noOfRows = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr")).size();
        System.out.println(noOfRows);

        int noOfCols = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[1]/td")).size();
        System.out.println(noOfCols);

        List<WebElement> thirdRowCells = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[3]"));
        for(WebElement thirdRowCell : thirdRowCells ){
            System.out.println(thirdRowCell.getText());
        }

        WebElement secRowSecCol = driver.findElement(By.xpath("//table[@class='ui celled striped table']/tbody/tr[2]/td[2]"));
        System.out.println(secRowSecCol.getText());

        driver.quit();
    }

}
