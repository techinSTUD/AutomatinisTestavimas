package lt.techin;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class gorestTEST {


    @Test
    public void getUserTest() {

        String userGender = "male";
        String userStatus = "inactive";
        String userId = "6949865";

        given().
                pathParam("id", userId)
                .log().all()

                .when().
                get("https://gorest.co.in/public/v2/users/{id}")

                .then()
                .statusCode(200)
                .body("status", equalTo(userStatus))
                .body("gender", equalTo(userGender))
                .log().body();
    }


    @Test
    public void userListTest() {

        int pageFive = 5;
        int perPage = 20;

        given()
                .log().all()
                .when()
                .get("https://gorest.co.in/public/v2/users?page=5&per_page=20")
                .then()
                .statusCode(200)
                .log().body();  // Log the entire response body
    }






    @Test
    public void userCreationTest() {

        String user = """
            {
                "name": "Jonas",
                "email": "jonas4@bexample.com",
                "gender": "male",
                "status": "active"
            }
        """;

        given()
                .body(user)
                .header("Authorization", "Bearer fec4d2be3cc03f41861f0b1e6ed52cbfde09e0306ca82de815f7f7adc29fd0da")
                .header("Content-type", "application/json")
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(201)
                .log().all()
                .body("name", equalTo("Jonas"))
                .body("email", equalTo("jonas4@bexample.com"))
                .body("gender", equalTo("male"))
                .body("status", equalTo("active"));
    }
}