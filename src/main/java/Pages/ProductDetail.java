package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetail extends BasePage {

    @FindBy(id = "add-to-wishlist-button-submit")
    private WebElement btnMyList;

    @FindBy(id = "list-name")
    private WebElement txtMyList;

    @FindBy(xpath = "//*[@id='wl-redesigned-create-list']/span/span/input")
    private WebElement btnCreateList;

    @FindBy(xpath = "//a[text()='Görüntüle: Liste']")
    private WebElement btnViewList;

    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement btnClosePopup;

    public ProductDetail(WebDriver driver) {
        super(driver);
    }
    public void createAndAdd(String list){
       clickList();
       setListName(list);
       wait(5);
        elementClickable(btnCreateList);
        elementClickable(btnClosePopup);
    }

    public void clickList(){
        btnMyList.click();
    }
    public void setListName(String listName){
        txtMyList.clear();
        txtMyList.sendKeys(listName);
    }
}
