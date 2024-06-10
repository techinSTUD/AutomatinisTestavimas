package lt.techin.SignUp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignInTest extends BaseTest{

    @Test
    void LoginInTest() {

        SignInPage signInPage = new SignInPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        String email = "james@bond.ai";
        String password = "ChuckNorrisForever";

        signInPage.clickSignInButton();
        signInPage.inputFieldEmail(email);
        signInPage.inputFieldPassword(password);
        signInPage.clickSubmitButton();

        assertEquals("Sign out", registrationPage.loggedIn());
        assertEquals("PrestaShop", registrationPage.getTitle());

    }
}
