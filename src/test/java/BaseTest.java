import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Constants;
import util.DriverFactory;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void startupBase() throws IOException {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
        driver.manage().window().maximize();
    }

    @After
    public void teardownBase(){
        driver.quit();
    }
}
