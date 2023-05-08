package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions action = new Actions(driver);

        driver.get("https://training-support.net/selenium/drag-drop");
        System.out.println(driver.getTitle());

        WebElement ball = driver.findElement(By.id("draggable"));

        WebElement dropzone1 = driver.findElement(By.id("droppable"));

        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        // drag and drop to dropzone 1
        action.clickAndHold(ball).moveToElement(dropzone1).release().perform();

        // drag and drop to dropzone 2
        action.dragAndDrop(ball, dropzone2).perform();

        driver.quit();
    }

}
