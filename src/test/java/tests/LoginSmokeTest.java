import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginSmokeTest{

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void shouldLoginSuccessfully() {

        // 1. Open DragonStack
        driver.get("http://localhost:1234"); // change if needed

        // 2. Enter username
        WebElement username =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@placeholder='username']")
                ));
        username.sendKeys("manish123");

        // 3. Enter password
        WebElement password =
                driver.findElement(By.xpath("//input[@placeholder='password']"));
        password.sendKeys("manish123");

        // 4. Click Log In
        driver.findElement(By.xpath("//button[text()='Log In']")).click();

        // 5. Validate login success
        // Login page disappears OR home page loads
        boolean loginPageGone = wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.xpath("//button[text()='Log In']")
                )
        );

        Assert.assertTrue(loginPageGone, "Login failed – still on login page");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

