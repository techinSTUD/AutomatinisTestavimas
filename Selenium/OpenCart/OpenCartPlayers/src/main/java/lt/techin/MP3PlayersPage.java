package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MP3PlayersPage extends BasePage {


    @FindBy(css = "button#button-list")
    private WebElement checkListOrGrid;
    @FindBy(css = "#product-list h4")
    private List<WebElement> productList;

    public MP3PlayersPage(WebDriver driver) {
        super(driver);
    }


    boolean checkListOrGrid() {
        return checkListOrGrid.isDisplayed();
    }

    public List<String> getProductsInList() {

        List<String> itemName = new ArrayList<>();
        for (WebElement product : productList) {
            itemName.add(product.getText());
        }

        return productList.stream().map(WebElement::getText).collect(Collectors.toList());

    }
}