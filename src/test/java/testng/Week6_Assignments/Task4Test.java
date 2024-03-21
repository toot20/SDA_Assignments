package testng.Week6_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.Tests;

public class Task4Test extends Tests {
    //Open the site: http://opencart.abstracta.us/index.php?route=account/login
    //Login with that credentials
    //Email: clarusway@gmail.com
    //Password: 123456789
    //Using the Search function do it with Data Provider for Mac, iPad and Samsung.

    @Test(dataProvider = "SearchTerms")
    public void dataProviderTest(String[][] SearchTerms){
        bot.navigate("http://opencart.abstracta.us/index.php?route=account/login");
        By Email = By.id("input-email");
        By pass = By.id("input-password");
        By Login = By.xpath("//input[@type = 'submit']");

        bot.type(Email, "clarusway@gmail.com");
        bot.type(pass, "123456789");
        bot.click(Login);

        for (String[] searchData : SearchTerms) {
            bot.type(By.xpath("//input[@placeholder='Search']"),searchData[0]);
            bot.click(By.cssSelector("div#search>span>button"));
        }

    }
    @DataProvider
    public Object[][] SearchTerms() {
        // Provide the list of products to search
        Object[][] objects = new Object[1][1];

        String[][] searchData = new String[3][1];
        searchData[0][0] = "Mac";
        searchData[1][0] = "iPad";
        searchData[2][0] = "Samsung";

        objects[0][0] = searchData;
        return objects;

    }

}
