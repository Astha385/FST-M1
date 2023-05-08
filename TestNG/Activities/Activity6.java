package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    @BeforeClass
    public void openBrowserTest(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(" https://www.training-support.net/selenium/login-form");
    }

    @Test
    @Parameters ({"username" , "password"})
    public void test(String Username, String Password) {
        WebElement userName = driver.findElement(By.id("username"));
        WebElement passWord = driver.findElement(By.id("password"));

        userName.sendKeys(Username);
        passWord.sendKeys(Password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='ui button']"));
        loginButton.click();

    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
