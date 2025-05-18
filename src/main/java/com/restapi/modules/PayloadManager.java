package com.restapi.modules;

//import com.restapi.pojo.request.Booking;

import com.google.gson.Gson;
import com.restapi.pojos.request.Auth;
import com.restapi.pojos.request.Booking;
import com.restapi.pojos.request.Bookingdates;
import com.restapi.pojos.response.BookingResponse;
import com.restapi.pojos.response.TokenResponse;

public class PayloadManager {

    Gson gson;

    public String createPayloadBookingAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Biju");
        booking.setLastname("Unikrishnan");
        booking.setTotalprice(2011);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2025-02-01");
        bookingdates.setCheckout("2025-02-02");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");


        System.out.println(booking);


        // Java Object -> JSON
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        return jsonStringBooking;

    }


    // Convert the JSON String to Java Object so that we can verify response Body
    // DeSerialization
    public BookingResponse bookingResponseJava(String responseString) {
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }

    public String setAuthPayload() {
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");

        Gson gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set to the ->" + jsonPayloadString);
        return jsonPayloadString;
    }

    public String getTokenFromJSON(String tokenResponse) {
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken();
    }
}

