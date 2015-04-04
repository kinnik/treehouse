package swifthorseman.com.stormy.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import swifthorseman.com.stormy.weather.Day;
import swifthorseman.com.stormy.R;


public class DayAdapter extends BaseAdapter {
    private Context context;
    private Day[]   days;

    public DayAdapter(Context context, Day[] days) {
        this.context = context;
        this.days    = days;
    }

    @Override
    public int getCount() {
        return days.length;
    }

    @Override
    public Object getItem(int position) {
        return days[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;   // not using
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            // brand new
            convertView = LayoutInflater.from(context).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.temperatureLabel = (TextView) convertView.findViewById(R.id.temperatureLabel);
            holder.dayLabel = (TextView) convertView.findViewById(R.id.dayNameLabel);
            convertView.setTag(holder); 
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Day day = days[position];
        holder.iconImageView.setImageResource(day.getIconId());
        holder.temperatureLabel.setText(String.valueOf(day.getTemperatureMax()));

        if (position == 0) {
            holder.dayLabel.setText("Today");
        } else {
            holder.dayLabel.setText(day.getDayOfTheWeek());
        }

        return convertView;
    }

    public static class ViewHolder {
        ImageView iconImageView;
        TextView  temperatureLabel, dayLabel;
    }
}
