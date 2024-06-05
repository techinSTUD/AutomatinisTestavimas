import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasicsTwo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();


        driver.get("http://192.168.88.218/");

        WebElement searchBox = driver.findElement(By.cssSelector("div#search > input[name='search']"));
        searchBox.sendKeys("MaxBook");

        driver.findElement(By.className("btn")).click();

        boolean isSearch = driver.findElement(By.id("button-search")).isDisplayed();
        System.out.println(isSearch);

        Thread.sleep(1000);

        WebElement searchBox1 = driver.findElement(By.cssSelector("div#search > input[name='search']"));
        searchBox1.clear();
        searchBox1.sendKeys("MacBook");
        driver.findElement(By.className("btn")).click();

        List<WebElement> searchBox2 = driver.findElements(By.cssSelector("div#product-list > div"));
        System.out.println(searchBox2.size());

        Select lowToHigh = new Select (driver.findElement(By.id("input-sort")));
            lowToHigh.selectByIndex(3);

        Thread.sleep(5000);

        driver.close();
    }
}
