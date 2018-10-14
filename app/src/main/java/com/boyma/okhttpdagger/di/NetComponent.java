package com.boyma.okhttpdagger.di;

import dagger.Component;
import retrofit2.Retrofit;

@AppScope
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    Retrofit getRetrofit();

}
