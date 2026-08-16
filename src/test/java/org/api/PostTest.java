package org.api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PostTest extends BaseTest {

    @Test
    public void createPost() {

        String requestBody = """
            {
                "title": "Rest Assured",
                "body": "Learning API automation",
                "userId": 1
            }
            """;

        given()
                .spec(requestSpecification)
                .contentType("application/json")
                .body(requestBody)

                .when()
                .post("/posts")

                .then()
                .statusCode(201)
                .body("title",equalTo("Rest Assured"))
                .body("body",equalTo("Learning API automation"))
                .body("userId",equalTo(1))
//                .body("id",equalTo(101))
                .log().all();
    }

}
