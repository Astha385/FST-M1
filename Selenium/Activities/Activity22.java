package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity22 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/selenium/popups");
        System.out.println(driver.getTitle());
        WebElement signIn = driver.findElement(By.className("orange"));
        Actions action = new Actions(driver);
        action.moveToElement(signIn).perform();

        String tooltipMessage = signIn.getAttribute("data-tooltip");
        System.out.println(tooltipMessage);
        signIn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        WebElement userName = driver.findElement(By.id("username"));
        WebElement passWord = driver.findElement(By.id("password"));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ui green button']")));
        WebElement logIn = driver.findElement(By.xpath("//button[@class='ui green button']"));

        userName.sendKeys("admin");
        passWord.sendKeys("password");
        logIn.click();

        WebElement loginConfirmation = driver.findElement(By.id("action-confirmation"));
        String loginConfirmationText = loginConfirmation.getText();
        System.out.println(loginConfirmationText);

        driver.quit();
        }
    }


