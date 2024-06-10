package lt.techin.SignUp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest extends BaseTest {


    @Test
    void searchItems() {

        String itemName = "HUMMINGBIRD PRINTED SWEATER";

        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchField(itemName);
        assertEquals(itemName, searchPage.itemName().toUpperCase());
        searchPage.clickItem();

    }

    @Test
    void searchItemsAndAddToWishlist() {

        String itemName = "HUMMINGBIRD PRINTED SWEATER";

        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchField(itemName);
        assertEquals(itemName, searchPage.itemName().toUpperCase());
        searchPage.clickItem();
        searchPage.wishlistButton();
        assertEquals("You need to be logged in to save " +
                "products in your wishlist.", searchPage.wishlistAlert());
        searchPage.cancelButton();

    }

}
