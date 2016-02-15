package com.example.countries;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.example.countries.api.CountriesService;
import com.example.countries.R;
import com.example.countries.domain.Country;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @Inject
    CountriesService countriesService;

    @Bind(R.id.sortBySpinner)
    Spinner sortBySpinner;

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    private CountryAdapter adapter;

    private static final Comparator<Country> nameComparator = new NameComparator();
    private static final Comparator<Country> areaComparator = new AreaComparator();
    private static final Comparator<Country> populationComparator = new PopulationComparator();


    private List<Country> countries;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        System.out.println("recyclerView = " + recyclerView);

        System.out.println("MainActivityFragment.onCreateView");
        CountriesApplication.getInstance().getActivityComponent().inject(this);

        countriesService.getAllCountries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Country>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("MainActivityFragment.onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("MainActivityFragment.onError ");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<Country> countries) {
                        MainActivityFragment.this.countries = countries;
                        System.out.println("123 MainActivityFragment.onNext");
                        System.out.println("countries.size() = " + countries.size());
                        recyclerView.setAdapter(new CountryAdapter(MainActivityFragment.this.getActivity(), countries));
                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setHasFixedSize(true);
                    }
                });


        return view;
    }



    @OnItemSelected(R.id.sortBySpinner)
    public void onSortByChanged(){
        if (countries==null){
            return;
        }

        System.out.println("123a MainActivityFragment.onSortByChanged");
        String sortBy = (String)sortBySpinner.getSelectedItem();
        System.out.println("sortBy = " + sortBy);
        Comparator comparator = nameComparator;
        System.out.println("1 comparator " + comparator);

        if(getString(R.string.area).equals(sortBy)){
            comparator = areaComparator;
            System.out.println("1a comparator " + comparator);

        }
        else
        if(getString(R.string.population).equals(sortBy)){
            comparator = populationComparator;
            System.out.println("1b comparator " + comparator);

        }
        Collections.sort(countries, comparator);
        System.out.println("2 comparator " + comparator);
        recyclerView.setAdapter(new CountryAdapter(MainActivityFragment.this.getActivity(), countries));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    private static class NameComparator implements Comparator<Country>{

        @Override
        public int compare(Country c1, Country c2) {
            System.out.println("c1 = " + c1!=null);
            System.out.println("c2 = " + c2!=null);
            if (c1==null && c2==null){
                return 0;
            }
            else
            if (c1==null){
                return -1;
            }
            else
            if (c2==null){
                return 1;
            }
            return c1.getName().compareTo(c2.getName());
        }
    }

    private static class AreaComparator implements Comparator<Country>{

        @Override
        public int compare(Country c1, Country c2) {
            System.out.println("asfd AreaComparator.compare");
            System.out.println("c1 = " + c1!=null);
            System.out.println("c2 = " + c2!=null);
            if (c1==null && c2==null){
                return 0;
            }
            else
            if (c1==null){
                return -1;
            }
            else
            if (c2==null){
                return 1;
            }
            return (int)(c2.getArea() - c1.getArea());
        }
    }

    private static class PopulationComparator implements Comparator<Country>{

        @Override
        public int compare(Country c1, Country c2) {
            if (c1==null && c2==null){
                return 0;
            }
            else
            if (c1==null){
                return -1;
            }
            else
            if (c2==null){
                return 1;
            }
            return c2.getPopulation() - c1.getPopulation();
        }
    }
}
