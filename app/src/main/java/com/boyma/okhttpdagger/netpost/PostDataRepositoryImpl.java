package com.boyma.okhttpdagger.netpost;

import com.boyma.multikotrecview.models.PostDto;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class PostDataRepositoryImpl implements IPostDataRepository{

    private Api api;

    @Inject
    public PostDataRepositoryImpl(Api api) {
        this.api = api;
        System.out.println("PostDataRepositoryImpl constructor");
    }

    @Override
    public Single<List<PostDto>> getPosts() {
        return api.getPosts();
    }
}
