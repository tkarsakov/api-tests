package com.solvd.apitests;

import com.solvd.apitests.api.dummyjson.GetAuthTokenMethod;
import com.solvd.apitests.api.dummyjson.GetProductsMethod;
import com.solvd.apitests.api.dummyjson.GetProductsWithAuthMethod;
import com.solvd.apitests.api.dummyjson.PostProductsMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class DummyjsonApiTest implements IAbstractTest {
    private String accessToken = null;
    private static final String GET_RESPONSE_SCHEMA_PATH = "api/dummyjson/_get/rs.schema";
    private static final String POST_RESPONSE_SCHEMA_PATH = "api/dummyjson/_post/rs.schema";

    @Test
    public void testGetProducts() {
        GetProductsMethod getProductsMethod = new GetProductsMethod();
        getProductsMethod.callAPIExpectSuccess();
        getProductsMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getProductsMethod.validateResponseAgainstSchema(GET_RESPONSE_SCHEMA_PATH);
    }

    @Test
    public void testCreateProducts() {
        PostProductsMethod postProductsMethod = new PostProductsMethod();

        postProductsMethod.callAPIExpectSuccess();
        postProductsMethod.validateResponseAgainstSchema(POST_RESPONSE_SCHEMA_PATH);
    }

    @Test
    public void testGetAuthToken() {
        GetAuthTokenMethod getAuthTokenMethod = new GetAuthTokenMethod();

        Response response = getAuthTokenMethod.callAPI();
        getAuthTokenMethod.validateResponse();
        accessToken = response.jsonPath().getString("token");
    }

    @Test(dependsOnMethods = {"testGetAuthToken"})
    public void testGetProductsWithAuth() {
        GetProductsWithAuthMethod getProductsWithAuthMethod = new GetProductsWithAuthMethod();

        getProductsWithAuthMethod.setHeaders(String.format("Authorization=%s", accessToken), "Content-Type=application/json");
        getProductsWithAuthMethod.callAPIExpectSuccess();
        getProductsWithAuthMethod.validateResponseAgainstSchema(GET_RESPONSE_SCHEMA_PATH);
        accessToken = null;
    }
}
