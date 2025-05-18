package com.restapi.tests.crud;

import com.restapi.base.BaseTest;
import com.restapi.endpoint.APIConstants;
import com.restapi.modules.PayloadManager;
import com.restapi.pojos.response.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateBooking extends BaseTest {
    @Test(groups = "reg", priority = 1)
    @Owner("Biju")
    @Description("TC#INT1 - Step 1. verify that the Booking can be created")
    public void testCreateBookingPOST_Positive(){
        System.out.println("Test Create Booking");
//setup and making a request
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingAsString()).log().all().post();
        System.out.println(response.asString());
        //Extraction
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
//verification Part
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"Biju");

    }

    @Test(groups = "reg", priority = 1)
    @Owner("Biju")
    @Description("TC#INT1 - Step 1. verify that the Booking can not created(when payload is null)")
    public void testCreateBookingPOST_Negative(){

//setup and making a request
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body("{}").log().all().post();
        System.out.println(response.asString());
        //Extraction


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(500);
    }

}
