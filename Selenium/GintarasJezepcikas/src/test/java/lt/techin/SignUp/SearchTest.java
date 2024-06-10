package lt.techin.SignUp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest extends BaseTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/products.csv", numLinesToSkip = 1)
    void pickProductTest(String product, String price, String discount, String size) {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.searchField(product);
        assertEquals(product.toUpperCase(), searchPage.getItemName().toUpperCase(),
                "The product name should match.");
        searchPage.clickItem();
        searchPage.wishlistButton();
        searchPage.cancelButton();

    }






}











