package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity4 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/target-practice");
        System.out.println(driver.getTitle());

        WebElement thirdHeader = driver.findElement(By.xpath("//h3[@id='third-header']"));
        System.out.println(thirdHeader.getText());

        //  5th header colour
        WebElement fifthHeader = driver.findElement(By.xpath("//h5[text()='Fifth header']"));
        System.out.println(fifthHeader.getCssValue("color"));

        // violet button and its classes
        WebElement violetButton = driver.findElement(By.xpath("//button[text()='Violet']"));
        System.out.println(violetButton.getAttribute("class"));

        //grey button and its text
        WebElement greyButton = driver.findElement(By.xpath("//button[text()='Grey']"));
        System.out.println(greyButton.getText());

        driver.quit();
    }

}
