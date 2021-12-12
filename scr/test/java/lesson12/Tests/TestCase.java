package lesson12.Tests;

import lesson12.Pages.Enums.Gender;
import lesson12.Pages.Enums.Hobbies;
import lesson12.Pages.FormPage;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestCase extends Setup {

    @Test(dataProvider = "testData")
    public void testPracticeFormsPage(String FirstName, String LastName, String UserEmail, String MobilePhone)
            throws InterruptedException {
        formPage = new FormPage(driver);
        formPage.openFormPageURL();
        formPage.removeADS();
        formPage.setFirstName(FirstName);
        formPage.setLastName(LastName);
        formPage.setUserEmail(UserEmail);
        formPage.selectCheckboxGender(Gender.MALE);
        formPage.setMobilePhone(MobilePhone);
        formPage.selectHobbiesCheckboxes(Hobbies.MUSIC);
        formPage.clickSubmitBtn();
        Thread.sleep(1000);
        Assert.assertEquals(formPage.notificationWindow(), true);
    }

}

