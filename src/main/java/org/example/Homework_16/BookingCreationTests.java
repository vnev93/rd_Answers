package org.example.Homework_16;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookingCreationTests extends Authentication{

    @Test
    public void testCreateBooking (){

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        Map<String, Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin", LocalDate.parse("2024-08-30", DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
        bookingDates.put("checkout", LocalDate.parse("2024-09-06", DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());

        Map<String, Object> booking = new HashMap<>();
        booking.put("firstname", "Jim");
        booking.put("lastname", "Brown");
        booking.put("totalprice", 111);
        booking.put("depositpaid", true);
        booking.put("bookingdates", bookingDates);
        booking.put("additionalneeds", "Breakfast");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .cookie("token", token)
                .body(booking)
                .when()
                .post("/booking");
    }
}

