package lt.techin.SignUp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static lt.techin.SignUp.SearchPage.readCSV;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SearchTest extends BaseTest {


    @ParameterizedTest(name = "Find product and try to add to wishlist")
    @CsvFileSource(resources = "/products.csv", numLinesToSkip = 1)
    void pickSizeTest(String product, String price, String discount, String size) {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.searchField(product);
        assertEquals(product.toUpperCase(), searchPage.getItemName().toUpperCase());
        searchPage.clickItem();
        searchPage.selectSize(size);
        searchPage.wishlistButton();
        assertEquals("You need to be logged in to save " +
                "products in your wishlist.", searchPage.wishlistAlert());
        searchPage.cancelButton();

    }
}











