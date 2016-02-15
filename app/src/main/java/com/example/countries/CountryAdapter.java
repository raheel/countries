package com.example.countries;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.countries.domain.Country;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by rahkhan1 on 2/2/16.
 */
public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private Context context;
    private List<Country> countries;

    private static final String IMAGE_BASE_URL = "http://www.crwflags.com/fotw/images/";
    public CountryAdapter(Context context, List<Country> countries) {
        System.out.println(new Date() + " CountryAdapter.CountryAdapter");
        this.context = context;
        this.countries = countries;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        System.out.println("CountryAdapter.onCreateViewHolder");
        CountryItemView view = (CountryItemView) LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        System.out.println("CountryAdapter.onBindViewHolder 1234 ");
        Country country = countries.get(position);
        holder.itemView.countryNameView.setText(country.getName());
        holder.itemView.countryCapitalView.setText(getSpannableString("Capital:\n" + country.getCapital(), "Capital:"));
        holder.itemView.countryAreaView.setText(getSpannableString("Area:\n" + NumberFormat.getNumberInstance(Locale.US).format(country.getArea()), "Area:"));
        holder.itemView.countryPopulationView.setText(getSpannableString("Population:\n" + NumberFormat.getNumberInstance(Locale.US).format(country.getPopulation()), "Population:"));
        String code = country.getAlpha2Code();
        Picasso.with(context).load(IMAGE_BASE_URL + code.substring(0,1) + "/" + code + ".gif").into(holder.itemView.countryFlagImage);
        System.out.println(IMAGE_BASE_URL + code.substring(0,1) + "/" + code + ".gif");
    }

    private SpannableString getSpannableString(String text, String boldText){
        SpannableString spannable = new SpannableString(text);
        spannable.setSpan(new StyleSpan(Typeface.BOLD), 0, boldText.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return spannable;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public final class ViewHolder extends RecyclerView.ViewHolder{
        private CountryItemView itemView;
        public ViewHolder(CountryItemView itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }
}
