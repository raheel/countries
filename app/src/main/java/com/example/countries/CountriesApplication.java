package com.example.countries;

import android.app.Application;

import com.example.countries.injection.ActivityComponent;
import com.example.countries.injection.DaggerActivityComponent;
import com.example.countries.injection.NetworkModule;

/**
 * Created by rahkhan1 on 1/31/16.
 */
public class CountriesApplication extends Application {
    private static CountriesApplication instance;
    private ActivityComponent activityComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        System.out.println("CountriesApplication.onCreate");
       activityComponent = DaggerActivityComponent.builder().
               networkModule(new NetworkModule()).build();
        System.out.println("instance = " + instance);
        System.out.println("activityComponent = " + activityComponent);

    }

    public static CountriesApplication getInstance() {
        return instance;
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
