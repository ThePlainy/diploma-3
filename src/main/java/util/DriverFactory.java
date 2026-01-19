package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

public class DriverFactory {

    private final String YANDEX_DRIVER_PATH = "src/test/resources/yandexdriver.exe";
    private final String YANDEX_BINARY_PATH = "C:/Users/ThePlainy/AppData/Local/Yandex/YandexBrowser/Application/browser.exe";

    public WebDriver initDriver() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/browser.properties"));
        String browserProperty = properties.getProperty("testBrowser");
        BrowserType browserType = BrowserType.valueOf(browserProperty);
        switch (browserType){
            case CHROME:
                return new ChromeDriver();
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", YANDEX_DRIVER_PATH);
                ChromeOptions options = new ChromeOptions();
                options.setBinary(YANDEX_BINARY_PATH);
                return new ChromeDriver(options);
            default:
                throw new RemoteException("Browser undefined");
        }
    }
}
