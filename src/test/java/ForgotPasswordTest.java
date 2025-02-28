import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {

    @BeforeClass
    public void startTest() {
        setup();
        driver.get("https://app-staging.nokodr.com/forgot-password");
    }

    @Test
    public void testValidForgotPassword() {
        driver.findElement(By.id("email")).sendKeys("ragini@test.com");
        driver.findElement(By.id("resetButton")).click();

        WebElement successMsg = driver.findElement(By.id("successMessage"));
        Assert.assertTrue(successMsg.isDisplayed(), "Password reset failed!");
    }

    @Test
    public void testInvalidEmail() {
        driver.findElement(By.id("email")).sendKeys("invalid-email");
        driver.findElement(By.id("resetButton")).click();

        WebElement errorMsg = driver.findElement(By.id("errorMessage"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Invalid email test failed!");
    }

    @AfterClass
    public void closeTest() {
        tearDown();
    }
}