package lt.techin.SignUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {


    @FindBy(css = "div#_desktop_user_info .hidden-sm-down")
    private WebElement clickSignInButton;

    @FindBy(linkText = "No account? Create one here")
    private WebElement clickCreateAccount;

    @FindBy(css = "[for='field-id_gender-1'] [type]")
    private WebElement inputSocialTitle;

    @FindBy(xpath = "/html//input[@id='field-firstname']")
    private WebElement inputFirstName;

    @FindBy(css = "[name='lastname']")
    private WebElement inputLastName;

    @FindBy(css = "input#field-email")
    private WebElement inputEmail;

    @FindBy(css = "input#field-password")
    private WebElement inputPassword;

    @FindBy(css = "input#field-birthday")
    private WebElement inputBirthDate;
    @FindBy(css = "input[name='psgdpr']")
    private WebElement clickCheckBoxAgreeTerms;

    @FindBy(css = "input[name='customer_privacy']")
    private WebElement clickCheckBoxPrivacy;

    @FindBy(xpath = "//form[@id='customer-form']//button[@type='submit']")
    private WebElement clickSaveButton;
    @FindBy(linkText = "Sign out")
    private WebElement loggedIn;
    @FindBy(css = "[title] .hidden-sm-down")
    private WebElement userLogIn;

    @FindBy(css = "div#_desktop_user_info .hidden-sm-down")
    private WebElement signInButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }



    void signInButton() {
        clickSignInButton.click();
    }

    void clickCreateAccount() {
        clickCreateAccount.click();
    }

    void inputSocialTitle() {
        inputSocialTitle.click();
    }

    void inputFirstName(String FirstName) {
        inputFirstName.sendKeys(FirstName);
    }

    void inputLastName(String LastName) {
        inputLastName.sendKeys(LastName);
    }

    void inputEmail(String Email) {
        inputEmail.sendKeys(Email);
    }

    void inputPassword(String Password) {
        inputPassword.sendKeys(Password);
    }

    void inputBirthDate(String BirthDate) {
        inputBirthDate.sendKeys(BirthDate);
    }

    void clickCheckBoxAgreeTerms() {
        clickCheckBoxAgreeTerms.click();
    }

    void clickCheckBoxPrivacy() {
        clickCheckBoxPrivacy.click();
    }

    void clickSaveButton() {
        clickSaveButton.click();
    }

    String loggedIn() {

        return loggedIn.getText();
    }

    String userLogIn() {
        return userLogIn.getText();
    }

    void userLogOut() {
        loggedIn.click();
    }

    String signInField() {

        return signInButton.getText();
    }

}
