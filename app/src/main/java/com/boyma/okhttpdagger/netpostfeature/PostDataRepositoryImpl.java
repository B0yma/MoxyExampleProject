package com.boyma.okhttpdagger.netpostfeature;

import com.boyma.multikotrecview.models.PostDto;

import java.util.List;

import io.reactivex.Single;

public class PostDataRepositoryImpl implements IPostDataRepository{

    private Api api;


    public PostDataRepositoryImpl(Api api) {
        this.api = api;
        System.out.println("PostDataRepositoryImpl constructor");
    }

    @Override
    public Single<List<PostDto>> getPosts() {
        return api.getPosts();
    }
}
