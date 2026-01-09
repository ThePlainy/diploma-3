package burgerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {

    public final WebDriver driver;
    public PasswordRecoveryPage(WebDriver driver){
        this.driver=driver;
    }

    private final By loginButton = By.cssSelector(".Auth_link__1fOlj");

    public void loginButtonClick(){
        driver.findElement(loginButton).click();
    }
}
