package lesson7;

import lecture3.Lucky;
import org.testng.Assert;
import org.testng.annotations.*;



public class TestLucky {
    private Lucky lucky = new Lucky();

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is text before each test");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("This is test after each test");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before all tests ....");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After all tests ....");
    }

    @DataProvider(name="numbers")
    public Object[][] randomNumbers(){
        int[] arrNumber = {15, 8, 24, 41, 9, 84};
        return new Object[][]{
                {arrNumber, 1, "I am lucky"},
        };
    }
    @DataProvider(name="numbersWrong")
    public Object[][] randomNumbers2(){
        int[] arrNumber = {15, 8, 24, 41, 9, 84};
        return new Object[][]{
                {arrNumber, 0, "Run again"},
        };
    }

    @Test(dataProvider = "numbers")
    public void testLuckyNumber(int[] arrayNumber, int index, String result){
        Assert.assertEquals(lucky.checkInteger(arrayNumber, index), result);
    }
    @Test(dataProvider = "numbersWrong")
    public void testLuckyNumber2(int[] arrayNumber, int index, String result){
        Assert.assertEquals(lucky.checkInteger(arrayNumber, index), result);
    }

}
