package lt.techin.SignUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest extends BaseTest {



    @Test
    void clickOnSignInAndClickCreateAccountTest() {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.signInButton();

        Assertions.assertEquals("Login", registrationPage.getTitle());

        registrationPage.clickCreateAccount();
        Assertions.assertEquals("Registration", registrationPage.getTitle());
    }


    @Test
    void createAccountTest() {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.signInButton();
        registrationPage.clickCreateAccount();

        registrationPage.inputSocialTitle();

        String firstName = "James";
        String lastName = "Bond";
        String email = "james12@bond.ai";
        String password = "ChuckNorrisForever";
        String birthDate = "01/01/1957";

        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputBirthDate(birthDate);
        registrationPage.clickCheckBoxPrivacy();
        registrationPage.clickCheckBoxAgreeTerms();
        registrationPage.clickSaveButton();

        assertEquals("Sign out", registrationPage.loggedIn());
        assertEquals(firstName + " " + lastName,registrationPage.userLogIn());

        registrationPage.userLogOut();
        assertEquals("Sign in", registrationPage.signInField());
    }


}
