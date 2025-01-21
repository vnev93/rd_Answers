package org.example.Homework_16;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookingUpdateTests extends Authentication{

    @Test
    public void testUpdateBookingPrice() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        int bookingId = 6;

        Map<String, Object> updateData = new HashMap<>();
        updateData.put("totalprice", 200);

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .cookie("token",token)
                .body(updateData)
                .when()
                .patch("/booking/" + bookingId);

        System.out.println(response.asString());

        Assert.assertEquals(response.getStatusCode(), 200);
        int updatedPrice = response.jsonPath().getInt("totalprice");
        Assert.assertEquals(updatedPrice, 200);
    }

    @Test
    public void testUpdateBookingDetails() {
        int bookingId = 3048;

        Map<String, Object> updateData = new HashMap<>();
        updateData.put("firstname", "Jane");
        updateData.put("additionalneeds", "Lunch");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .cookie("token",token)
                .body(updateData)
                .when()
                .put("/booking/" + bookingId);

        System.out.println(response.asString());

        Assert.assertEquals(response.getStatusCode(), 200);
        String updatedName = response.jsonPath().getString("firstname");
        Assert.assertEquals(updatedName, "Jane");
    }
}




