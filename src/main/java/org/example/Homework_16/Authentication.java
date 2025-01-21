package org.example.Homework_16;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {

    protected String token;


    @BeforeClass
    public void authenticate() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        Map<String, String> authData = Map.of(
                "username", "admin",
                "password", "password123"
        );

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(authData)
                .when()
                .post("/auth");

        response.then().statusCode(200);
        token = response.jsonPath().getString("token");

        System.out.println("Authentication Response: " + response.getBody().asString());
        System.out.println("Received token: " + token);
    }
}
