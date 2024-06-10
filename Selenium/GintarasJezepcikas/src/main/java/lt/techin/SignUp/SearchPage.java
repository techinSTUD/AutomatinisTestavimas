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


}
