package com.boyma.okhttpdagger.di;

import com.boyma.okhttpdagger.netpost.IPostDataRepository;
import com.boyma.okhttpdagger.netpost.di.NetPostModule;
import com.boyma.okhttpdagger.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class, NetPostModule.class})
public interface NetComponent {

    void inject(MainActivity activity);

    //void inject(IPostDataRepository postDataRepository);

}
