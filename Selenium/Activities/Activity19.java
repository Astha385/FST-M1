package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/javascript-alerts");
        System.out.println(driver.getTitle());

        WebElement confirmAlert = driver.findElement(By.id("confirm"));

        confirmAlert.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(4000);
        alert.accept();
        System.out.println("Closed by accepting");

        confirmAlert.click();
        driver.switchTo().alert();
        Thread.sleep(4000);
        alert.dismiss();
        System.out.println("Closed by dismissing");

        driver.quit();

    }
}
