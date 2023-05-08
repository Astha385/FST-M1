package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Activity21 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/tab-opener");
        System.out.println(driver.getTitle());

        WebElement newTab = driver.findElement(By.id("launcher"));
        newTab.click();
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
     //   wait.until(ExpectedConditions.VisibilityofElementLocated(By.id("heading")));

        Thread.sleep(4000);
        Set<String> handles = driver.getWindowHandles();
        for(String handle: handles){
            System.out.println(handle);
            driver.switchTo().window(handle);
        }
        driver.quit();

    }

}
