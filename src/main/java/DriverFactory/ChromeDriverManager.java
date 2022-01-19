package DriverFactory;
import Utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ChromeDriverManager implements Factory {
    @Override
    public WebDriver createDriver() {
        String filePath = new File("").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver",filePath+"\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigLoader.getInstance().getBaseUrl());
        driver.manage().deleteAllCookies();
        return driver;
    }
}
