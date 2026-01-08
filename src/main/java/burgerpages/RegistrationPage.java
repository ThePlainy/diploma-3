package burgerpages;

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
    public final By wrongPasswordError = By.xpath(".//*[text()='Некорректный пароль']");
    public final By loginButton = By.cssSelector(".Auth_link__1fOlj");

    public void setName(User user){
        driver.findElement(registrationNameField).click();
        driver.findElement(activeField).sendKeys(user.getName());
    }

    public void setEmail(User user){
        driver.findElement(registrationEmailField).click();
        driver.findElement(activeField).sendKeys(user.getEmail());
    }

    public void setPassword(User user){
        driver.findElement(registrationPasswordField).click();
        driver.findElement(activeField).sendKeys(user.getPassword() );
    }

    public void registrationButtonClick(){
        driver.findElement(registrationButton).click();
    }

    public void loginButtonClick(){
        driver.findElement(loginButton).click();
    }
}
