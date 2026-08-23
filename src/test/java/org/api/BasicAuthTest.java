package org.api;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class BasicAuthTest extends BaseTest{

    //Api Key reqres_db6fedc2758c40749e0f026a8a542097
    @Test
    public void basicAuth(){
        given()
                .baseUri("https://httpbin.org")
                .auth()
                .basic("zaheer","test123")

                .when().get("/basic-auth/zaheer/test123")

                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    }

    @Test
    public void getUserWithAPIKey(){
        String apikey = "reqres_db6fedc2758c40749e0f026a8a542097";

        given().baseUri("https://reqres.in")
                .header("x-api-key", apikey)

                .when().get("/api/users?page=2")

                .then().statusCode(200)
                .log().all();


    }

    //Do not test this just for ref
    @Test
    public void bearerTokenRequest() {

        String loginRequest = "daff";
        //4. Extracting a Bearer Token
        String token =
                given()
                        .contentType("application/json")
                        .body(loginRequest)

                        .when()
                        .post("/login")

                        .then()
                        .statusCode(200)
                        .extract()
                        .path("token");


        given()
                .auth()
                .oauth2(token)

                .when()
                .get("/protected-resource")

                .then()
                .statusCode(200);

    }
}
