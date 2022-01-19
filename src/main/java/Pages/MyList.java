package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyList extends BasePage{
    @FindBy(id = "g-items")
    private WebElement listItem;

    @FindBy(id = "nav-link-accountList")
    private WebElement myAccountTab;

    @FindBy(id = "profile-list-name")
    private WebElement txtListName;

    @FindBy(id = "submit.deleteItem")
    private WebElement btnDeletItem;

    @FindBy(id = "//h2[@class='a-size-base']")
    private WebElement itemIsDelete;

    @FindBy(xpath = "//*[@id='nav-flyout-wl-items']/div/a/span")
    private WebElement favoriteList;


    public MyList(WebDriver driver) {
        super(driver);
    }
    public boolean checkProduct(){
        return listItem.isDisplayed();
    }

    public void clickMyTab(String name){
        onHover(myAccountTab);
        elementClickable(favoriteList);
    }

    public boolean checkMyListPage(String listName) {
        return txtListName.isDisplayed();
    }

    public void deleteItem(){
        elementClickable(btnDeletItem);
    }

    public boolean itemIsDelete() {
        return itemIsDelete.isDisplayed();
    }
}
