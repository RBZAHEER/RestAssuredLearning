package org.api;

import org.api.pojo.PostRequest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PutPost extends BaseTest{
    @Test
    public void updatePostUsingPut(){
        PostRequest request = new PostRequest("Updated Title", "Updated Body", 2);

        given().spec(requestSpecification)
                .pathParam("postId",10)
                .contentType("application/json")
                .body(request)

                .when().put("/posts/{postId}")

                .then()
                .statusCode(200)
                .body("title",equalTo("Updated Title"))
                .body("body",equalTo("Updated Body"))
                .body("userId",equalTo(2))
                .log().all();
    }

    @Test
    public void updatePostUsingPatch(){
        Map<String , Object> requestMap = new HashMap<>();
        requestMap.put("title", "Updated Title by patch");

        given().spec(requestSpecification)
                .pathParam("postId", 10)
                .contentType("application/json")
                .body(requestMap)

                .when().patch("/posts/{postId}")

                .then().statusCode(200)
                .body("title", equalTo("Updated Title by patch"))
                .log().all();
    }
}
