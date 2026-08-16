package org.api;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.api.pojo.PostResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiChaining extends BaseTest {
    @Test
    public void apiChaining(){
        //Get userId from API1
        PostResponse response =
                given().spec(requestSpecification).pathParam("id",10)
                        .when().get("/posts/{id}")
                        .then().statusCode(200).extract().as(PostResponse.class);

        //Save userId
        int userId = response.getUserId();
        System.out.println("User ID from first API: " + userId);

        //API 2 - Use extracted userId
        given().spec(requestSpecification).queryParam("userId",userId)
                .when().get("/posts")
                .then().statusCode(200)
                .body("userId",everyItem(equalTo(userId)))
                .log().all();
    }
}
