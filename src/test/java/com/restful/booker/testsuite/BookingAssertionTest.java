package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasKey;

public class BookingAssertionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
        response = given()
                .when()
                .get("/booking/1")
                .then().statusCode(200);
    }

    //Check the single firstname in the Array list Jim
    @Test
    public void test001(){
        response.body("firstname", hasItem("Jim"));
    }

    //Check the single lastname in the Array list Smith
    @Test
    public void test002() {
        response.body("lastname", hasItem("Smith"));
    }
    @Test
    public void test003() {
        response.body("totalprice", hasItem("totalprice"));
    }
    @Test
    public void test004() {
        response.body(".", hasKey("depositpaid"));
    }
    @Test
    public void test005() {
        response.body("bookingdates", hasKey("checkin"));
    }
    @Test
    public void test008() {
        response.body(".", hasKey("bookingdates"));
    }

    @Test
    public void test006() {
        response.body("bookingdates", hasKey("checkout"));
    }

    @Test
    public void test007() {
        response.body("additionalneeds", hasKey("Breakfast"));
    }

}
