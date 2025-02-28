import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

    @BeforeClass
    public void startTest() {
        setup();
        driver.get("https://app-staging.nokodr.com/signup"); // Navigate to Signup Page
    }

    @Test
    public void testValidSignup() {
        driver.findElement(By.id("name")).sendKeys("John Doe");
        driver.findElement(By.id("email")).sendKeys("johndoe@test.com");
        driver.findElement(By.id("password")).sendKeys("Secure@123");
        driver.findElement(By.id("confirmPassword")).sendKeys("Secure@123");
        driver.findElement(By.id("signupButton")).click();

        WebElement successMsg = driver.findElement(By.id("successMessage"));
        Assert.assertTrue(successMsg.isDisplayed(), "Signup failed!");
    }

    @Test
    public void testInvalidEmail() {
        driver.findElement(By.id("email")).sendKeys("invalid-email");
        driver.findElement(By.id("signupButton")).click();

        WebElement errorMsg = driver.findElement(By.id("errorEmail"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Invalid email test failed!");
    }

    @AfterClass
    public void closeTest() {
        tearDown();
    }
}