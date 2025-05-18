package com.restapi.tests.crud;

import com.restapi.base.BaseTest;
import com.restapi.endpoint.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateToken extends BaseTest {

    @Test(groups = "reg", priority = 1)
    @Owner("Biju")
    @Description("TC#2 - Create a token and verify)")
    public void testCreateToken(){
//Preparation
        requestSpecification.baseUri(APIConstants.BASE_URL);
        requestSpecification.basePath((APIConstants.AUTH_URL));
        //making of request
        response = RestAssured.given(requestSpecification).when().body(payloadManager.setAuthPayload()).post();
//Extraction
        String token = payloadManager.getTokenFromJSON(response.asString());
        System.out.println(token);
        //
        assertActions.verifyStringKeyNotNull("TOKEN"+ token);



    }
}
