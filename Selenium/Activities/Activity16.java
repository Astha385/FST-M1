package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity16 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-attributes");
        System.out.println(driver.getTitle());

        WebElement username = driver.findElement(By.xpath("//div[@class='ui two column very relaxed stackable grid']/div[3]/div/div/div[1]/input"));
        WebElement password = driver.findElement(By.xpath("//div[@class='ui two column very relaxed stackable grid']/div[3]/div/div/div[2]/input"));
        WebElement confirmPassword = driver.findElement(By.xpath("//div[@class='ui two column very relaxed stackable grid']/div[3]/div/div/div[3]/input"));
        WebElement email = driver.findElement(By.xpath("//div[@class='ui two column very relaxed stackable grid']/div[3]/div/div/div[4]/input"));
        WebElement signUpButton = driver.findElement(By.xpath("//div[@class='ui two column very relaxed stackable grid']/div[3]/div/div/button"));

        username.sendKeys("admin1");
        password.sendKeys("password");
        confirmPassword.sendKeys("password");
        email.sendKeys("abc1@gmail.com");
        signUpButton.click();

        WebElement confirmMessage = driver.findElement(By.id("action-confirmation"));
        System.out.println(confirmMessage.getText());

        driver.quit();

    }
}
