package lt.techin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class LoginTest {

    WebDriver driver;


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


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

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("wrong_password");

        driver.findElement(By.id("login-button")).click();

        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = (driver.findElement(By.cssSelector("H3")).getText());

        Assertions.assertEquals(expected, actual, "Error message expected");

    }


    @Test
    void lockedUser() {

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("locked_out_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        String expected = "this user has been locked out";
        String actual = driver.findElement(By.cssSelector("h3")).getText();

        Assertions.assertTrue(actual.contains(expected));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/logins.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromClasspath(String username, String password) {


        assertTimeout(ofSeconds(2), () -> {

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        String expected = "https://www.saucedemo.com/inventory.html";
        String actual = driver.getCurrentUrl();

        Assertions.assertEquals(expected, actual, "URL should navigate to main page");
        });
    }



}
