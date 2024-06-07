package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {


    @Test
    void selectSubCategory() {

        HomePage homePage = new HomePage(driver);
        homePage.clickMp3Players();
        homePage.clickShowAll();
        homePage.clickShowAsList();

        Assertions.assertEquals("MP3 Players", homePage.getTitle());
    }


}

