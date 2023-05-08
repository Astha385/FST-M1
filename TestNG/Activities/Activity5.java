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

public class Activity5 {

    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){

        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");

    }

    @Test
    public void getTitleTest() {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Target Practice");
    }
       @Test (dependsOnMethods={"getTitleTest"}, groups = {"HeaderTests"})
       public void headerTest1() {
           WebElement header3 = driver.findElement(By.xpath("//h3[@class='ui yellow header']"));
           String header3Text = header3.getText();
           System.out.println(header3Text);
           Assert.assertEquals(header3Text, "Third header");
       }
       @Test (dependsOnMethods={"getTitleTest"}, groups = {"HeaderTests"})
        public void headerTest2() {
           WebElement header5 = driver.findElement(By.xpath("//h5[@class='ui green header']"));
           String header5Color = header5.getCssValue("color");
           System.out.println(header5Color);
           Assert.assertEquals(header5Color, "rgb(33, 186, 69)");
       }

       @Test (dependsOnMethods={"getTitleTest"}, groups = {"ButtonTests"})
        public void buttonTest1() {
           WebElement oliveButton = driver.findElement(By.xpath("//button[@class='ui olive button']"));
           String oliveButtonString = oliveButton.getText();
           System.out.println(oliveButtonString);
           Assert.assertEquals(oliveButtonString, "Olive");
       }
       @Test (dependsOnMethods={"getTitleTest"},groups = {"ButtonTests"})
        public void buttonTest2() {
        WebElement thirdRowFirstButton = driver.findElement(By.xpath("//button[@class='ui brown button']"));
        String thirdRowFirstButtonText = thirdRowFirstButton.getText();
        System.out.println(thirdRowFirstButtonText);
        Assert.assertEquals(thirdRowFirstButtonText, "Brown");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
