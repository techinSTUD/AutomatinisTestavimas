package lt.techin.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import java.util.stream.Collectors;

public class SearchBarPage extends BasePage {


    @FindBy(css = "input#search-field")
    private WebElement searchBarClick;

    @FindBy(css = "tr > td:nth-of-type(1)")
    private List<WebElement> tdNames;
    @FindBy(css = "[value='20']")
    private WebElement pickPageSize;
    @FindBy(css = "tr > th:nth-of-type(1)")
    private WebElement clickToSortName;

    @FindBy(css = "li:nth-of-type(7) > a[role='button']")
    private WebElement nextButton;

    public SearchBarPage(WebDriver driver) {
        super(driver);
    }


    public void searchBar() {
        searchBarClick.click();
    }

    public void sendValue(String searchText) {
        searchBarClick.click();
        searchBarClick.sendKeys(searchText);
    }

    public List<String> getNames() {

        List<String> names = new ArrayList<>();
//        for (WebElement tdName : tdNames) {
//            names.add(tdName.getText());
//        }
//
//
//        return names;

        return tdNames.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void SortingNames() {

        clickToSortName.click();
    }

    public void selectPageSize() {
        pickPageSize.click();
    }


    public void nextPage() {
        while (nextButton.getAttribute("aria-disabled").equals("false")) {
            nextButton.click();
        }
    }
}


