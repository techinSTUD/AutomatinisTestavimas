package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;


public class AddToDoJobPage extends BasePage {

    @FindBy(xpath = "//div[@id='container']/input[@type='text']")
    WebElement clickAdd;










    public AddToDoJobPage(WebDriver driver) {
        super(driver);
    }

    public void clickAdd(String name) {
        clickAdd.click();
        clickAdd.sendKeys();
        clickAdd.sendKeys(Keys.ENTER);
    }


    public void checkSize() {

    }


}
