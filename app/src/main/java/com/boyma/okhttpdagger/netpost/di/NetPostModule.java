package com.boyma.okhttpdagger.netpost.di;

import com.boyma.multikotrecview.models.PostDto;
import com.boyma.okhttpdagger.App;
import com.boyma.okhttpdagger.netpost.Api;
import com.boyma.okhttpdagger.netpost.IPostDataRepository;
import com.boyma.okhttpdagger.netpost.PostDataRepositoryImpl;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@Module
public class NetPostModule {

    @Provides
    IPostDataRepository provideRepository(Api api){
        return new PostDataRepositoryImpl(api);
    }

    @Provides
    Api provideApi(Retrofit retrofit){
        return retrofit.create(Api.class);
    }

}
