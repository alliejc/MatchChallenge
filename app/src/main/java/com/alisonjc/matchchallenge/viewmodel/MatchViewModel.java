package com.alisonjc.matchchallenge.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.TabLayout;
import android.util.Log;

import com.alisonjc.matchchallenge.util.MatchComparator;
import com.alisonjc.matchchallenge.model.Datum;
import com.alisonjc.matchchallenge.model.MatchSample;
import com.alisonjc.matchchallenge.network.MatchService;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MatchViewModel extends ViewModel {
    private static final String TAG = MatchViewModel.class.getSimpleName();

    private MutableLiveData<List<Datum>> datumList;
    private MutableLiveData<Integer> selectedTab;

    public LiveData<Integer> getSelectedTab(){
        if(selectedTab == null){
            selectedTab = new MutableLiveData<>();
        }
        return selectedTab;
    }

    public void setSelectedTab(Integer tabIndex){
        selectedTab.setValue(tabIndex);
    }

    public LiveData<List<Datum>> getDatumList() {
        if (datumList == null) {
            datumList = new MutableLiveData<List<Datum>>();
                loadDatumList();
        }
        return datumList;
    }

    private List<Datum> getSavedDatumList() {
        List<Datum> likedList = new ArrayList<>();
        if(datumList != null && datumList.getValue() != null) {
            for (Datum datum : datumList.getValue()) {
                if (datum.getLiked()) {
                    likedList.add(datum);
                }
            }
        }
        Collections.sort(likedList, new MatchComparator());
        return likedList;
    }

    public List<Datum> getTopSixMatches(){
        List<Datum> likedList = getSavedDatumList();

        List<Datum> topMatches = new ArrayList<>();
        if(likedList.size() < 6){
            topMatches = likedList;
        } else {
            topMatches = likedList.subList(0, 6);
        }
        return topMatches;
    }

    private void loadDatumList(){
        MatchService matchService = MatchService.getMatchService();

        Observable<MatchSample> o = matchService.getMatches();
        o.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(matchSample -> {
                    List<Datum> list = matchSample.getData();
                    Collections.sort(list, new MatchComparator());
                    datumList.setValue(list);
                }, throwable ->
                    System.out.print(throwable.getMessage())
                );
    }

//    private void loadDatumList() {
//        MatchService matchService = MatchService.getMatchService();
//
//        Call<MatchSample> call = matchService.getMatches();
//            call.enqueue(new Callback<MatchSample>() {
//                @Override
//                public void onResponse(Call<MatchSample> call, Response<MatchSample> response) {
//                    if(response.isSuccessful()){
//                        List<Datum> list = response.body().getData();
//                        Collections.sort(list, new MatchComparator());
//
//                        datumList.setValue(list);
//                   }
//                }
//
//                @Override
//                public void onFailure(Call call, Throwable t) {
//                    Log.e(TAG, t.getMessage());
//                }
//            });
//        }
}
