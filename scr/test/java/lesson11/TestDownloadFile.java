package lesson11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestDownloadFile {
    WebDriver driver;

    private static final String URL = "https://demoqa.com/";
    private static final By item = By.xpath("(//*[@id='item-7'])[1]");

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void dowloadFile() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(URL);
        WebElement ads = driver.findElement(By.id("adplus-anchor"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", ads);
        driver.findElement(By.xpath("//*[contains(h5,'Elements')]")).click();
        WebElement menuItem = driver.findElement(By.xpath("//span[contains(text(), 'Upload and Download')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item.findElement(menuItem));
        wait.until(ExpectedConditions.elementToBeClickable(menuItem)).click();
        driver.findElement(By.id("downloadButton")).click();
        File newFile = new File("//Users/andreyrekachinskyy/Downloads/sampleFile.jpeg");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='uploadFile']")).sendKeys(newFile.getAbsolutePath());
        boolean isVisible = driver.findElement(By.xpath("//*[@id='uploadedFilePath']")).isDisplayed();
        Assert.assertEquals(isVisible,true);
    }
}