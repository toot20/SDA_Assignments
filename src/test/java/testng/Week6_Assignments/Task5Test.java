package testng.Week6_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testng.Tests;

import java.util.List;

public class Task5Test extends Tests {
    //Go to URL: http://crossbrowsertesting.github.io/
    //Click to To-Do App
    //Checking Box to do-4 and Checking Box to do-5
    //If both clicks worked, then the following List should be have length 2.
    //Assert that this is correct
    //Assert that the to do we added is present in the list
    //Archiving old todos
    //If our archive link worked, then the following list should have length 4.
    //Assert that this is true as well
    //Doing Cross Browser Testing.
    @Test
    public void ClickTest(){
        // Go to URL
        bot.navigate("http://crossbrowsertesting.github.io/");

        // Click To-Do App link
        By ClickToDoAppUrl = By.xpath("//a[contains(@href, 'todo')]");
        bot.click(ClickToDoAppUrl);

        // Check To-Do items 4 and 5
        WebElement checkBox4 = driver.findElement(By.name("todo-4"));
        checkBox4.click();
        WebElement checkBox5 = driver.findElement(By.name("todo-5"));
        checkBox5.click();

        // Verify the length of the list is 2
        List<WebElement> checkedItems = driver.findElements(By.xpath("//span[@class='done-true']"));
        Assert.assertEquals(checkedItems.size(), 2, "Number of checked items is incorrect");

        //Assert that this is correct
        Assert.assertTrue(checkBox4.isSelected());
        Assert.assertTrue(checkBox5.isSelected());

        // Assert that the to-do items we added are present in the list
        Assert.assertTrue(checkedItems.stream().anyMatch(item -> item.getText().contains("Build selenium grid")),
                "to do-4 is not present in the to-do list.");
        Assert.assertTrue(checkedItems.stream().anyMatch(item -> item.getText().contains("Hire an FTE to manage")),
                "to do-5 is not present in the to-do list.");

        // Archive old todos
        WebElement archiveLink = driver.findElement(By.linkText("archive"));
        archiveLink.click();


        // Verify the length of the list is 3
        List<WebElement> archivedItems = driver.findElements(By.xpath("//input[@type='checkbox']"));
        Assert.assertEquals(archivedItems.size(), 3, "Number of archived items is incorrect");

    }
}
