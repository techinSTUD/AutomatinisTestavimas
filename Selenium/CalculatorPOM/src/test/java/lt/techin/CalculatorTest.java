package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest extends BaseTest {


    CalculatorPage calculatorPage = new CalculatorPage(driver);

@Test
    void calculationSum() {
    CalculatorPage calculatorPage = new CalculatorPage(driver);


        calculatorPage.inputFieldFirst("3");
        calculatorPage.dropDownPickMinus();
        calculatorPage.inputFieldSecond("2");
        calculatorPage.calculateButton();


        String Expected = "1";
        String Actual = calculatorPage.calculationSum();

        Assertions.assertEquals(Expected,Actual);






    }
}
