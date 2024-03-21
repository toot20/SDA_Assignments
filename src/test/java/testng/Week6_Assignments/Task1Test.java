package testng.Week6_Assignments;


import org.testng.annotations.Test;
import testng.Tests;

public class Task1Test extends Tests {
    /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
    @Test
    public void FacebookTest(){

        bot.navigate("https://www.facebook.com/");
    }
    @Test(dependsOnMethods = {"FacebookTest"})
    public void GoogleTest(){

        bot.navigate("https://www.Google.com/");
    }
    @Test(dependsOnMethods = {"GoogleTest"})
    public void AmazonTest(){
        bot.navigate("https://www.Amazon.com/");
    }

}
