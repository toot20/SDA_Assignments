package testng.Week7_Assignments;

import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LambdaTesting.Registration;
import testng.Tests;

import java.time.Duration;

public class LambdaTest extends Tests {
    String email = "";
    String password = "";

    @Test
    public void registrationTest() {
        email = System.currentTimeMillis() + "_" + testCaseData.get("email_postfix");
        password = (String) testCaseData.get("password");

        new Registration(driver, bot)
                .goTo()
                .registerNewUser((String) testCaseData.get("firstname"),
                        (String) testCaseData.get("lastname"), email,
                        (String) testCaseData.get("phone"),password)
                .assertRegister((String) testCaseData.get("ExpectedRegistrationSuccessMessage"));
    }

    @Step("Loading Test Data")
    @BeforeClass
    public void initializeTestDataReader() {
        testCaseData = (JSONObject) testData.get("lambda");
    }
}



