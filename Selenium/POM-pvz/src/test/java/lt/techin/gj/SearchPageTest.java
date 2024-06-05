package lt.techin.gj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchPageTest extends BaseTest {


    @Test
    void itemSearchPositiveTest() throws InterruptedException {

        {
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);
            SearchPage searchPage = new SearchPage(driver);


            homePage.clickDropDownMyAccount();
            homePage.clickDropDownLoginButton();


            loginPage.inputEmailField("bebras15@example.com");
            loginPage.inputPasswordField("Test1234");
            loginPage.submitButton();

            Thread.sleep(1000);

            searchPage.inputSearch("MacBook");
            searchPage.ClickSearch();

            Thread.sleep(1000);

            String expected = "Products meeting the search criteria";
            String actual = searchPage.positiveCriteria();
            Assertions.assertEquals(expected, actual);

            searchPage.itemToCart();

        }

    }

    @Test
    void itemSearchNegativeTest() throws InterruptedException {

        {
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);
            SearchPage searchPage = new SearchPage(driver);


            homePage.clickDropDownMyAccount();
            homePage.clickDropDownLoginButton();


            loginPage.inputEmailField("bebras15@example.com");
            loginPage.inputPasswordField("Test1234");
            loginPage.submitButton();

            Thread.sleep(1000);

            searchPage.inputSearch("MaxBook");
            searchPage.ClickSearch();

            Thread.sleep(1000);

            String expected = "There is no product that matches the search criteria.";
            String actual = searchPage.negativeCriteria();
            Assertions.assertEquals(expected, actual);

        }

    }


}
