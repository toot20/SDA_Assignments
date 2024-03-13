package week5_Assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

public class TaskFourTest extends Tests{
    /* Task 4
   Go to URL: http://facebook.com
  getCookies,
  addCookie,
  deleteCookieNamed,
  deleteAllCookies
*/
    @Test
    public void CookiesTest(){
        //Go to URL: http://facebook.com
        bot.navigate("http://facebook.com");

        //getCookies
        System.out.println("Initial size:" +driver.manage().getCookies().size());
        System.out.println("Initial list of cookies:");
        driver.manage().getCookies().forEach(System.out::println);

        //addCookie
        driver.manage().addCookie(new Cookie("facebook","12"));

        //deleteCookieNamed
        driver.manage().deleteCookieNamed("facebook");
        System.out.println("updated list of cookies:");
        driver.manage().getCookies().forEach(System.out::println);

        //deleteAllCookies
        driver.manage().deleteAllCookies();
        Assertions.assertEquals(0, driver.manage().getCookies().size());

    }
}
