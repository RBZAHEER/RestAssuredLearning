package org.api;

import org.api.pojo.PostRequest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class createPostUsingPojo extends BaseTest {
    PostRequest postRequest = new PostRequest("API Testing", "Rest Assured", 5);

    @Test
    public void postRequestPojo(){
        given().spec(requestSpecification)
                .contentType("application/json")
                .body(postRequest)

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

