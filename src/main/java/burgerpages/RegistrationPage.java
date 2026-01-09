package burgerpages;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    public final WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver=driver;
    }

    private final By registrationNameField = By.xpath(".//label[text()='Имя']");
    private final By registrationEmailField = By.xpath(".//label[text()='Email']");
    private final By registrationPasswordField = By.xpath(".//label[text()='Пароль']");
    private final By activeField = By.xpath(".//div[contains(@class, 'input_status_active')]//input");
    private final By registrationButton = By.cssSelector (".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");
    private final By wrongPasswordError = By.xpath(".//*[text()='Некорректный пароль']");
    private final By loginButton = By.cssSelector(".Auth_link__1fOlj");

    @Step("Заполнение поля Имя")
    public void setName(User user){
        driver.findElement(registrationNameField).click();
        driver.findElement(activeField).sendKeys(user.getName());
    }

    @Step("Заполнение поля email")
    public void setEmail(User user){
        driver.findElement(registrationEmailField).click();
        driver.findElement(activeField).sendKeys(user.getEmail());
    }

    @Step("Заполнение поля пароль")
    public void setPassword(User user){
        driver.findElement(registrationPasswordField).click();
        driver.findElement(activeField).sendKeys(user.getPassword() );
    }

    @Step("Нажатие на кнопку Зарегистрироваться")
    public void registrationButtonClick(){
        driver.findElement(registrationButton).click();
    }

    @Step("Нажатие на кнопку Войти")
    public void loginButtonClick(){
        driver.findElement(loginButton).click();
    }

    public By getWrongPasswordErrorBy(){
        return wrongPasswordError;
    }
}
