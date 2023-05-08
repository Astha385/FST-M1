package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Activity10 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        // Open browser
        driver.get("https://www.training-support.net/selenium/simple-form");
    }

    public static List<List<String>> readExcel(String filePath) {
        List<List<String>> data = new ArrayList<List<String>>();
        try {
            FileInputStream file = new FileInputStream(filePath);

            // Create Workbook instance holding reference to Excel file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows one by one
            for (Row cells : sheet) {
                // Temp variable
                List<String> rowData = new ArrayList<String>();
                // For each row, iterate through all the columns
                for (Cell cell : cells) {
                    if (cell != null) {
                        // Store row data
                        rowData.add(cell.getStringCellValue());
                    }
                }
                // Store row data in List
                data.add(rowData);
            }
            file.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @DataProvider(name = "Form")
    public static Object[][] signUpInfo() {
        String path = "src/test/resources/sample.xlsx";
        List<List<String>> data = readExcel(path);
        return new Object[][]{
                {data.get(1).get(1), data.get(1).get(2), data.get(1).get(3), data.get(1).get(4)},
                {data.get(2).get(1), data.get(2).get(2), data.get(2).get(3), data.get(2).get(4)},
                {data.get(3).get(1), data.get(3).get(2), data.get(3).get(3), data.get(3).get(4)},
        };
    }

    @Test(dataProvider = "Form")
    public void registerTest(String firstName, String lastName, String email, String phoneNumber) {
        // Find the input fields and enter text
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id = 'firstName']"));
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@id = 'lastName']"));
        WebElement emailInput = driver.findElement(By.xpath("//input[@id = 'email']"));
        WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@id = 'number']"));

        // Clear the fields
        firstNameInput.clear();
        lastNameInput.clear();
        emailInput.clear();
        phoneNumberInput.clear();

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        phoneNumberInput.sendKeys(phoneNumber);

        driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();

        Alert message = driver.switchTo().alert();

        System.out.println("Alert message: " + message.getText());
        message.accept();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}