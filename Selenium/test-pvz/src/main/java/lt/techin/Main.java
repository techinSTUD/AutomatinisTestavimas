package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();


//        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement inputUsername = driver.findElement(new By.ById("username"));
        inputUsername.sendKeys("student");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("Password123");

        WebElement submit = driver.findElement(By.id("submit"));
//        submit.click();
        driver.findElement(By.id("submit")).click();
        String expected = "https://practicetestautomation.com/logged-in-successfully/";

        System.out.println(driver.getCurrentUrl().equals(expected) ? "Passed" : "Failed");


//        Thread.sleep(3000);

//        driver.close();

    }
}