package com.example.countries;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by rahkhan1 on 2/1/16.
 */
public class CountryItemView extends RelativeLayout{
    @Bind(R.id.image_country_flag)
    ImageView countryFlagImage;

    @Bind(R.id.country_name)
    TextView countryNameView;

    @Bind(R.id.country_capital)
    TextView countryCapitalView;

    @Bind(R.id.country_area)
    TextView countryAreaView;

    @Bind(R.id.country_population)
    TextView countryPopulationView;

    public CountryItemView(Context context) {
        super(context);
    }

    public CountryItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CountryItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }
}
