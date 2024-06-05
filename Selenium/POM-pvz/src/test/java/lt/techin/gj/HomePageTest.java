package lt.techin.gj;

import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest{



    @Test
    void loginTest () {
        HomePage homePage = new HomePage(driver);
        homePage.clickDropDownMyAccount();
        homePage.clickDropDownLoginButton();
    }




}
