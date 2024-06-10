package lt.techin.SignUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(css = ".user-info .hidden-sm-down")
    private WebElement clickSignInButton;
    @FindBy(css = "input#field-email")
    private WebElement inputFieldEmail;
    @FindBy(css = "input#field-password")
    private WebElement inputFieldPassword;
    @FindBy(css = "button#submit-login")
    private WebElement clickSubmitButton;


    public SignInPage(WebDriver driver) {
        super(driver);
    }


    void clickSignInButton() {
        clickSignInButton.click();
    }

    void inputFieldEmail(String email) {
        inputFieldEmail.sendKeys(email);
    }

    void inputFieldPassword(String password) {
        inputFieldPassword.sendKeys(password);
    }

    void clickSubmitButton() {
        clickSubmitButton.click();
    }

}
