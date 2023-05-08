package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/login-form");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");

        driver.findElement(By.xpath("//button[@class='ui button']")).click();

        String ConfirmMessage = driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
        System.out.println(ConfirmMessage);

        driver.quit();
    }
}
