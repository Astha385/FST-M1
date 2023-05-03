package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
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
import java.util.concurrent.TimeUnit;

public class Activity1 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
       // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    @Test
    public void activityList() throws InterruptedException {

        //test parameter: tasks
        String[] tasks = {"Complete Activity with Google Tasks", "Complete Activity with Google Keep", "Complete the second Activity Google Keep"};
        for (int i = 0; i < tasks.length; i++) {
            //clicking on New Task Button
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")));
            WebElement addNewTaskBtn = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab"));
            addNewTaskBtn.click();
            //waiting for text box to appear
            Thread.sleep(2000);
            WebElement enterTaskTxtBox = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']"));
            enterTaskTxtBox.sendKeys(tasks[i]);
            WebElement saveBtn = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Save']"));
            saveBtn.click();
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name']")));
        //retrieving the added task and validating with test param
        List<WebElement> textFromTask = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name']"));
        int size = textFromTask.size();
        System.out.println(size);
        int j = tasks.length - 1;
        for (WebElement Frame : textFromTask) {
            String TaskName = Frame.getAttribute("text");
            System.out.println(TaskName);
            //validation
            System.out.println(TaskName+"---------"+ tasks[j]);
            Assert.assertEquals(TaskName, tasks[j]);
            j = j - 1;
            if(j==0) break;
        }
    }

    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
