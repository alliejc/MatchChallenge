package com.alisonjc.matchchallenge.injection;

import com.alisonjc.matchchallenge.BaseApplication;
import com.alisonjc.matchchallenge.MainActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(BaseApplication app);

    void inject(MainActivity activity);
}