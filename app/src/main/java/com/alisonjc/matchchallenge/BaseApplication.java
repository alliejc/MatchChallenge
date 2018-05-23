package com.alisonjc.matchchallenge;
//
import android.app.Application;
//import android.content.Context;
//
//import com.facebook.stetho.Stetho;
//import com.squareup.leakcanary.LeakCanary;
//import com.squareup.leakcanary.RefWatcher;
//

public class BaseApplication extends Application{

//    private RefWatcher refWatcher;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        Stetho.initializeWithDefaults(this);
//
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);
//    }
//
//    public static RefWatcher getRefWatcher(Context context) {
//        BaseApplication application = (BaseApplication) context.getApplicationContext();
//        return application.refWatcher;
//    }
}
