package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

public class activity1 {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
    }

    @Test
    public void test() throws InterruptedException {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Training Support");
        WebElement aboutUs = driver.findElement(By.xpath("//div[@class='ui text container']/a"));
        aboutUs.click();
        Thread.sleep(4000);
        String aboutTitle = driver.getTitle();
        System.out.println("The title of 2nd page is "+aboutTitle);
        Assert.assertEquals(aboutTitle, "About Training Support");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
