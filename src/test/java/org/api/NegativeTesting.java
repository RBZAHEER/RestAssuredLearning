package org.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class NegativeTesting extends BaseTest{
    @Test
    public void getNonExistingPost(){
        given().spec(requestSpecification)
                .pathParam("postId",99999)

                .when()
                .get("/posts/{postId}")

                .then().statusCode(404).log().all();
    }
}
