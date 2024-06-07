package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class MP3PlayersTest extends BaseTest {

    @Test
    public void testProductListItemIsInList() {

        HomePage homePage = new HomePage(driver);
        MP3PlayersPage mp3PlayersPage = new MP3PlayersPage(driver);
        homePage.clickMp3Players();
        homePage.clickShowAll();
        homePage.clickShowAsList();

        List<String> result = mp3PlayersPage.getProductsInList();

        List<String> expected = Arrays.asList("iPod Classic", "iPod Nano", "iPod Shuffle", "iPod Touch");

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromClasspath(String ITEM_NAME) {

        assertTimeout(ofSeconds(2), () -> {
            HomePage homePage = new HomePage(driver);
            homePage.clickMp3Players();
            homePage.clickShowAll();
            homePage.clickShowAsList();

            MP3PlayersPage mp3PlayersPage = new MP3PlayersPage(driver);
            List<String> actualProducts = mp3PlayersPage.getProductsInList();

            List<String> expectedProducts = List.of("iPod Classic", "iPod Nano", "iPod Shuffle", "iPod Touch");


            assertNotNull(ITEM_NAME);
            Assertions.assertTrue(actualProducts.contains(ITEM_NAME), "Product list should contain the item name");
            Assertions.assertEquals(expectedProducts, actualProducts, "Product list should match the expected list");

        });
    }

    


}




