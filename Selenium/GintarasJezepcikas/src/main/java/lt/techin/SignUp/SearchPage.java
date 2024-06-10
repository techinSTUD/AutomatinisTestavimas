package lt.techin.SignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public static List<String> readCSV(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        List<String> csvLines = readCSV("src/test/resources/products.csv");
        System.out.println(csvLines);
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
        return getWishlistAlert.getText();
    }

    void cancelButton() {
        cancelButton.click();
    }

    void sizeDropDown() {
        sizeDropDown.click();
    }

    String getItemName() {

        return getItemName.getText();
    }

    public void selectSize(String size) {
        WebElement sizeOption = driver.findElement(By.xpath("//option[text()='" + size + "']"));
        sizeOption.click();
    }

    public String getSelectedSize() {
        WebElement selectedSizeElement = driver.findElement(By.id("selected-size-id")); // Adjust selector as needed
        return selectedSizeElement.getText();
    }


}

