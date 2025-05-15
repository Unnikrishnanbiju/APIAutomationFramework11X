package com.restapi.Asserts;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class AssertActions {
    public  void verifyResponseBody(String actual, String expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyStatusCode(int actual, int expected, String description) {
        assertEquals(actual, expected, description);
    }
    public  void verifySatusCode(Response response, Integer expected) {
       assertEquals(response.getStatusCode(),expected);
    }

    public void verifyStringKey(String keyExpected, String keyActual ) {
        assertThat(keyExpected).isNotNull();
        assertThat(keyExpected).isNotNull().isNotBlank();
        assertThat(keyExpected).isEqualTo(keyActual);
    }

    public void verifyStringKeyNotNull(Integer keyExpect) {
        assertThat(keyExpect).isNotNull();

    }
    public void verifyStringKeyNotNull(String keyExpect) {
        assertThat(keyExpect).isNotNull();

    }
}
