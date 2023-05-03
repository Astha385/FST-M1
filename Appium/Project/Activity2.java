package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    @Test
    public void createNewNote() throws InterruptedException {
        String noteTitle = "My Notes";
        String noteDescription = "Open the notes for description";
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("New text note"))).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Title']")).sendKeys(noteTitle);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Note']")).sendKeys(noteDescription);
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/browse_note_interior_content")));
        WebElement title = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title"));
        String noteTitleText = title.getAttribute("text");
        Assert.assertEquals(noteTitle, noteTitleText);
        WebElement Description = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_text_description"));
        String noteDescriptionText = Description.getAttribute("text");
        Assert.assertEquals(noteDescription, noteDescriptionText);


    }

}
