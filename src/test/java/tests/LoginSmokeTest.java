package tests;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import pages.Loginpage;

import java.time.Duration;



public class LoginSmokeTest extends BaseTest {

    @Test
    public void LoginTest() {
        Loginpage page = new Loginpage(driver);
        page.enterUsername("manish123");
        page.enterPassword("manish123");
        page.loginButtonClick();
        page.logoutValidation();


    }


}

