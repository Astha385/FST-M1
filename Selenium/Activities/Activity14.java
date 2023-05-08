package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {
      public static void main(String[] args){
          WebDriverManager.firefoxdriver().setup();
          WebDriver driver = new FirefoxDriver();

          driver.get("https://training-support.net/selenium/tables");
          driver.getTitle();

          int noOfRows = driver.findElements(By.xpath("//div[@class='extra spaced']/div[2]/table/tbody/tr")).size();
          System.out.println(noOfRows);

          int noOfCols = driver.findElements(By.xpath("//div[@class='extra spaced']/div[2]/table/tbody/tr[1]/td")).size();
          System.out.println(noOfCols);

          String secRowSecColText = driver.findElement(By.xpath("//div[@class='extra spaced']/div[2]/table/tbody/tr[2]/td[2]")).getText();
          System.out.println(secRowSecColText);

          WebElement col1Header = driver.findElement(By.xpath("//div[@class='extra spaced']/div[2]/table/thead/tr/th"));
          col1Header.click();

          secRowSecColText = driver.findElement(By.xpath("//div[@class='extra spaced']/div[2]/table/tbody/tr[2]/td[2]")).getText();
          System.out.println(secRowSecColText);

          // Print the cell values of the footer
          List<WebElement> footerVal = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
          System.out.println("Cell values of the footer: ");
          for(WebElement cellVal : footerVal) {
              System.out.println(cellVal.getText());
          }

          driver.quit();

      }


}
