package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "ap_email")
    private WebElement txtEmailInput;

    @FindBy(id = "ap_password")
    private WebElement txtPassword;

    @FindBy(id="continue")
    private WebElement btnContiniue;

    @FindBy(id = "signInSubmit")
    private WebElement btnLogin;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        txtEmailInput.sendKeys(email);
    }

    public void clickContinue(){
        btnContiniue.click();
    };

    public void setPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.click();
    }
}
