package com.alisonjc.matchchallenge.injection;

import android.content.Context;

import com.alisonjc.matchchallenge.R;
import com.alisonjc.matchchallenge.network.MatchInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class NetworkModule {

    @Provides
    @Singleton
    MatchInterface provideMatchInterface(@ForApplication Context context,
                                         OkHttpClient httpClient,
                                         GsonConverterFactory gsonConverterFactory) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.ok_cupid_base_url))
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build();
        return retrofit.create(MatchInterface.class);
    }
}
