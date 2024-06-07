package lt.techin;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class HomePage extends BasePage {

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

        // Mazesniu ekranu wait
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(3))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);

        wait.until(
                d -> {
                    clickShowAsList.click();
                    return true;
                });


    }


}
