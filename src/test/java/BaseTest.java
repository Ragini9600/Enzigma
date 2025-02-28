import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;

    public static void setup() {
        WebDriverManager.chromedriver().setup();  // Auto setup ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}