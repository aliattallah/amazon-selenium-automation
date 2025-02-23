package com.amazon.automation.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTests {

    private final String BASE_URL = "https://reqres.in/api/users";

    @Test
    public void testCreateUser() {
        String requestBody = "{ \"name\": \"John Doe\", \"job\": \"QA Engineer\" }";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(BASE_URL)
                .then()
                .statusCode(201)
                .extract().response();

        Assert.assertNotNull(response.jsonPath().getString("id"));
    }

    @Test
    public void testGetUser() {
        Response response = given()
                .when()
                .get(BASE_URL + "/2")
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.jsonPath().getString("data.id"), "2");
    }

    @Test
    public void testUpdateUser() {
        String requestBody = "{ \"name\": \"John Doe\", \"job\": \"Senior QA Engineer\" }";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put(BASE_URL + "/2")
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.jsonPath().getString("job"), "Senior QA Engineer");
    }
}
