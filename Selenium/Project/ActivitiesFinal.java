package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActivitiesFinal {

    WebDriver driver;


    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.navigate().to("https://alchemy.hguy.co/lms");
    }

    @Test
    public void activity1(){
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Alchemy LMS – An LMS Application");
        testClosure();
    }

    @Test
    public void activity2(){
        String heading = driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']")).getText();
        System.out.println(heading);
        Assert.assertEquals(heading,"Learn from Industry Experts" );
        testClosure();
    }

    @Test
    public void activity3(){
        String titleActionable = driver.findElement(By.xpath("//h3[@class='uagb-ifb-title']")).getText();
        System.out.println(titleActionable);
        Assert.assertEquals(titleActionable,"Actionable Training" );
        testClosure();
    }

    @Test
    public void activity4(){
        String titlePopular= driver.findElement(By.xpath("//div[@class='ld-course-list-items row']/div[2]/article/div[2]/h3")).getText();
        System.out.println(titlePopular);
        Assert.assertEquals(titlePopular, "Email Marketing Strategies");
        testClosure();
    }

    @Test
    public void activity5(){
        driver.findElement(By.xpath("//ul[@id='primary-menu']/li[5]/a")).click();
        String titleMyAccount = driver.getTitle();
        System.out.println(titleMyAccount);
        Assert.assertEquals(titleMyAccount, "My Account – Alchemy LMS");
        testClosure();
    }

    @Test
    public void activity6(){
        driver.findElement(By.xpath("//ul[@id='primary-menu']/li[5]/a")).click();
        driver.findElement(By.xpath("//a[@class='ld-login ld-login ld-login-text ld-login-button ld-button']")).click();
        driver.findElement(By.xpath("//form[@id='loginform']/p[1]/input")).sendKeys("root");
        driver.findElement(By.xpath("//form[@id='loginform']/p[2]/input")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//form[@id='loginform']/p[4]/input")).click();
        String username= driver.findElement(By.xpath("//ul[@id='wp-admin-bar-top-secondary']/li/a")).getText();
        System.out.println(username);
        Assert.assertEquals(username, "Howdy, root");

        testClosure();
    }

    @Test
    public void activity7(){
        driver.findElement(By.xpath("//ul[@id='primary-menu']/li[2]/a")).click();
        List<WebElement> courses = driver.findElements(By.className("entry-title"));
        for( WebElement course : courses){
            System.out.println(course.getText());
        }
        System.out.println(courses.size());
        testClosure();
    }

    @Test
    public void activity8(){
        driver.findElement(By.xpath("//ul[@id='primary-menu']/li[4]/a")).click();
        driver.findElement(By.xpath("//div[@class='wpforms-field-container']/div[1]/input")).sendKeys("Astha123");
        driver.findElement(By.xpath("//div[@class='wpforms-field-container']/div[2]/input")).sendKeys("abc.def@gmail.com");
        driver.findElement(By.xpath("//div[@class='wpforms-field-container']/div[3]/input")).sendKeys("Regarding Activity Submission");
        driver.findElement(By.id("wpforms-8-field_2")).sendKeys("What is the last day to submit the activity");
        driver.findElement(By.name("wpforms[submit]")).click();
        WebElement confirmMessage = driver.findElement(By.id("wpforms-confirmation-8"));
        System.out.println(confirmMessage.getText());
        testClosure();
    }

    @Test
    public void activity9(){
        login();
        driver.findElement(By.xpath("//ul[@id='primary-menu']/li[2]/a")).click();
        driver.findElement(By.xpath("//div[@class='ld_course_grid col-sm-8 col-md-4 ']/article/div[2]/p[2]")).click();
        WebElement lesson = driver.findElement(By.id("ld-expand-83"));
        lesson.click();
        String lessonTitle = driver.getTitle();
        System.out.println(lessonTitle);
        Assert.assertEquals(lessonTitle, "Developing Strategy – Alchemy LMS");
        WebElement progressPercentage = driver.findElement(By.xpath("//div[@class='ld-progress-percentage ld-secondary-color']"));
      //  System.out.println(markCompleteText);
      //  Assert.assertTrue(markComplete.isDisplayed());
        String progressPercentageText = progressPercentage.getText();
        System.out.println(progressPercentageText);
        Assert.assertEquals(progressPercentageText, "12% COMPLETE");
        testClosure();
    }

    public void login(){
        driver.findElement(By.xpath("//ul[@id='primary-menu']/li[5]/a")).click();
        driver.findElement(By.xpath("//a[@class='ld-login ld-login ld-login-text ld-login-button ld-button']")).click();
        driver.findElement(By.xpath("//form[@id='loginform']/p[1]/input")).sendKeys("root");
        driver.findElement(By.xpath("//form[@id='loginform']/p[2]/input")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//form[@id='loginform']/p[4]/input")).click();
    }
    public void testClosure(){

        driver.quit();
    }

}
