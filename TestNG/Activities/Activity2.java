package activities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void test1(){
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(driver.getTitle(), "Target Practice" );
    }

    @Test
    public void test2(){
        WebElement backButton = driver.findElement(By.xpath("//i[@class='left arrow icon']"));
        Assert.assertFalse(backButton.isDisplayed());
    }

    @Test (enabled = false)
    public void test3(){
        System.out.println("This test is skipped without being mentione");
    }

    @Test
    public void test4(){
        System.out.println("This test is skipped");
        throw new SkipException("This test is skipped and mentioned");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
