package pages;

import base.BaseTest;
import helper.apiAuthentication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class E2E_DragonStack_Dashboard extends BaseTest {
    private WebDriverWait wait;
    public E2E_DragonStack_Dashboard(WebDriver driver){

        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public void authenticateUser() {
       String cookieValue = apiAuthentication.fetchData();
       driver.get("http://localhost:3000/account");
     System.out.println(cookieValue);
        Cookie cookie = new Cookie.Builder("sessionString", cookieValue)
                .path("/")
                .build();
        driver.manage().addCookie(cookie);
        driver.get("http://localhost:1234/");
        driver.navigate().refresh();
    }
    public void clickButtonCreateDragon(){
    wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'root\']/div[2]/button"))
    );
        WebElement createDragonButton = driver.findElement(By.xpath("//*[@id=\'root\']/div[2]/button"));
        createDragonButton.click();
    }
    public boolean createDragonSuccessfull(){
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/button"))
        );
        WebElement createDragon = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/button"));
        return createDragon.isDisplayed();
    }
    public void clickLogoutButton(){
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\'root\']/button"));
        logoutButton.click();
    }
}
