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

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        NetPostComponent netPostComponent = DaggerNetPostComponent.builder()
                .netComponent(((App)getApplication()).getNetComponent())
                .build();

        netPostComponent.getIPostDataRepository().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        posts ->{System.out.println("sdf:"+posts.size());},
                        throwable -> System.out.println(throwable.toString())
                );
    }

    private void initUI() {
        tv = findViewById(R.id.tv);
    }
}
