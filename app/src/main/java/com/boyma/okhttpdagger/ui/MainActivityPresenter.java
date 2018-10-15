package com.boyma.okhttpdagger.ui;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.boyma.multikotrecview.models.PostDto;
import com.boyma.okhttpdagger.App;
import com.boyma.okhttpdagger.netpostfeature.di.DaggerNetPostComponent;
import com.boyma.okhttpdagger.netpostfeature.di.NetPostComponent;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<IMainActivityView>{


    private boolean firstlaunch = true;
    private NetPostComponent netPostComponent;

    public MainActivityPresenter() {
        netPostComponent = DaggerNetPostComponent.builder()
                .netComponent((App.getNetComponent()))
                .build();
    }


    @SuppressLint("CheckResult")
    public void onCreate() {
        netPostComponent.getIPostDataRepository().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onSuccess,
                        throwable -> System.out.println(throwable.toString())
                );
    }

    private void onSuccess(List<PostDto> posts) {
        System.out.println("sdf:"+posts.size());
        if (firstlaunch) getViewState().showToast("asd:"+String.valueOf(posts.size()));
        getViewState().setText("asd:"+String.valueOf(posts.size()));
        firstlaunch = false;
    }
}
