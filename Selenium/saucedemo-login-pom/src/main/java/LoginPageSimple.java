import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageSimple {
    private WebDriver driver;

    public LoginPageSimple(WebDriver driver) {
        this.driver = driver;
    }

    // Elementai
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    // Metodai
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void loginWith(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

}
