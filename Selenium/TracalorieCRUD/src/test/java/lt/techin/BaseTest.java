package lt.techin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/tracalorie/?classId=e83a1e60-d212-4fa4-9e1c-f89284b2328a&assignmentId=bf2480e2-ae85-49e3-bbb4-6fc77a9d30d8&submissionId=0be95e87-f05c-7a76-cbb2-505b85825795");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterEach
    void tearDown() {
        driver.quit();


    }


}
