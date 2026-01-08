import burgerpages.RegistrationPage;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.UserSteps;
import util.Constants;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class RegistrationTests {

    protected final User user = new User();
    public WebDriver driver;
    protected final UserSteps userSteps = new UserSteps();

    @Before
    public void startup(){

        user.withEmail(RandomStringUtils.randomAlphanumeric(10)+"@mail.ru")
                .withPassword(RandomStringUtils.randomAlphanumeric(10))
                .withName(RandomStringUtils.randomAlphabetic(10));

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
        driver.get(Constants.BURGER_REGISTRATION_PAGE);
        driver.manage().window().maximize();
    }

    @Test
    public void userShouldBeRegistered(){
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.setName(user);
        objRegistrationPage.setEmail(user);
        objRegistrationPage.setPassword(user);
        objRegistrationPage.registrationButtonClick();
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.urlMatches(Constants.BURGER_LOGIN_PAGE));
        assertThat(driver.getCurrentUrl(), is(Constants.BURGER_LOGIN_PAGE));
    }

    @Test
    public void userShouldGetErrorWithShortPassword(){
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        user.withPassword(RandomStringUtils.randomAlphanumeric(5));
        objRegistrationPage.setPassword(user);
        objRegistrationPage.registrationButtonClick();
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(objRegistrationPage.wrongPasswordError));
        assertTrue(driver.findElement(objRegistrationPage.wrongPasswordError).isDisplayed());
    }

    @After
    public void teardown(){
        user.addAccessToken(userSteps.loginUser(user));
        userSteps.deleteUser(user);
        driver.quit();
    }
}
