package burgerpages;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Constants;

import java.time.Duration;

public class LoginPage {

    public final WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    private final By loginEmailField = By.xpath(".//label[text()='Email']");
    private final By loginPasswordField = By.xpath(".//label[text()='Пароль']");
    private final By activeField = By.xpath(".//div[contains(@class, 'input_status_active')]//input");
    private final By loginButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    @Step("Заполнение поля email")
    public void setEmail(User user){
        driver.findElement(loginEmailField).click();
        driver.findElement(activeField).sendKeys(user.getEmail());
    }

    @Step("Заполнение поля пароль")
    public void setPassword(User user){
        driver.findElement(loginPasswordField).click();
        driver.findElement(activeField).sendKeys(user.getPassword());
    }

    @Step("Нажатие на кнопку логин")
    public void loginButtonClick(){
        driver.findElement(loginButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.urlMatches(Constants.BURGER_MAIN_PAGE));
    }
}
