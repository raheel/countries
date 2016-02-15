package com.example.countries.injection;

import com.example.countries.api.CountriesService;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by rahkhan1 on 1/29/16.
 */
@Module
public class NetworkModule {
    public static final HttpUrl API_URL = HttpUrl.parse("https://restcountries.eu/");
    public static final HttpUrl IMAGE_BASE_URL = HttpUrl.parse("https://restcountries.eu/");

    @Provides
    @Singleton
    HttpUrl provideApiBaseUrl() {
        return API_URL;
    }


//    @Provides
//    @Singleton
//    HttpUrl provideImageBaseUrl() {
//        return IMAGE_BASE_URL;
//    }

    @Provides
    @Singleton
    CountriesService provideCountriesService(HttpUrl baseUrl,  OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(CountriesService.class);
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(60, TimeUnit.SECONDS);
        return okHttpClient;
    }

}
