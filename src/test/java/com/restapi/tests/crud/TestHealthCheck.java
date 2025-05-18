package com.restapi.tests.crud;

import com.restapi.base.BaseTest;
import com.restapi.endpoint.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestHealthCheck extends BaseTest {
    @Test(groups = "reg", priority = 1)
    @Owner("Biju")
    @Description("TC#3 - Verify health)")
    public void testGETHealthCheck() {

        requestSpecification.basePath(APIConstants.PING_URL);


        response = RestAssured.given(requestSpecification).when().get();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(201);



    }


}
