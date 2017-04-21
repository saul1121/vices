package com.app.vice.deps;


import com.app.vice.home.MainActivity;
import com.app.vice.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(MainActivity homeActivity);
}
