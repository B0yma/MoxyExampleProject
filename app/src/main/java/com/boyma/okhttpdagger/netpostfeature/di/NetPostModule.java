package com.boyma.okhttpdagger.netpostfeature.di;

import com.boyma.okhttpdagger.netpostfeature.Api;
import com.boyma.okhttpdagger.netpostfeature.IPostDataRepository;
import com.boyma.okhttpdagger.netpostfeature.PostDataRepositoryImpl;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class NetPostModule {

    @Provides
    @PerMainActivityScope
    public IPostDataRepository provideRepository(Api api){
        return new PostDataRepositoryImpl(api);
    }

    @Provides
    @PerMainActivityScope
    public Api provideApi(Retrofit retrofit){
        System.out.println("Api Constructor");
        return retrofit.create(Api.class);
    }

}
