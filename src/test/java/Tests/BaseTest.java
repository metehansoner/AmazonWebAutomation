package Tests;

import DriverFactory.DriverFactory;
import Utils.ConfigLoader;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


public class BaseTest {

    protected static WebDriver driver;
    protected static ConfigLoader configLoader;

    @Before
    public  void start() {
        this.configLoader=new ConfigLoader();
        this.driver = new DriverFactory().createInstance(configLoader.getBrowser());

    }

    @After
    public  void stop() {
        driver.quit();
    }
}
