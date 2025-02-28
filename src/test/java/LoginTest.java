import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeClass
    public void startTest() {
        setup();
        driver.get("https://app-staging.nokodr.com/login"); // Navigate to Login Page
    }

    @Test
    public void testValidLogin() {
        driver.findElement(By.id("username")).sendKeys("raginipatil@test.com");
        driver.findElement(By.id("password")).sendKeys("ragini@123");
        driver.findElement(By.id("loginButton")).click();

        WebElement dashboard = driver.findElement(By.id("dashboard"));
        Assert.assertTrue(dashboard.isDisplayed(), "Login failed!");
    }

    @Test
    public void testInvalidLogin() {
        driver.findElement(By.id("username")).sendKeys("IncorrectUser@test.com");
        driver.findElement(By.id("password")).sendKeys("Incorrectpassword@123");
        driver.findElement(By.id("loginButton")).click();

        WebElement errorMsg = driver.findElement(By.id("errorMessage"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Invalid login test failed!");
    }

    @AfterClass
    public void closeTest() {
        tearDown();
    }
}