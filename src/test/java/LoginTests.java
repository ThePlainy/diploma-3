import burgerpages.*;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.UserSteps;
import util.Constants;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest{

    protected final User user = new User();
    protected final UserSteps userSteps = new UserSteps();

    @Before
    public void startup(){

        user.withEmail(RandomStringUtils.randomAlphanumeric(10)+"@mail.ru")
                .withPassword(RandomStringUtils.randomAlphanumeric(10))
                .withName(RandomStringUtils.randomAlphabetic(10));

        user.addAccessToken(userSteps.createUser(user));
    }

    @Test
    public void userShouldLogin(){
        driver.get(Constants.BURGER_LOGIN_PAGE);
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setEmail(user);
        objLoginPage.setPassword(user);
        objLoginPage.loginButtonClick();
        MainPage objMainPage = new MainPage(driver);
        assertTrue(driver.findElement(objMainPage.getLoginButtonBy()).isDisplayed());
    }

    @Test
    public void loginButtonOnMainPageShouldLeadToLoginPage(){
        driver.get(Constants.BURGER_MAIN_PAGE);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.loginButtonClick();
        assertThat(driver.getCurrentUrl(), is(Constants.BURGER_LOGIN_PAGE));
    }

    @Test
    public void personalAccountButtonShouldLeadToLoginPage(){
        driver.get(Constants.BURGER_MAIN_PAGE);
        Header objHeader = new Header(driver);
        objHeader.personalAccountButtonClick();
        assertThat(driver.getCurrentUrl(), is(Constants.BURGER_LOGIN_PAGE));
    }

    @Test
    public void loginButtonOnRegistrationPageShouldLeadToLoginPage(){
        driver.get(Constants.BURGER_REGISTRATION_PAGE);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.loginButtonClick();
        assertThat(driver.getCurrentUrl(), is(Constants.BURGER_LOGIN_PAGE));
    }

    @Test
    public void loginButtonOnPasswordRecoveryPageShouldLeadToLoginPage(){
        driver.get(Constants.BURGER_PASSWORD_RECOVERY_PAGE);
        PasswordRecoveryPage objPasswordRecoveryPage = new PasswordRecoveryPage(driver);
        objPasswordRecoveryPage.loginButtonClick();
        assertThat(driver.getCurrentUrl(), is(Constants.BURGER_LOGIN_PAGE));
    }

    @After
    public void teardownUser(){
        userSteps.deleteUser(user);
    }
}
