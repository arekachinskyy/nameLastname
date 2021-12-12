package lesson10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestForm {
    WebDriver driver;

    private static final String URL = "https://demoqa.com/automation-practice-form";
    private static final String checkboxURL = "https://demoqa.com/checkbox";

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
    public void clickJoinButton() throws InterruptedException{
        String firstName = "My Name";
        String lastName = "My Surname";
        String myEmail = "myemail@gmail.com";
        String myMobile = "1234567890";

        driver.get(URL);
        WebElement ads = driver.findElement(By.id("adplus-anchor"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", ads);

        driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//*[@id='userEmail']")).sendKeys(myEmail);
        driver.findElement(By.xpath("//*[label='Other']")).click();
        driver.findElement(By.xpath("//*[label='Sports']")).click();
        driver.findElement(By.xpath("//*[@id='userNumber']")).sendKeys(myMobile);
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
        Thread.sleep(500);
        submit.click();
        Thread.sleep(500);

        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='modal-body']")).isDisplayed(), true);
    }

    @Test
    public void checkChecboxes() throws InterruptedException{
        By checkboxWord = By.xpath("//span[text()=\"Word File.doc\"]");
        By checkboxExcel = By.xpath("//span[text()=\"Excel File.doc\"]");
        driver.get(checkboxURL);
        WebElement trash = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", trash);

        WebElement expandAll = driver.findElement(By.xpath("//*[@class='rct-option rct-option-expand-all']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandAll);
        Thread.sleep(500);
        expandAll.click();
        Assert.assertEquals(driver.findElement(checkboxWord).isSelected(), false);
        Assert.assertEquals(driver.findElement(checkboxExcel).isSelected(), false);
        driver.findElement(checkboxWord).click();
        driver.findElement(checkboxExcel).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class = 'text-success' ][contains(text(), 'downloads')]"))
                .isDisplayed(), true);
    }
}


