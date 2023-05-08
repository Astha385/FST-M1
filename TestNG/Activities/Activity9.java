package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity9 {

    WebDriver driver;
    @BeforeTest
    public void openBrowserTest(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        Reporter.log("Browser launched");
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log("URL opened ");
    }

    @BeforeMethod
    public void switchToParent(){
        Reporter.log("Tests started");
        driver.switchTo().defaultContent();
    }

    @Test
    public void simpleAlertTest(){
        WebElement simpleAlert = driver.findElement(By.id("simple"));
        simpleAlert.click();
        Reporter.log("Simple alert has opened");

        Alert alert1 = driver.switchTo().alert();
        Reporter.log("Switched to Simple Alert");

        String simpleAlertText = alert1.getText();
        Assert.assertEquals(simpleAlertText,"This is a JavaScript Alert!");
        Reporter.log("Assert for simple alert has passed");

        alert1.accept();
        Reporter.log("simpleAlertTestCase Executed successfully");
    }

    @Test
    public void confirmAlertTest(){
        WebElement confirmAlert = driver.findElement(By.id("confirm"));
        confirmAlert.click();
        Reporter.log("Confirm alert has opened");

        Alert alert2 = driver.switchTo().alert();
        Reporter.log("Switched to confirm Alert");

        String confirmAlertText = alert2.getText();
        Assert.assertEquals(confirmAlertText, "This is a JavaScript Confirmation!");
        Reporter.log("Assert for confirm alert has passed");

        alert2.accept();
        Reporter.log("confirmAlertTestCase Executed successfully");
    }

    @Test
    public void promptAlertTest(){
        WebElement promptAlert = driver.findElement(By.id("prompt"));
        promptAlert.click();
        Reporter.log("Prompt alert has opened");

        Alert alert3 = driver.switchTo().alert();
        Reporter.log("Switched to prompt Alert");

        String promptAlertText = alert3.getText();
        Assert.assertEquals(promptAlertText, "This is a JavaScript Prompt!");
        Reporter.log("Assert for prompt alert has passed");

        alert3.sendKeys("Prompt Alert input");
        Reporter.log("promptAlertTestCase Executed successfully");

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
