package com.boyma.okhttpdagger.netpost;

import com.boyma.multikotrecview.models.PostDto;

import java.util.List;

import io.reactivex.Single;

public interface IPostDataRepository {
    Single<List<PostDto>> getPosts();
}
