package lt.techin.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchBarTest extends BaseTest {


    @Test
    void clickAndEnterTextTest() {
        SearchBarPage searchBarPage = new SearchBarPage(driver);

        searchBarPage.searchBar();
        searchBarPage.sendValue("at");

    }

    @Test
    void SearchTest() {
        SearchBarPage searchBarPage = new SearchBarPage(driver);

        String searchText = "at";
        searchBarPage.searchBar();
        searchBarPage.sendValue(searchText);

        searchBarPage.selectPageSize();

        List<String> names = searchBarPage.getNames();
        for (String name : names) {
            Assertions.assertTrue(name.contains(searchText));
        }


    }

    @Test
    void sortingTest() {

        SearchBarPage searchBarPage = new SearchBarPage(driver);

//        searchBarPage.selectPageSize();
//
//        List<String> names = searchBarPage.getNames();
//        System.out.println(names);

        searchBarPage.SortingNames();

        List<String> names = searchBarPage.getNames();
        List<String> sortedNames = new ArrayList<>(names);
        Collections.sort(sortedNames);

        Assertions.assertEquals(sortedNames, names);

        System.out.println(searchBarPage.getNames());
    }

    @Test
    void nextPageTest() {

        SearchBarPage searchBarPage = new SearchBarPage(driver);
        searchBarPage.nextPage();
    }
}




