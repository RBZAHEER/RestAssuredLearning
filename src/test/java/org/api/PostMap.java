package org.api;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PostMap extends BaseTest {
    @Test
    public void createPostUsingMap(){
        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("title","API Testing");
        requestBody.put("body", "Rest Assured");
        requestBody.put("userId", 5);

        given()
                .spec(requestSpecification)
                .contentType("application/json")
                .body(requestBody)

                .when()
                .post("/posts")

                .then()
                .statusCode(201)
                .body("title",equalTo("API Testing"))
                .body("body",equalTo("Rest Assured"))
                .body("userId",equalTo(5))
                .log().all();

    }

}
