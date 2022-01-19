package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "sp-cc-accept")
    private WebElement FrmCookie;

    @FindBy(id = "sp-cc-accept")
    private WebElement NvbCookie;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement BtnLogin;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement txtLoginText;

    @FindBy(id = "searchDropdownBox")
    private WebElement drpCategoryDropDown;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement txtSearchArea;

    @FindBy(id = "nav-search-submit-button")
    private WebElement btmSearch;

    @FindBy(xpath = "//*[@id='search']/div[1]/div[1]/div/span[3]/div[2]")
    private WebElement sectionSearhResult;

    @FindBy(xpath = "//*[@aria-current='page']")
    private WebElement existPagination;

    @FindBy(xpath = "//div[@data-cel-widget='search_result_1']")
    private WebElement secondProduct;

    @FindBy(className = "a-spacing-small")
    private WebElement signOutAccount;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean checkNavbar() {
        if (FrmCookie.isDisplayed()) {
            return true;
        }
        return false;
    }

    public void acceptCookies() {
        NvbCookie.click();
    }

    public void clickLogin() {
        BtnLogin.click();
    }

    public boolean checkIsLogin(String text) {
        if (!BtnLogin.getTagName().equals(text)) {
            return true;
        }
        return false;
    }

    public void selectDropDown(String text) {
        drpCategoryDropDown.click();
        driver.findElement(By.xpath("//option[text()='" + text + "'][1]")).click();
    }

    public void searchAndClickProduct(String product) {
        txtSearchArea.sendKeys(product);
        btmSearch.click();
    }

    public boolean controlSearch() {
        return sectionSearhResult.isDisplayed();
    }

    public void clickPaginition(String index) {
        driver.findElement(By.xpath("//a[text()='Sonraki']")).click();
    }

    public boolean paginationControl(String index) {
        return existPagination.isDisplayed();
    }

    public void selectProduct(){
        secondProduct.click();
    }

    public boolean isSignOut() {
        return signOutAccount.isDisplayed();
    }
}