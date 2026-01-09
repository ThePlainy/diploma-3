import burgerpages.*;
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

public class LoginTests {

    protected final User user = new User();
    public WebDriver driver;
    protected final UserSteps userSteps = new UserSteps();

    @Before
    public void startup(){

        user.withEmail(RandomStringUtils.randomAlphanumeric(10)+"@mail.ru")
                .withPassword(RandomStringUtils.randomAlphanumeric(10))
                .withName(RandomStringUtils.randomAlphabetic(10));

        user.addAccessToken(userSteps.createUser(user));

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
        driver.manage().window().maximize();
    }

    @Test
    public void userShouldLogin(){
        driver.get(Constants.BURGER_LOGIN_PAGE);
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setEmail(user);
        objLoginPage.setPassword(user);
        objLoginPage.loginButtonClick();
        MainPage objMainPage = new MainPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.urlMatches(Constants.BURGER_MAIN_PAGE));
        assertTrue(driver.findElement(objMainPage.loginButton).isDisplayed());
    }

    @Test
    public void loginButtonOnMainPageShouldLeadToLoginPage(){
        driver.get(Constants.BURGER_MAIN_PAGE);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.loginButtonClick();
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.urlMatches(Constants.BURGER_LOGIN_PAGE));
        assertThat(driver.getCurrentUrl(), is(Constants.BURGER_LOGIN_PAGE));
    }

    @Test
    public void personalAccountButtonShouldLeadToLoginPage(){
        driver.get(Constants.BURGER_MAIN_PAGE);
        Header objHeader = new Header(driver);
        objHeader.personalAccountButtonClick();
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.urlMatches(Constants.BURGER_LOGIN_PAGE));
        assertThat(driver.getCurrentUrl(), is(Constants.BURGER_LOGIN_PAGE));
    }

    @Test
    public void loginButtonOnRegistrationPageShouldLeadToLoginPage(){
        driver.get(Constants.BURGER_REGISTRATION_PAGE);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.loginButtonClick();
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.urlMatches(Constants.BURGER_LOGIN_PAGE));
        assertThat(driver.getCurrentUrl(), is(Constants.BURGER_LOGIN_PAGE));
    }

    @Test
    public void loginButtonOnPasswordRecoveryPageShouldLeadToLoginPage(){
        driver.get(Constants.BURGER_PASSWORD_RECOVERY_PAGE);
        PasswordRecoveryPage objPasswordRecoveryPage = new PasswordRecoveryPage(driver);
        objPasswordRecoveryPage.loginButtonClick();
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.urlMatches(Constants.BURGER_LOGIN_PAGE));
        assertThat(driver.getCurrentUrl(), is(Constants.BURGER_LOGIN_PAGE));
    }

    @After
    public void teardown(){
        userSteps.deleteUser(user);
        driver.quit();
    }
}
