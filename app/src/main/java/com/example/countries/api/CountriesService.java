package com.example.countries.api;

import com.example.countries.domain.Country;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by rahkhan1 on 1/28/16.
 */
public interface CountriesService {

    @GET("/rest/v1/all")
    public Observable<List<Country>> getAllCountries();
}
