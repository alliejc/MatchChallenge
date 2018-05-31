package com.alisonjc.matchchallenge.injection;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by acaldwell on 5/30/18.
 */

@Module
public class AppModule {
    Application application;


    public AppModule(Application application) {
        this.application = application;
    }


    @Provides
    @Singleton
    @ForApplication
    Context provideContext() {
        return application;
    }
}