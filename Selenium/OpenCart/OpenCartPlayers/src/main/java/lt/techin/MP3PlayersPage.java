package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MP3PlayersPage extends BasePage {


    @FindBy(css = "button#button-list")
    private WebElement checkListOrGrid;
    @FindBy(css = "#product-list h4")
    private List<WebElement> productList;


    @FindBy(css = "div > .product-thumb h4 > a")
    private WebElement clickProduct;

    @FindBy(css = "#input-quantity")
    private WebElement clickOnQtyInput;
    @FindBy(css = "#button-cart")
    private WebElement addToCartButton;
    @FindBy(css = "div#alert")
    private WebElement alertMessage;

    @FindBy(css = ".btn-inverse")
    private WebElement clickCartButton;
    @FindBy(css = ".btn-close")
    private WebElement clickCloseAlert;


    public MP3PlayersPage(WebDriver driver) {
        super(driver);
    }


    boolean checkListOrGrid() {
        return checkListOrGrid.isDisplayed();
    }

    public List<String> getProductsInList() {

        List<String> itemName = new ArrayList<>();
        for (WebElement clickProduct : productList) {
            itemName.add(clickProduct.getText());
        }

        return productList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickOnProduct() {
        clickProduct.click();
    }


    public void randomNumber() {


        Random random = new Random();
        int randomQuantity = random.nextInt(20) + 1;
        clickOnQtyInput.click();
        clickOnQtyInput.clear();
        clickOnQtyInput.sendKeys(Integer.toString(randomQuantity));
    }

    public void addToCartButton() {
        addToCartButton.click();
    }

    String alertMessage() {
        return alertMessage.getText();
    }

    void clickCartButton() {
        clickCartButton.click();
    }
    void clickCloseAlert() {
        clickCloseAlert.click();
    }



}