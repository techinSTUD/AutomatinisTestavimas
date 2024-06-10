package lt.techin.SignUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {


    @FindBy(css = "h4#myModalLabel")
    private WebElement productAddedSuccessfully;
    @FindBy(css = ".size .value")
    private WebElement productSize;

    @FindBy(css = ".add-to-cart.btn.btn-primary")
    private WebElement addToCartButton;
    @FindBy(css = ".modal-body .btn.btn-primary")
    private WebElement checkoutButton;

    @FindBy(css = "[aria-label='Size']")
    private WebElement sizeDropDown;


    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public String productAddedSuccessfully() {
        return wait.until(ExpectedConditions.visibilityOf(productAddedSuccessfully)).getText();
    }

    public String productSize() {
        return wait.until(ExpectedConditions.visibilityOf(productSize)).getText();
    }


    void addToCartButton() {
        addToCartButton.click();
    }

    void checkoutButton() {
        checkoutButton.click();
    }

    void sizeDropDown() {
        sizeDropDown.click();
    }

}
