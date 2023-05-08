package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions action = new Actions(driver);

        driver.get("https://training-support.net/selenium/input-events");
        System.out.println(driver.getTitle());

        action.click().perform();
        String frontSideText = driver.findElement(By.className("active")).getText();
        System.out.println(frontSideText);

        action.doubleClick().perform();
        frontSideText = driver.findElement(By.className("active")).getText();
        System.out.println(frontSideText);


        action.contextClick().perform();
        frontSideText = driver.findElement(By.className("active")).getText();
        System.out.println(frontSideText);
    }
}
