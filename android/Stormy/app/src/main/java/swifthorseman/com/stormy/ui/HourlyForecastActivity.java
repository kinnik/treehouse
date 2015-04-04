package swifthorseman.com.stormy.ui;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.InjectView;
import swifthorseman.com.stormy.R;
import swifthorseman.com.stormy.adapters.HourAdapter;
import swifthorseman.com.stormy.weather.Hour;

public class HourlyForecastActivity extends ActionBarActivity {

    private Hour[] hours;

    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);
        ButterKnife.inject(this);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);
        hours = Arrays.copyOf(parcelables, parcelables.length, Hour[].class);
        HourAdapter adapter = new HourAdapter(this, hours);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // optimisation for fixed size data
        recyclerView.setHasFixedSize(true);
    }
}
