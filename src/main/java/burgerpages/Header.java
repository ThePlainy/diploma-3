package burgerpages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

    private final WebDriver driver;
    public Header(WebDriver driver) {
        this.driver = driver;
    }

    private final By personalAccountButton = By.xpath(".//*[text()='Личный Кабинет']");

    @Step("Нажатие на кнопку Личный кабинет")
    public void personalAccountButtonClick(){
        driver.findElement(personalAccountButton).click();
    }
}
