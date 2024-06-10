package lt.techin.SignUp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {


    @Test
    void searchItems() {


        String itemName = "HUMMINGBIRD PRINTED SWEATER";

        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchField(itemName);
        Assertions.assertEquals(itemName, searchPage.itemName().toUpperCase());
        searchPage.clickItem();


    }
}
