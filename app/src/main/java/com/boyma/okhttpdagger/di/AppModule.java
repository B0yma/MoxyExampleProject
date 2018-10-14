package com.boyma.okhttpdagger.di;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @AppScope
    public Application provideApplication() {
        return mApplication;
    }
}