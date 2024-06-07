package lt.techin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WebDriver driver;

@BeforeEach
    void setUp() {

            driver = new ChromeDriver();
            driver.get("https://practice.expandtesting.com/tracalorie/?classId=e83a1e60-d212-4fa4-9e1c-f89284b2328a&assignmentId=bf2480e2-ae85-49e3-bbb4-6fc77a9d30d8&submissionId=0be95e87-f05c-7a76-cbb2-505b85825795");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            }

@AfterEach
    void tearDown() {
            driver.quit();AddMealTest extends BaseTest {

    @Test
    void addMealAndCalories() {

        AddMealPage addMealPage = new AddMealPage(driver);
        addMealPage.inputAddMeal("Chicken Stew");
        addMealPage.inputAddCalories("1000");
        addMealPage.clickButton();


        String Expected = "[Chicken Stew: 1000 Calories]";
        String Actual = String.valueOf(addMealPage.getMeals());

        Assertions.assertEquals(Expected, Actual);
    }


    @Test
    void addThreeMealsAndCalories() throws InterruptedException {

        AddMealPage addMealPage = new AddMealPage(driver);
        addMealPage.inputAddMeal("Chicken Stew");
        addMealPage.inputAddCalories("1000");
        addMealPage.clickButton();
        Thread.sleep(1000);
        addMealPage.inputAddMeal("Pork Stew");
        addMealPage.inputAddCalories("3000");
        addMealPage.clickButton();
        Thread.sleep(1000);
        addMealPage.inputAddMeal("Apple Pie");
        addMealPage.inputAddCalories("1700");
        addMealPage.clickButton();


        String expected = """
                [Chicken Stew: 1000 Calories
                Pork Stew: 3000 Calories
                Apple Pie: 1700 Calories]""";
        String actual = String.valueOf(addMealPage.getMeals());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeOneMeal() throws InterruptedException {

        AddMealPage addMealPage = new AddMealPage(driver);
        addMealPage.inputAddMeal("Chicken Stew");
        addMealPage.inputAddCalories("1000");
        addMealPage.clickButton();
        Thread.sleep(1000);
        addMealPage.inputAddMeal("Pork Stew");
        addMealPage.inputAddCalories("3000");
        addMealPage.clickButton();
        Thread.sleep(1000);
        addMealPage.inputAddMeal("Apple Pie");
        addMealPage.inputAddCalories("1700");
        addMealPage.clickButton();
        Thread.sleep(2000);
        addMealPage.editButton();
        addMealPage.deleteButton();


        String Expected = """
                [Pork Stew: 3000 Calories
                Apple Pie: 1700 Calories]""";
        String Actual = String.valueOf(addMealPage.getMeals());

        Assertions.assertEquals(Expected, Actual);
        Assertions.assertEquals("4700", addMealPage.totalCalories());

    }

    @Test
    void removeAllMeal() throws InterruptedException {

        AddMealPage addMealPage = new AddMealPage(driver);
        addMealPage.inputAddMeal("Chicken Stew");
        addMealPage.inputAddCalories("1000");
        addMealPage.clickButton();
        Thread.sleep(1000);
        addMealPage.inputAddMeal("Pork Stew");
        addMealPage.inputAddCalories("3000");
        addMealPage.clickButton();
        Thread.sleep(1000);
        addMealPage.inputAddMeal("Apple Pie");
        addMealPage.inputAddCalories("1700");
        addMealPage.clickButton();
        Thread.sleep(2000);

        addMealPage.deleteAllButton();

        Assertions.assertEquals("[]", String.valueOf(addMealPage.getMeals()));
        Assertions.assertEquals("0", addMealPage.totalCalories());

    }


    @Test
    void renameMealAndCalories() throws InterruptedException {

        AddMealPage addMealPage = new AddMealPage(driver);
        addMealPage.inputAddMeal("Chicken Stew");
        addMealPage.inputAddCalories("1000");
        addMealPage.clickButton();
        Thread.sleep(3000);
        addMealPage.editButton();
        addMealPage.inputAddMeal("Pork Stew");
        addMealPage.inputAddCalories("3000");
        addMealPage.updateMeal();

        String Expected = "[Pork Stew: 3000 Calories]";
        String Actual = String.valueOf(addMealPage.getMeals());

        Assertions.assertEquals(Expected, Actual);
    }

    @Test
    void backButtonTest() {

        AddMealPage addMealPage = new AddMealPage(driver);
        addMealPage.inputAddMeal("IceCream");
        addMealPage.inputAddCalories("350");
        addMealPage.clickButton();
        addMealPage.editButton();
        addMealPage.backButton();

        String Expected = "[IceCream 350 Calories]";
        String Actual = String.valueOf(addMealPage.getMeals());

        Assertions.assertEquals(Expected,Actual);
    }

    @Test
    void totalCaloriesTest() throws InterruptedException {

        AddMealPage addMealPage = new AddMealPage(driver);
        addMealPage.inputAddMeal("Chicken Stew");
        addMealPage.inputAddCalories("1000");
        addMealPage.clickButton();
        Thread.sleep(1000);
        addMealPage.inputAddMeal("Pork Stew");
        addMealPage.inputAddCalories("3000");
        addMealPage.clickButton();
        Thread.sleep(1000);
        addMealPage.inputAddMeal("Apple Pie");
        addMealPage.inputAddCalories("1700");
        addMealPage.clickButton();
        Thread.sleep(2000);
        addMealPage.inputAddMeal("IceCream");
        addMealPage.inputAddCalories("350");
        addMealPage.clickButton();

        String Expected = "6050";
        String Actual = addMealPage.totalCalories();

        Assertions.assertEquals(Expected,Actual);
    }

    @Test
    void noMealAddWithoutEnteredInputMeal() throws InterruptedException {
        AddMealPage addMealPage = new AddMealPage(driver);
        addMealPage.inputAddMeal("Chicken Stew");
        addMealPage.clickButton();

        Assertions.assertEquals("[]", String.valueOf(addMealPage.getMeals()));
    }

    @Test
    void noInputsAdded() {
        AddMealPage addMealPage = new AddMealPage(driver);
        addMealPage.clickButton();

        Assertions.assertEquals("[]", String.valueOf(addMealPage.getMeals()));


    }

    @Test
    void addMealWithoutLettersAndNegativeCalories() {

        AddMealPage addMealPage = new AddMealPage(driver);
        addMealPage.inputAddMeal("     ");
        addMealPage.inputAddCalories("-1789");
        addMealPage.clickButton();

        String Expected = "[]";
        String Actual = String.valueOf(addMealPage.getMeals());

        Assertions.assertEquals(Expected,Actual);
    }

}

