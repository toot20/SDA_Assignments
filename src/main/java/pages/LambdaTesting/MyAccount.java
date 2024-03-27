package pages.LambdaTesting;

import engine.ActionsBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount extends Pages {
    private By actualMessage = By.cssSelector("h1.page-title");

    public MyAccount(WebDriver driver, ActionsBot bot) {
        super(driver, bot);

    }
    public void assertRegister(String expectedMessage){
        Assert.assertEquals(bot.getText(actualMessage), expectedMessage);
    }
}
