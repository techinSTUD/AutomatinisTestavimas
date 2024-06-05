package lt.techin.gj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(id = "input-email")
    WebElement inputEmail;

    @FindBy(id = "input-password")
    WebElement inputPassword;
    @FindBy(css = "[action] .btn-primary")
    WebElement button;




    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputEmailField(String email) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }

    public void inputPasswordField(String password) {
        inputPassword.sendKeys(password);
    }

    public void submitButton() {
        button.submit();
    }



}
