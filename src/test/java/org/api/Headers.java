package org.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Headers extends BaseTest {
    @Test
    public void validateResponseHeader() {


/*       2. Accept vs Content-Type
//
//        This distinction is important.
//
//        1. Accept
//        Tells the server:
//        "This is the response format I want."
//        Accept: application/json

//        2.Content-Type
//        Tells the server:
//        "This is the format of the data I'm sending."
           Content-Type: application/json
*/
        given()
                .spec(requestSpecification)

                .when()
                .get("/posts")

                .then().spec(responseSpecification)
                .log().all();

    }
}
