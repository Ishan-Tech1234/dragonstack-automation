package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public class SignupPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public SignupPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String username){
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\'root\']/div/div/input[1]"));
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void enterPassword(String password){
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\'root\']/div/div/input[2]"));
        usernameField.clear();
        usernameField.sendKeys(password);
    }
    public void submitSignup(){
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'root\']/div/button[2]"))
        );
        WebElement clickSignupbutton = driver.findElement(By.xpath("//*[@id=\'root\']/div/button[2]"));
        clickSignupbutton.click();
    }
    public boolean isSignupErrorVisible(){
       List<WebElement> errorMessages = driver.findElements(By.xpath("//*[@id='root']/div/div[2]"));
       return !errorMessages.isEmpty();
    }
    public boolean isCreateDragonButtonVisible(){
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'root\']/div[2]/button"))
        );
        return true;
    }

}
