package com.alisonjc.matchchallenge;

import android.app.Application;
import android.content.Context;

import com.alisonjc.matchchallenge.injection.AppComponent;
import com.alisonjc.matchchallenge.injection.AppModule;
import com.alisonjc.matchchallenge.injection.DaggerAppComponent;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;


public class BaseApplication extends Application{
    private static BaseApplication instance;

    public static BaseApplication getInstance() {
        return instance;
    }
    protected AppComponent appComponent;
    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static RefWatcher getRefWatcher(Context context) {
        BaseApplication application = (BaseApplication) context.getApplicationContext();
        return application.refWatcher;
    }
}
