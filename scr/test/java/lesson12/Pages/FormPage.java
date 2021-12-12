package lesson12.Pages;

import lesson12.Pages.Enums.Gender;
import lesson12.Pages.Enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class FormPage {
    WebDriver driver;
    CustomLogger log = new CustomLogger();

    public static final String URL = "https://demoqa.com/automation-practice-form";
    By inputFirstName = By.xpath("//*[@id='firstName']");
    By inputLastName = By.xpath("//*[@id='lastName']");
    By inputUserEmail = By.xpath("//*[@id='userEmail']");
    By inputMobilePhone = By.xpath("//*[@id='userNumber']");
    By notificationWindow = By.xpath("//*[@class='modal-body']");

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openFormPageURL() {
        driver.get(URL);
        log.pageOpened("** Page is opened **");
    }

    public void removeADS() {
        WebElement ads = driver.findElement(By.id("adplus-anchor"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", ads);
        log.remove("*** AD is removed from page ***");
    }

    public void setFirstName(String firstName) {
        driver.findElement(inputFirstName).sendKeys(firstName);
        log.dataInput("*** First Name is added ***");
    }

    public void setLastName(String lastName) {
        driver.findElement(inputLastName).sendKeys(lastName);
        log.dataInput("*** Last Name added ***");
    }

    public void setUserEmail(String userEmail) {
        driver.findElement(inputUserEmail).sendKeys(userEmail);
        log.dataInput("*** UserEmail added ***");
    }

    public void selectCheckboxGender(Gender key) {
        HashMap<Gender, String> gender = new HashMap<Gender, String>() {{
            put(Gender.MALE, "Male");
            put(Gender.FEMALE, "Female");
            put(Gender.OTHER, "Other");
        }};
        WebElement el = driver.findElement(By.xpath("//*[label='" + gender.get(key) + "']"));
        el.click();
        log.selectItem("*** Gender checkbox is selected ***");
    }

    public void selectHobbiesCheckboxes(Hobbies key) {
        HashMap<Hobbies, String> hobbies = new HashMap<Hobbies, String>() {{
            put(Hobbies.SPORTS, "Sports");
            put(Hobbies.READING, "Reading");
            put(Hobbies.MUSIC, "Music");
        }};
        WebElement el = driver.findElement(By.xpath("//*[label='" + hobbies.get(key) + "']"));
        el.click();
        log.selectItem("*** Hobbies checkbox is selected ***");
    }

    public void setMobilePhone(String mobilePhone) {
        driver.findElement(inputMobilePhone).sendKeys(mobilePhone);
        log.dataInput("*** Mobile Phone is added ***");
    }

    public void clickSubmitBtn() {
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
        submit.click();
        log.click("*** Submit button clicked ***");
    }

    public boolean notificationWindow() {
        driver.findElement(notificationWindow).isDisplayed();
        log.pageOpened("*** Notification window is shown ***");
        return true;
    }
}