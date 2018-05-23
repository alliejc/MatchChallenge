package com.alisonjc.matchchallenge.network;

import com.alisonjc.matchchallenge.model.MatchSample;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MatchService {

    private static MatchService mMatchService;
    private final MatchInterface mMatchInterface;

    public static MatchService getMatchService() {
        if (mMatchService != null){
            return mMatchService;
        } else {
            mMatchService = new MatchService();
            return mMatchService;
        }
    }

    public MatchService() {
        String mMatchUrl = "https://www.okcupid.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mMatchUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mMatchInterface = retrofit.create(MatchInterface.class);
    }

    public Call<MatchSample> getMatches() {
        return mMatchInterface.getMatchSample();
    }
}
