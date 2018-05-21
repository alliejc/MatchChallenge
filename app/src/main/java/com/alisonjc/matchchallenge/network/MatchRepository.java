//package com.alisonjc.matchchallenge.network;
//
//import android.arch.lifecycle.LiveData;
//import android.arch.lifecycle.MutableLiveData;
//
//import com.alisonjc.matchchallenge.model.Datum;
//
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//
//public class MatchRepository {
//    private MatchService mMatchService = MatchService.getMatchService();
//    private static MatchRepository mMatchRepo;
//
//    public static MatchRepository getInstance() {
//        if (mMatchRepo != null){
//            return mMatchRepo;
//        } else {
//            mMatchRepo = new MatchRepository();
//            return mMatchRepo;
//        }
//    }
////    public List<Datum> getMatchList() {
////        final MutableLiveData data = new MutableLiveData<>();
////
////        mMatchService.getMatches().enqueue(new Callback<MatchSample>() {
////
////            @Override
////            public void onResponse(Call<MatchSample> call, Response<MatchSample> response) {
////                data.setValue(response.body().getData());
////            }
////
////            @Override
////            public void onFailure(Call<MatchSample> call, Throwable t) {
////
////            }
////        });
////
////        return data;
////    }
//}
