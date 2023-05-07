package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity3 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();


        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void webAppTest() throws InterruptedException {

        for(int i =0; i<4; i++) {
            Dimension dims = driver.manage().window().getSize();

            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));

            //Scroll to end by setting the start and end points
            Point start = new Point((int) (dims.width * 0.5), (int) (dims.height * 0.6));
            Point end = new Point((int) (dims.width * 0.5), (int) (dims.height * 0.1));
            Thread.sleep(2000);
            doSwipe(driver, start, end, 1000);
            Thread.sleep(3000);
        }
        //locate element and click it
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.TextView[contains(@text,'To-Do List')]"))
        ).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));
        WebElement AddTaskTxtbox=driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));
        WebElement AddTaskBtn=driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));
        AddTaskTxtbox.sendKeys("Add tasks to list");
        AddTaskBtn.click();
        Thread.sleep(2000);
        AddTaskTxtbox.sendKeys("Get number of tasks");
        AddTaskBtn.click();
        Thread.sleep(2000);
        AddTaskTxtbox.sendKeys("Clear the list");
        AddTaskBtn.click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']")).click();
        List<WebElement> tasks = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View"));
        int TasksCount = tasks.size();
        Assert.assertEquals(TasksCount,0);


    }

    public void doSwipe(AndroidDriver driver,Point start, Point end, int duration)
    {
        System.out.println("coordinates :" + start+ " "+end);
        TouchAction ts = new TouchAction(driver);
        ts.press(PointOption.point(start)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(end)).release().perform();
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
