package com.restapi.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

public class TestCreateBooking {
    @Test(groups = "reg", priority = 1)
    @Owner("Biju")
    @Description("TC#INT1 - Step 1. verify that the Booking can be created")
    public void testCreateBookingPOST_Positive(){
        System.out.println("Test Create Booking");
    }

    @Test(groups = "reg", priority = 1)
    @Owner("Biju")
    @Description("TC#INT1 - Step 1. verify that the Booking can not created(when payload is wrong)")
    public void testCreateBookingPOST_Negative(){
        System.out.println("Test Create Booking");
    }

}
