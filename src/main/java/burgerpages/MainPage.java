package burgerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    public final WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver=driver;
    }

    private final By loginButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg");
    private final By bunConstructButton = By.xpath(".//span[text()='Булки']");
    private final By sauceConstructButton = By.xpath(".//span[text()='Соусы']");
    private final By fillingsConstructButton = By.xpath(".//span[text()='Начинки']");
    private final By activeConstructButton = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]//span");

    public void bunConstructButtonClick(){
        driver.findElement(bunConstructButton).click();
    }

    public void sauceConstructButtonClick(){
        driver.findElement(sauceConstructButton).click();
    }

    public void fillingsConstructButtonClick(){
        driver.findElement(fillingsConstructButton).click();
    }

    public String getActiveConstructButtonText(){
        return driver.findElement(activeConstructButton).getText();
    }

    public void loginButtonClick(){
        driver.findElement(loginButton).click();
    }

    public By getLoginButtonBy(){
        return loginButton;
    }
}
