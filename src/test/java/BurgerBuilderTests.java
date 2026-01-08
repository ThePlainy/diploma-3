import burgerpages.MainPage;
import com.sun.tools.javac.Main;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Constants;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BurgerBuilderTests {

    public WebDriver driver;

    @Before
    public void startup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
        driver.get(Constants.BURGER_MAIN_PAGE);
        driver.manage().window().maximize();
    }

    @Test
    public void sauceConstructButtonShouldBecomeActiveOnClick(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.sauceConstructButtonClick();
        assertThat(objMainPage.getActiveConstructButtonText(), is("Соусы"));
    }

    @Test
    public void fillingsConstructButtonShouldBecomeActiveOnClick(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.fillingsConstructButtonClick();
        assertThat(objMainPage.getActiveConstructButtonText(), is("Начинки"));
    }

    @Test
    public void bunConstructButtonShouldBecomeActiveOnClick(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.sauceConstructButtonClick();
        objMainPage.bunConstructButtonClick();
        assertThat(objMainPage.getActiveConstructButtonText(), is("Булки"));
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
