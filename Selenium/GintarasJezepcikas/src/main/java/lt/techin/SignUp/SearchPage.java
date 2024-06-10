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
    private WebElement wishlistAlert;
    @FindBy(css = ".show .btn-secondary")
    private WebElement cancelButton;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    void searchField(String ItemName) {
        searchField.click();
        searchField.sendKeys(ItemName);
        searchField.sendKeys(Keys.ENTER);
    }

    String itemName() {
        return itemName.getText();
    }

    void clickItem() {
        itemName.click();
    }

    void wishlistButton() {
        wishlistButton.click();
    }

    String wishlistAlert() {
       return wishlistAlert.getText();
    }

    void cancelButton() {
        cancelButton.click();
    }

}
