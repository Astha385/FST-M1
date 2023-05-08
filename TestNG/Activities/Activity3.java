package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;

    @BeforeClass
    public void OpenBrowser(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    public void test(){
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");
        WebElement login = driver.findElement(By.xpath("//button[@class='ui button']"));
        login.click();
        WebElement confirmMessage = driver.findElement(By.id("action-confirmation"));
        String confirmMessageText = confirmMessage.getText();
        System.out.println(confirmMessageText);
        Assert.assertEquals(confirmMessageText,"Welcome Back, admin");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
