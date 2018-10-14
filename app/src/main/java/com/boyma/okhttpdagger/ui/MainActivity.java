package com.boyma.okhttpdagger.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.boyma.multikotrecview.models.PostDto;
import com.boyma.okhttpdagger.netpost.Api;
import com.boyma.okhttpdagger.App;
import com.boyma.okhttpdagger.R;
import com.boyma.okhttpdagger.netpost.IPostDataRepository;
import com.boyma.okhttpdagger.netpost.PostDataRepositoryImpl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;

    @Inject
    IPostDataRepository iPostDataRepository;

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App)getApplication()).getNetComponent().inject(this);


        tv = findViewById(R.id.tv);

        //tv.setText();

        iPostDataRepository.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        posts ->{System.out.println("sdf:"+posts.size());},
                        throwable -> System.out.println(throwable.toString())
                );
        //Single<List<PostDto>> posts = retrofit.create(Api.class).getPosts();

        /*posts.enqueue(new Callback<List<PostDto>>() {
            @Override
            public void onResponse(Call<List<PostDto>> call, Response<List<PostDto>> response) {
                tv.setText(response.body().get(0).getBody());
            }

            @Override
            public void onFailure(Call<List<PostDto>> call, Throwable t) {
                tv.setText(t.toString());
            }
        });*/
    }
}
