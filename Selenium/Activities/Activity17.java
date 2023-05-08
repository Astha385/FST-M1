package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity17 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/selects");

        System.out.println(driver.getTitle());

        WebElement singleSelect = driver.findElement(By.id("single-select"));
        Select select = new Select(singleSelect);
        select.selectByVisibleText("Option 2");
        select.selectByIndex(2);
        select.selectByValue("4");

        List<WebElement> allOptions = select.getOptions();
        System.out.println(allOptions);

        Thread.sleep(2000);
        driver.quit();
    }
}
