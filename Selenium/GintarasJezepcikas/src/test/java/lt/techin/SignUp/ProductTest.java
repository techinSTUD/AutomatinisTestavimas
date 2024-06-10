package lt.techin.SignUp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class ProductTest extends BaseTest{

    @ParameterizedTest
    @CsvFileSource(resources = "/products.csv", numLinesToSkip = 1)
    void pickProductAndSizeTest(String product, String price, String discount, String size) {

        assertTimeout(ofSeconds(10), () -> {

        SearchPage searchPage = new SearchPage(driver);
        ProductPage productPage = new ProductPage(driver);

        searchPage.searchField(product);
        searchPage.clickItem();


            String selectedSize = searchPage.getSelectedSize();
            assertEquals(size, selectedSize, "The selected size should match the expected size for: " + product);
            String slectedSize = searchPage.getSelectedSize();
            assertEquals(size, slectedSize,
                    "The selected size should match the expected size for: " + product);

        productPage.addToCartButton();
        assertEquals("\uE876Product successfully added to your shopping cart",
                    productPage.productAddedSuccessfully(),
                    "The product should be successfully added to the cart.");
        productPage.checkoutButton();

        String checkOut = productPage.productSize();
        assertEquals(size, checkOut,
                "The selected size should match the expected size for: " + product);

        });
    }




}
