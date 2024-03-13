package week5_Assignments;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class TaskThreeTest extends Tests{
    // Task 3
    @Test
    public void ScrollDawnTest() throws AWTException, InterruptedException{
        //Go to Amazon
        bot.navigate("https://www.amazon.com/");

        //Scroll to the bottom of the page using a robot
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);
        Thread.sleep(1000);

        // Click on the "Back to top" web element
        WebElement backToTop = driver.findElement(By.id("navBackToTop"));
        backToTop.click();
        Thread.sleep(1000);

        //Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
        WebElement amazonLogo = driver.findElement(By.xpath("//div[contains(@class, 'navFooterLogoLine')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", (amazonLogo));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", (amazonLogo));
        Thread.sleep(1000);

        //Use Actions to type "ClarusWay" in the search box and perform the search
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver);
        actions.sendKeys(searchBox, "ClarusWay").sendKeys(Keys.ENTER).build().perform();

    }
}
