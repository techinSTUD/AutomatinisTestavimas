package lt.techin.gj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartPageTest extends BaseTest {

    @Test
    void addToCartAndCheckOut() throws InterruptedException {


            SearchPage searchPage = new SearchPage(driver);
            CartPage cartPage = new CartPage(driver);

            searchPage.inputSearch("MacBook");
            searchPage.ClickSearch();

            Thread.sleep(1000);

            String expected = "Products meeting the search criteria";
            String actual = searchPage.positiveCriteria();
            Assertions.assertEquals(expected, actual);

            searchPage.itemToCart();

            Thread.sleep(5000);
            cartPage.clickCart();
            cartPage.viewCart();
            // nebaigta



    }


}
