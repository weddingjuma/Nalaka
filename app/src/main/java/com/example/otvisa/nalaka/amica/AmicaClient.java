package com.example.otvisa.nalaka.amica;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by ottov on 14.8.2017.
 */

public interface AmicaClient {
    @GET("modules/json/json/Index")
    Call<String> amicaJSONObject(
            @QueryMap Map<String, String> options
    );
}
