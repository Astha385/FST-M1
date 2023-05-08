package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity15 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-attributes");
        System.out.println(driver.getTitle());
        WebElement userName = driver.findElement(By.xpath("//div[@class='ui two column very relaxed stackable grid']/div[1]/div/div/div[1]/input"));
        WebElement passWord = driver.findElement(By.xpath("//div[@class='ui two column very relaxed stackable grid']/div[1]/div/div/div[2]/input"));
        WebElement logInButton = driver.findElement(By.xpath("//div[@class='ui two column very relaxed stackable grid']/div[1]/div/div/button"));

        userName.sendKeys("admin");
        passWord.sendKeys("password");
        logInButton.click();

        WebElement confirmMessage = driver.findElement(By.id("action-confirmation"));
        System.out.println(confirmMessage.getText());

        driver.quit();
    }
}
