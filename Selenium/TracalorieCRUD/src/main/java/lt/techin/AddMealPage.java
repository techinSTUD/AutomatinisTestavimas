package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class AddMealPage extends BasePage {

    @FindBy(id = "item-name")
    private WebElement inputAddMeal;

    @FindBy(id = "item-calories")
    private WebElement inputAddCalories;

    @FindBy(css = "[class='add-btn btn blue darken-3']")
    private WebElement clickButton;

    @FindBy(css = "ul#item-list")
    private List<WebElement> allMeals;

    @FindBy(css = ".fa-pencil")
    private WebElement editButton;

    @FindBy(css = ".update-btn")
    private WebElement updateMeal;

    @FindBy(css = ".delete-btn")
    private WebElement deleteButton;
    @FindBy(css = ".blue.btn.clear-btn.lighten-3")
    private WebElement deleteAllButton;
    @FindBy(css = ".back-btn.btn.grey.pull-right")
    private WebElement backButton;
    @FindBy(css = ".total-calories")
    private WebElement totalCalories;

    public AddMealPage(WebDriver driver) {
        super(driver);
    }


    public void inputAddMeal(String mealName) {
        inputAddMeal.click();
        inputAddMeal.clear();
        inputAddMeal.sendKeys(mealName);
    }


    public void inputAddCalories(String calories) {
        inputAddCalories.click();
        inputAddCalories.clear();
        inputAddCalories.sendKeys(calories);
    }

    public void clickButton() {
        clickButton.click();
    }

    public List<String> getMeals() {


        List<String> list = new ArrayList<>();
        for (WebElement allMeal : allMeals) {
            String text = allMeal.getText();
            list.add(text);
        }
        return list;
    }

    public void editButton() {
        editButton.click();
    }

    public void updateMeal() {
        updateMeal.click();
    }

    public void deleteButton() {
        deleteButton.click();
    }

    public void deleteAllButton() {
        deleteAllButton.click();
    }

    public void backButton() {
        backButton.click();
    }

    public String totalCalories() {

        return totalCalories.getText();
    }


}
