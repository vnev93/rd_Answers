package org.example.Homework_16;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookingDeletionTests extends Authentication{

    @Test
    public void testDeleteBooking() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        int bookingId = 4;

        Response response = given()
                .accept(ContentType.JSON)
                .cookie("token", token)
                .when()
                .delete("/booking/" + bookingId);

        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
