package swifthorseman.com.stormy.ui;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.InjectView;
import swifthorseman.com.stormy.R;
import swifthorseman.com.stormy.adapters.DayAdapter;
import swifthorseman.com.stormy.weather.Day;

public class DailyForecastActivity extends Activity {

    private Day[] days;
    @InjectView(android.R.id.list) ListView listView;
    @InjectView(android.R.id.empty)
    TextView emptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        ButterKnife.inject(this);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        days = Arrays.copyOf(parcelables, parcelables.length, Day[].class);

        DayAdapter adapter = new DayAdapter(this, days);
        listView.setAdapter(adapter);
        listView.setEmptyView(emptyTextView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String dayOfTheWeek = days[position].getDayOfTheWeek();
                String conditions = days[position].getSummary();
                String highTemp = String.valueOf(days[position].getTemperatureMax());

                String message = String.format("On %s the high will be %s and it will be %s", dayOfTheWeek, highTemp, conditions);
                Toast.makeText(DailyForecastActivity.this, message, Toast.LENGTH_LONG).show();

            }
        });
    }
}
