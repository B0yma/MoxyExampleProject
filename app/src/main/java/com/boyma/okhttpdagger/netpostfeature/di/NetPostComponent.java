package com.boyma.okhttpdagger.netpostfeature.di;

import com.boyma.okhttpdagger.di.NetComponent;
import com.boyma.okhttpdagger.netpostfeature.IPostDataRepository;
import com.boyma.okhttpdagger.ui.MainActivity;

import dagger.Component;

@PerMainActivityScope
@Component(modules = {NetPostModule.class},  dependencies = NetComponent.class)
public interface NetPostComponent {

    void injecttim(MainActivity mainActivity);

    IPostDataRepository getIPostDataRepository();
}
