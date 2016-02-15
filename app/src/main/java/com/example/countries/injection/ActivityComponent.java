package com.example.countries.injection;

import com.example.countries.MainActivity;
import com.example.countries.MainActivityFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rahkhan1 on 1/31/16.
 */
@Singleton
@Component(modules = { NetworkModule.class})
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(MainActivityFragment fragment);
}
