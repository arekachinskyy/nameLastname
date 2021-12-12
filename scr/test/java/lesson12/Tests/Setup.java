package lesson12.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson12.Pages.FormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class Setup {
    WebDriver driver;
    FormPage formPage;

    @DataProvider
    public Object[][] testData(){
        return new Object[][]{
                {"My Name", "Surname", "123@gmail.com", "1234567890"},
        };
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
