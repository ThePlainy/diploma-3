package burgerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

    private final WebDriver driver;
    public Header(WebDriver driver) {
        this.driver = driver;
    }

    private final By personalAccountButton = By.xpath(".//*[text()='Личный Кабинет']");

    public void personalAccountButtonClick(){
        driver.findElement(personalAccountButton).click();
    }
}
