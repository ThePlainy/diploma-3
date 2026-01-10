package burgerpages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Constants;

import java.time.Duration;

public class PasswordRecoveryPage {

    public final WebDriver driver;
    public PasswordRecoveryPage(WebDriver driver){
        this.driver=driver;
    }

    private final By loginButton = By.cssSelector(".Auth_link__1fOlj");

    @Step("Нажатие на кнопку Войти")
    public void loginButtonClick(){
        driver.findElement(loginButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.urlMatches(Constants.BURGER_LOGIN_PAGE));
    }
}
