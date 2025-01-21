package org.example.Homework_16;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BookingRetrievalTests extends Authentication{

    @Test
    public void testGetAllBookings(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        Response response = given()
                .accept(ContentType.JSON)
                .cookie("token", token)
                .when()
                .get("/booking");

        Assert.assertEquals(response.getStatusCode(),200);
        List<Integer> bookingIds = response.jsonPath().getList("bookingid");
        Assert.assertTrue(bookingIds.size() > 0);
    }
}
