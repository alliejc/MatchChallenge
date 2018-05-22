package com.alisonjc.matchchallenge.viewmodel;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.alisonjc.matchchallenge.model.Datum;
import com.alisonjc.matchchallenge.model.MatchSample;
import com.alisonjc.matchchallenge.network.MatchService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by acaldwell on 5/21/18.
 */

public class MatchViewModel extends ViewModel {
    private MutableLiveData<List<Datum>> datumList;

    public LiveData<List<Datum>> getDatumList() {
        if (datumList == null) {
            datumList = new MutableLiveData<List<Datum>>();
                loadDatumList();
        }
        return datumList;
    }

    public List<Datum> loadSavedDatumList() {
        List<Datum> likedList = new ArrayList<>();
        if(datumList != null) {
            for (Datum datum : datumList.getValue()) {
                if (datum.getLiked()) {
                    likedList.add(datum);
                }
            }
        }
        return likedList;
    }

    private void loadDatumList() {
        MatchService matchService = MatchService.getMatchService();

        Call call = matchService.getMatches();
            call.enqueue(new Callback<MatchSample>() {
                @Override
                public void onResponse(Call<MatchSample> call, Response<MatchSample> response) {
                    if(response.isSuccessful()){
                        datumList.setValue(response.body().getData());
                    }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Log.e("load datum list", t.getMessage());
                }
            });
        }
}