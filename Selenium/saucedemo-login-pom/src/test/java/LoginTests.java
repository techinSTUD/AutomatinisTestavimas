import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTests extends BaseTest {


    @Test
    void standartUserLogin() {


        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        // LoginPageSimple loginPage = new LoginPageSimple(driver);

        mainPage.clickLogin();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        assertEquals("Swag Labs", inventoryPage.getLogoText());

        //assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl(), "Nesutampa nuorodos");


    }


}