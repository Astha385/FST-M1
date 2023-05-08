package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;
    @BeforeClass
    public void openBrowser(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @DataProvider (name="Authentication")
    public static Object[][] credentials(){
        return new Object[][]{
                {"admin", "password"}
        };
    }
    @Test (dataProvider = "Authentication")
    public void test(String username, String password) {
        WebElement userName = driver.findElement(By.id("username"));
        WebElement passWord = driver.findElement(By.id("password"));

        userName.sendKeys(username);
        passWord.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='ui button']"));
        loginButton.click();

        WebElement actionConfirmation = driver.findElement(By.id("action-confirmation"));
        String actionConfirmationText = actionConfirmation.getText();
        System.out.println(actionConfirmationText);

    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}
