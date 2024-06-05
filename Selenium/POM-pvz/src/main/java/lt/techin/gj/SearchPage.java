package lt.techin.gj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "div#search > input[name='search']")
    WebElement inputSearch;
    @FindBy(css = "div#search > .btn.btn-lg.btn-light")
    WebElement submitSearch;
    @FindBy (css = "div#content > h2")
    WebElement searchCriteria;

    @FindBy (css = "div#content > p")
    WebElement negativeCriteria;
    @FindBy (css = "div#product-list > div:nth-of-type(1) form[method='post']  button[title='Add to Cart']")
    WebElement addToCart;

    public void inputSearch(String itemName) {
        inputSearch.sendKeys(itemName);
    }

    public void ClickSearch() {
        submitSearch.click();
    }

    public String positiveCriteria() {

        return searchCriteria.getText();
    }

    public String negativeCriteria() {

        return negativeCriteria.getText();
    }

    public void itemToCart() {
        addToCart.click();

    }


}
