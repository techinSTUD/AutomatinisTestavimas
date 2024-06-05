package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddToDoJobTest extends BaseTest{


    @Test
    void clickAddToDoButton() {


        // If hidden
        AddToDoJobPage addToDoJobPage = new AddToDoJobPage(driver);
        addToDoJobPage.clickAdd("Milk");








    }


}
