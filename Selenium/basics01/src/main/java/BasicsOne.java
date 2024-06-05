import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasicsOne {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();


        driver.get("http://192.168.88.218/");

        driver.findElement(By.id("wishlist-total")).click();
        List<WebElement> searchBox = driver.findElements(By.id("search"));
        System.out.println(searchBox.size());

//        int numberOfSearch = driver.findElements(By.tagName("input-email")).size();
//        System.out.println(numberOfSearch);


//        WebElement email = driver.findElement(By.id("input-email"));
//        email.sendKeys("email@email.com");
//        Thread.sleep(2000);
//        email.clear();
//
//        driver.findElements(By.className("btn"));
//
//        driver.findElement(By.linkText("Register")).click();
//
//        boolean passwordElement = driver.findElement(By.id("input-password")).isEnabled();
//        System.out.println(passwordElement);
//
//        boolean cartElement = driver.findElement(By.id("header-cart")).isDisplayed();
//        System.out.println(cartElement);
//
//        boolean agreeCheckbox = driver.findElement(By.cssSelector("input[name='agree']")).isSelected();
//        System.out.println(agreeCheckbox);

        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.className("see-all")).click();

        Select limitPerPage = new Select(driver.findElement(By.id("input-limit")));
        limitPerPage.selectByVisibleText("25");
        System.out.println((new Select(driver.findElement(By.id("input-limit")))).getFirstSelectedOption());

//        Select fourthLimit = new Select (driver.findElement(By.id("input-limit")));
//            fourthLimit.selectByIndex(4);


//        driver.close();
    }

}
