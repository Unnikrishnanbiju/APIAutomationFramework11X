package com.restapi.base;

import com.restapi.Asserts.AssertActions;
import com.restapi.endpoint.APIConstants;
import com.restapi.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
    //CommonTo All testcase
    //Base URL, Content type-json - common

    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
     public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;

    @BeforeTest
    public void setup(){
        System.out.println("Starting of Test!");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(APIConstants.BASE_URL);
        requestSpecification.contentType(ContentType.JSON).log().all();
    }

    @AfterTest
    public void tearDown(){
        System.out.println("Finished the Test!");
    }

}
