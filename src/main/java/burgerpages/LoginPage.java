package burgerpages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public final WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    private final By loginEmailField = By.xpath(".//label[text()='Email']");
    private final By loginPasswordField = By.xpath(".//label[text()='Пароль']");
    private final By activeField = By.xpath(".//div[contains(@class, 'input_status_active')]//input");
    private final By loginButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    public void setEmail(User user){
        driver.findElement(loginEmailField).click();
        driver.findElement(activeField).sendKeys(user.getEmail());
    }

    public void setPassword(User user){
        driver.findElement(loginPasswordField).click();
        driver.findElement(activeField).sendKeys(user.getPassword());
    }

    public void loginButtonClick(){
        driver.findElement(loginButton).click();
    }


}
