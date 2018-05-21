package com.alisonjc.matchchallenge.network;


import com.alisonjc.matchchallenge.model.MatchSample;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MatchInterface {

    @GET("matchSample.json")
    Call<MatchSample> getMatchSample();

}
