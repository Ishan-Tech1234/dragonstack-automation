package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import base.BaseTest;

public class Loginpage  {
   private WebDriver driver;
   private WebDriverWait wait;

   public   Loginpage(WebDriver driver){
       this.driver = driver;
       this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
   }


     public  void enterUsername(String username){
         WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='username']"));
        usernameField.clear();
         usernameField.sendKeys(username);
    }
    public  void enterPassword(String password){
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public boolean logoutValidation(){
       wait.until(
               ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/button"))
       );
       return driver.findElement(By.xpath("//*[@id=\"root\"]/button")).isDisplayed();
    }
    public void loginButtonClick(){
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/button[1]"))
        );
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/button[1]"));

        loginButton.click();

    }
    public void errorValidation(){
       wait.until(
               ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div[2]"))
       );
    }
    public boolean isCreateDragonVisible(){
       wait.until(
               ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'root\']/div[2]/button"))
       );
       return driver.findElement(By.xpath("//*[@id=\'root\']/div[2]/button")).isDisplayed();
    }
    public void logoutButtonclick(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\'root\']/button"));
        executor.executeScript("arguments[0].click()",logoutButton);
    }
    public boolean isLoginButtonVisible(){
       return driver.findElement(By.xpath("//*[@id=\'root\']/div/button[1]")).isDisplayed();
    }
}
