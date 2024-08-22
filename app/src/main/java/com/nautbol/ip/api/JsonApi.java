package com.nautbol.ip.api;

import com.google.gson.JsonObject;
import com.nautbol.ip.models.IpGeolocationResponse;
import com.nautbol.ip.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonApi {
    @GET(Constants.GEO_URL)
    Call<IpGeolocationResponse> getIpInfo(
            @Query("apiKey") String apiKey);
}
