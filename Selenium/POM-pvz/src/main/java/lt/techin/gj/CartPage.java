package lt.techin.gj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(css = ".btn-inverse")
    WebElement pickCart;

    @FindBy(css = "p > a:nth-of-type(1) > strong")
    WebElement lookCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickCart() {
        pickCart.click();
    }

    public void viewCart() {
        lookCart.click();
    }


}

