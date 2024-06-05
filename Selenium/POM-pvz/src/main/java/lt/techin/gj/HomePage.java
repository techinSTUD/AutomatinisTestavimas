package lt.techin.gj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy (css = ".float-end.nav > .list-inline .dropdown-toggle > .fa-caret-down.fa-solid")
    WebElement chooseMyAccount;
    @FindBy(css = ".dropdown-menu.dropdown-menu-right.show > li:nth-of-type(2) > .dropdown-item")
    WebElement chooseLoginButton;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickDropDownMyAccount() {
        chooseMyAccount.click();

    }

    public void clickDropDownLoginButton() {
        chooseLoginButton.click();
    }


}

