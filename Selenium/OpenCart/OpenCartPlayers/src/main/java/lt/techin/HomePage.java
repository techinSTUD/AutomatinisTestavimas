package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

@FindBy(linkText = "MP3 Players")
private WebElement clickMp3Players;
@FindBy(linkText = "Show All MP3 Players")
private WebElement clickShowAll;
@FindBy(css = "button#button-list")
private WebElement clickShowAsList;



    public HomePage(WebDriver driver) {
        super(driver);
    }


    void clickMp3Players() {
        clickMp3Players.click();
    }
    void clickShowAll() {
        clickShowAll.click();
    }

    void clickShowAsList() {
        clickShowAsList.click();
    }

    public void productList(String productName){

    }

}
