package Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver=driver;
    }

    public String getUrl(){
      return driver.getCurrentUrl();
    }

    public void scroolPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor)driver).executeScript("scroll(0,3500)");
    }

    public void scroolUpPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor)driver).executeScript("scroll(0,0)");
    }

    public void onHover(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.build().perform();
    }
    public void wait(int second){
        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }

    public void elementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        element1.click();
    }
}