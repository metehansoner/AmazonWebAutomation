package DriverFactory;

import Constants.DriverType;
import Exceptions.BrowserNotSupportedException;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public WebDriver createInstance(String browser) {
        WebDriver driver;
        DriverType browserType = DriverType.valueOf(browser.toUpperCase());

        switch (browserType) {

            case CHROME:
                driver = new ChromeDriverManager().createDriver();
                break;
            default:
                throw new BrowserNotSupportedException(browser);
                // TODO: Log Koy
        }
        return driver;
    }
}
