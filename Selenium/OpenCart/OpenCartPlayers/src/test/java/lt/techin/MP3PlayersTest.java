package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static java.time.Duration.of;
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


            Assertions.assertTrue(actualProducts.contains(ITEM_NAME), "Product list should contain the item name");
            Assertions.assertEquals(expectedProducts, actualProducts, "Product list should match the expected list");

        });
    }

    @Test
    void selectProductAddQtyAndCheckCart()  {
        MP3PlayersPage mp3PlayersPage = new MP3PlayersPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickMp3Players();
        homePage.clickShowAll();
        homePage.clickShowAsList();

        mp3PlayersPage.clickOnProduct();

        mp3PlayersPage.randomNumber();
        mp3PlayersPage.addToCartButton();
        mp3PlayersPage.clickCloseAlert();

        String productName = "iPod Classic";

        String expected = "Success: You have added " + productName + " to your shopping cart!";

        Assertions.assertEquals(expected, mp3PlayersPage.alertMessage());
        Assertions.assertEquals(productName, homePage.getTitle());


//        mp3PlayersPage.clickCartButton();



    }
    }












