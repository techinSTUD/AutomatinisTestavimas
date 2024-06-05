package lt.techin.OpenCart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    @Test
    void positiveLoginTest() {

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();


        String expected = "https://www.saucedemo.com/inventory.html";
        String actual = driver.getCurrentUrl();

        Assertions.assertEquals(expected, actual, "URL should navigate to main page");

        boolean cart = driver.findElement(By.id("shopping_cart_container")).isDisplayed();
        System.out.println(cart);
    }

    @Test
    void negativeLoginTest() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();

        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = (driver.findElement(By.cssSelector("H3")).getText());

        Assertions.assertEquals(expected, actual, "Error message expected");

    }

}
