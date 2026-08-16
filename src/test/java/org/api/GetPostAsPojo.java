package org.api;

import org.api.pojo.PostResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetPostAsPojo extends BaseTest{
    @Test
    public void getPostAsPojo(){
        PostResponse response =
              given().spec(requestSpecification)
                      .pathParam("id",1)
                      .when()
                      .get("/posts/{id}")
                      .then().statusCode(200)
                      .extract()
                      .as(PostResponse.class);

        System.out.println("ID: " + response.getId());
        System.out.println("User ID: " + response.getUserId());
        System.out.println("Title: " + response.getTitle());
        System.out.println("Body: " + response.getBody());

        Assert.assertEquals(response.getId(), 1);
        Assert.assertEquals(response.getUserId(), 1);
    }
}
