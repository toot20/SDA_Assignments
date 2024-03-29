package week5_Assignments;

import com.google.common.io.Files;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
//import java.nio.file.Files;

public class TaskSixeTest extends Tests{
    @Test
    public void ScreenShotTest() throws IOException {
        // Go to ebay.com
        bot.navigate("https://www.ebay.com/");

        // Take Full Page Screenshot.
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot, new File("target/screenshot_"+System.currentTimeMillis()+".png"));

        // Take any spesific WebElement ScreenShot
        By ebayImage = By.id("gh-la");
        File ElementScreenshot = driver.findElement(ebayImage).getScreenshotAs(OutputType.FILE);
        Files.copy(ElementScreenshot, new File("target/ElementScreenshot_"+System.currentTimeMillis()+".png"));


    }
}
