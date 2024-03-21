package testng.Week6_Assignments;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testng.Tests;

public class Task3Test extends Tests {
    /* go to "https://practicetestautomation.com/practice-test-login/"
    enter username - "student"
    enter password - "incorrectPassword"
    and login
    SOFT ASSERT the error message shown
    SOFT ASSERT the error message is "Your password is invalid!" */
    @Test
    public void softAssertionTest(){
        bot.navigate("https://practicetestautomation.com/practice-test-login/");

        By username = By.id("username");
        By password = By.id("password");
        By submit = By.id("submit");

        bot.type(username,"student");
        bot.type(password, "incorrectPassword");
        bot.click(submit);

        By ErrorMessage = By.id("error");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(ErrorMessage).getText(), "Your password is invalid!" );
        softAssert.assertTrue(driver.findElement(ErrorMessage).isDisplayed(), "Error message is not shown");

    }
}
