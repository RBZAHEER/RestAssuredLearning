package org.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeletePost extends BaseTest {
    @Test
    public void deletePost() {

        given()
                .spec(requestSpecification)
                .pathParam("postId", 10)

                .when()
                .delete("/posts/{postId}")

                .then()
                .statusCode(200)
                .log().all();
    }
}
