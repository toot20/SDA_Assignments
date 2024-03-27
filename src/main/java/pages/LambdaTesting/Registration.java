package pages.LambdaTesting;

import engine.ActionsBot;
import engine.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration extends Pages{
   // private final String url = PropertiesReader.props.getProperty("baseUrl")+ "login";
    private final By firstName = By.id("input-firstname");
    private final By lastName = By.id("input-lastname");
    private final By email = By.id("input-email");
    private final By phone = By.id("input-telephone");
    private final By passwordInput = By.id("input-password");
    private final By passwordConfirm = By.id("input-confirm");
    private final By policyCheckbox = By.id("input-agree");

    public Registration(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }
    public Registration goTo(){
        bot.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        return this;
    }
    public MyAccount registerNewUser(String firstname, String lastname, String emailaddress, String phoneNumber, String password){

        bot.type(firstName, firstname);
        bot.type(lastName, lastname);
        bot.type(email, emailaddress);
        bot.type(phone, phoneNumber);
        bot.type(passwordInput, password);
        bot.type(passwordConfirm, password);
        bot.click(policyCheckbox);

        driver.findElement(policyCheckbox).submit();
        return new MyAccount(driver, bot);
    }

}
