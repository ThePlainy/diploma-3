package burgerpages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Constants;

import java.time.Duration;

public class Header {

    private final WebDriver driver;
    public Header(WebDriver driver) {
        this.driver = driver;
    }

    private final By personalAccountButton = By.xpath(".//*[text()='Личный Кабинет']");

    @Step("Нажатие на кнопку Личный кабинет")
    public void personalAccountButtonClick(){
        driver.findElement(personalAccountButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.urlMatches(Constants.BURGER_LOGIN_PAGE));
    }
}
