package lt.techin.SignUp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://192.168.88.70");
    }

    @AfterEach
    void tearDown() {
//        driver.quit();
    }



}
