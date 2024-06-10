package lt.techin.SignUp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchPage extends BasePage {

    @FindBy(css = "input[name='s']")
    private WebElement searchField;
    @FindBy(css = "h2 > a")
    private WebElement itemName;
    @FindBy(css = ".wishlist-button-product")
    private WebElement wishlistButton;
    @FindBy(css = ".modal-text")
    private WebElement getWishlistAlert;
    @FindBy(css = ".show .btn-secondary")
    private WebElement cancelButton;

    @FindBy(css = "[aria-label='Size']")
    private WebElement sizeDropDown;
    @FindBy(css = "h2 > a")
    private WebElement getItemName;
    @FindBy(css = "[value='4']")
    private WebElement getSelectedSize;


    public SearchPage(WebDriver driver) {
        super(driver);
    }


    void searchField(String ItemName) {
        searchField.click();
        searchField.sendKeys(ItemName);
        searchField.sendKeys(Keys.ENTER);
    }


    void clickItem() {
        itemName.click();
    }

    void wishlistButton() {
        wishlistButton.click();
    }

    String wishlistAlert() {
        return getWishlistAlert.getText();
    }

    void cancelButton() {
        cancelButton.click();
    }

    String getItemName() {

        return getItemName.getText();
    }

    String getSelectedSize() {
        return getSelectedSize.getText();
    }


    public void selectSize(String size) {
        selectSize(size);
    }

    public void sizeDropDown() {
        sizeDropDown.click();
    }
}

