package com.boyma.okhttpdagger;

import android.app.Application;

import com.boyma.okhttpdagger.di.AppModule;
import com.boyma.okhttpdagger.di.DaggerNetComponent;
import com.boyma.okhttpdagger.di.NetComponent;
import com.boyma.okhttpdagger.di.NetModule;

public class App extends Application {

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();

    }

    public NetComponent getNetComponent() {
        return netComponent;
    }

}
