package week5_Assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TaskOneTest extends Tests {
    // Task 1
    @Test
    public void DragAndDropButton(){
        //Go to URL: http://demo.guru99.com/test/drag_drop.html
        bot.navigate("http://demo.guru99.com/test/drag_drop.html");

        //Drag and drop the BANK button to the Account section in DEBIT SIDE
        WebElement draggedBankButton =driver.findElement(By.id("credit2"));
        WebElement droppedAccountDEBIT = driver.findElement(By.id("bank"));
        new Actions(driver).dragAndDrop(draggedBankButton, droppedAccountDEBIT).perform();

        //Drag and drop the SALES button to the Account section in CREDIT SIDE
        WebElement draggedSALESButton =driver.findElement(By.id("credit1"));
        WebElement droppedAccountCREDIT = driver.findElement(By.id("loan"));
        new Actions(driver).dragAndDrop(draggedSALESButton, droppedAccountCREDIT).perform();

        //Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        WebElement dragged5000Button =driver.findElement(By.xpath("(//li[@id = 'fourth'])[1]"));
        WebElement droppedAmountDEBIT = driver.findElement(By.id("amt7"));
        new Actions(driver).dragAndDrop(dragged5000Button, droppedAmountDEBIT).perform();

        //Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        WebElement dragged5000Button2 =driver.findElement(By.xpath("(//li[@id = 'fourth'])[2]"));
        WebElement droppedAmountCREDIT = driver.findElement(By.id("amt8"));
        new Actions(driver).dragAndDrop(dragged5000Button2, droppedAmountCREDIT).perform();

        //Verify the visibility of Perfect text.
        WebElement PerfectText = driver.findElement(By.xpath("//div[@class= 'table4_result']"));
        String actualText = PerfectText.getText();
        Assertions.assertEquals("Perfect!", actualText);


    }
}
