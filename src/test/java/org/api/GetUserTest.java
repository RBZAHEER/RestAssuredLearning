package org.api;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetUserTest {

    @Test
    public void getUser(){
        given().baseUri("https://jsonplaceholder.typicode.com")
                .queryParam("id", 2)
                .when().get("/users")
                .then().statusCode(200)
//                .body("[0].id", equalTo(1))
                .log().all();
    }

}
