package lt.techin.gj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LoginPageTest extends BaseTest {


    @Test
    void positiveTest() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);


        homePage.clickDropDownMyAccount();
        homePage.clickDropDownLoginButton();


        loginPage.inputEmailField("bebras15@example.com");
        loginPage.inputPasswordField("Test1234");
        loginPage.submitButton();

        Thread.sleep(1000);
        Assertions.assertEquals("My Account", loginPage.getTitle());



    }

    @Test
    void negativeTest() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickDropDownMyAccount();
        homePage.clickDropDownLoginButton();


        loginPage.inputEmailField("bebras1111@example.com");
        loginPage.inputPasswordField("Test1234");
        loginPage.submitButton();

        Thread.sleep(1000);
        Assertions.assertEquals("Account Login", loginPage.getTitle());
    }

}
