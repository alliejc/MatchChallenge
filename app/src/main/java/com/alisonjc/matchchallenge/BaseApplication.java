package com.alisonjc.matchchallenge;

import android.app.Application;

import com.facebook.stetho.Stetho;



public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
