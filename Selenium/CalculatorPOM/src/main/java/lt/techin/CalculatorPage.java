package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends BasePage{

    @FindBy(id = "number1")
    private WebElement inputFieldFirst;

    @FindBy(css = "[value='minus']")
    private WebElement dropDownPickMinus;

    @FindBy(id = "number2")
    private WebElement inputFieldSecond;

    @FindBy(id = "calculate")
    private WebElement calculateButton;

    @FindBy(css = "span#answer")
    private WebElement answer;


    public CalculatorPage(WebDriver driver) {
        super(driver);
    }


    public void inputFieldFirst(String number) {
        inputFieldFirst.click();
        inputFieldFirst.sendKeys(number);

    }

    public void dropDownPickMinus() {
    dropDownPickMinus.click();
    }



    public void inputFieldSecond(String number) {
        inputFieldSecond.click();
        inputFieldSecond.sendKeys(number);
    }


    public void calculateButton() {
      calculateButton.click();
    }
    public String calculationSum() {
       return answer.getText();
    }



}
