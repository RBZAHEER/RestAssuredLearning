package org.api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;

public class GetPostsTest {

    @Test
    public void getPost() {

        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .pathParam("postId", 5)

                .when()
                .get("/posts/{postId}")

                .then()
                .statusCode(200)
                .body("id", equalTo(5))
                .log().all();
    }

    //Exercise 1 :- GET /posts/10 (Path Param)

    @Test
    public void getPost10(){
        given().baseUri("https://jsonplaceholder.typicode.com").pathParam("postId", 10)
                .when().get("/posts/{postId}")
                .then().statusCode(200).body("id", equalTo(10)).log().all();
    }

    //Exercise2 :-GET /posts?userId=2 (Query Parameter)
    @Test
    public void queryParameter(){
        given().baseUri("https://jsonplaceholder.typicode.com").queryParam("userId",2)
                .when().get("/posts")
                .then().statusCode(200).body("userId",everyItem(equalTo(2))).log().all();
    }
}
