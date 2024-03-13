package week5_Assignments;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TaskTwoTest extends Tests{
    /*Task 2 ( This task should be managed with keyboard actions ) */
    @Test
    public void SearchGoogle(){
        // go to https://www.google.com/
        bot.navigate("https://www.google.com/");

        // search for "Scroll Methods" by using an Actions object
        WebElement Search = driver.findElement(By.id("APjFqb"));
        new Actions(driver)
                .sendKeys(Search,"Scroll Methods" + Keys.RETURN)
                .perform();
    }
}
