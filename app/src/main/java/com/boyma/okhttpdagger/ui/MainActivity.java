package com.boyma.okhttpdagger.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.boyma.okhttpdagger.App;
import com.boyma.okhttpdagger.R;
import com.boyma.okhttpdagger.netpostfeature.di.DaggerNetPostComponent;
import com.boyma.okhttpdagger.netpostfeature.di.NetPostComponent;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    /*@Inject
    Api api;*/


    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ;


        tv = findViewById(R.id.tv);

        NetPostComponent netPostComponent = DaggerNetPostComponent.builder()
                .netComponent(((App)getApplication()).getNetComponent())
                .build();
                //.injecttim(this);
        //netPostComponent.injecttim(this);


        //tv.setText();

        netPostComponent.getIPostDataRepository().getPosts()
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
