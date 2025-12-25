package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.Loginpage;

public class NegativeLoginTest extends BaseTest {
    @Test
    public void incorrectUsernamePassword() throws InterruptedException {
        Loginpage page = new Loginpage(driver);
        page.enterUsername("panda987");
        page.enterPassword("panda987");
        page.buttonClick();
       page.errorValidation();
        takeScreenshot("incorrectCredentials");

    }


    @Test
    public void incorrectUsername() throws InterruptedException {
        Loginpage page = new Loginpage(driver);
        page.enterUsername("panda987");
        page.enterPassword("manish123");
        page.buttonClick();
        page.errorValidation();
        takeScreenshot("incorrectUsername");

    }
    @Test
    public void incorrectPassword() throws InterruptedException {
        Loginpage page = new Loginpage(driver);
        page.enterUsername("manish123");
        page.enterPassword("panda987");
        page.buttonClick();
        page.errorValidation();
        takeScreenshot("incorrectPassword");

    }
    @Test
    public void blankPassword() throws InterruptedException {
        Loginpage page = new Loginpage(driver);
        page.enterUsername("manish123");
        page.enterPassword("");
        page.buttonClick();
        page.errorValidation();
        takeScreenshot("blankPassword");

    }
    @Test
    public void blankUsername() throws InterruptedException {
        Loginpage page = new Loginpage(driver);
        page.enterUsername("");
        page.enterPassword("manish123");
        page.buttonClick();
        page.errorValidation();
        takeScreenshot("blankUsername");

    }
    @Test
    public void blankUsernamePassword() throws InterruptedException {
        Loginpage page = new Loginpage(driver);
        page.enterUsername("");
        page.enterPassword("");
        page.buttonClick();
        page.errorValidation();
        takeScreenshot("blankCredentials");

    }
}
