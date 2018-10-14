package com.boyma.okhttpdagger.netpostfeature;

import com.boyma.multikotrecview.models.PostDto;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {

    @GET("/posts")
    Single<List<PostDto>> getPosts();
}
