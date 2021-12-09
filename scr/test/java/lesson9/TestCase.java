package lesson9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.*;
import java.util.*;

public class TestCase {
    WebDriver driver;

    private static final String URL = "https://demoqa.com/";

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
    public void clickJoinButton(){
        driver.get(URL);
        driver.findElement(By.xpath("//div[@class=\"home-banner\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), URL);
        List<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(newTab.size() - 1));
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(driver.getCurrentUrl(), currentURL);
        Assert.assertEquals(driver.getWindowHandles().size(),2);
    }
    @Test
    public void compareData(){
        driver.get(URL);
        String elementCard = driver.findElement(By.xpath("//h5[contains(text(), 'Elements')]")).getText();
        String formsCard = driver.findElement(By.xpath("//h5[contains(text(), 'Forms')]")).getText();
        String alertsCard = driver.findElement(By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]")).getText();
        String widgetsCard = driver.findElement(By.xpath("//h5[contains(text(), 'Widgets')]")).getText();
        String interactionsCard = driver.findElement(By.xpath("//h5[contains(text(), 'Interactions')]")).getText();
        String bookstoreinteractionsCard = driver.findElement(By.xpath("//h5[contains(text(), 'Book Store Application')]")).getText();
        Assert.assertEquals(elementCard, "Elements");
        Assert.assertEquals(formsCard, "Forms");
        Assert.assertEquals(alertsCard, "Alerts, Frame & Windows");
        Assert.assertEquals(widgetsCard, "Widgets");
        Assert.assertEquals(interactionsCard, "Interactions");
        Assert.assertEquals(bookstoreinteractionsCard, "Book Store Application");
    }
    @Test
    public void testElements(){
        String fullName = "May Full Name";
        String email = "myemail@gmail.com";
        String currentAddress = "my address";
        String permanentAddress = "perm. address";

        driver.get(URL);
        WebElement ads = driver.findElement(By.id("adplus-anchor"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", ads);

        driver.findElement(By.xpath("//*[contains(h5,'Elements')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Text Box')]")).click();
        driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys(fullName);
        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys(currentAddress);
        driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]")).sendKeys(permanentAddress);
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        Map<String, String> map = new HashMap<>();
        List<WebElement> dataCheck = driver.findElements(By.xpath("//div[contains(@class, 'border col-md-12 col-sm-12')]/p"));
        for (WebElement element : dataCheck)
        {
            map.put(element.getText().split(":")[0], element.getText().split(":")[1]);
        }
        Assert.assertEquals(map.containsValue(fullName), true);
        Assert.assertEquals(map.containsValue(email), true);
        Assert.assertEquals(map.containsValue(currentAddress), true);
        Assert.assertEquals(map.containsValue(permanentAddress), true);
    }
}

