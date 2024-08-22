package com.nautbol.ip.api;

import com.nautbol.ip.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIBuilder {
    private JsonApi jsonApi;

    public APIBuilder() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonApi = retrofit.create(JsonApi.class);
        this.jsonApi = jsonApi;
    }

    public JsonApi getJsonApi() {
        return jsonApi;
    }

    public void setJsonApi(JsonApi jsonApi) {
        this.jsonApi = jsonApi;
    }
}
