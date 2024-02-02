package com.solvd.apitests;

import com.solvd.apitests.api.GetProductsMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class DummyjsonApiTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testGetProducts() {
        GetProductsMethod getProductsMethod = new GetProductsMethod();
        getProductsMethod.callAPIExpectSuccess();
        getProductsMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getProductsMethod.validateResponseAgainstSchema("api/dummyjson/_get/rs.schema");
    }
}
