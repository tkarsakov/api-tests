package com.solvd.apitests.api.dummyjson;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url="${base_url}/products/add", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/dummyjson/_post/rq.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostProductsMethod extends AbstractApiMethodV2 {
    public PostProductsMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
