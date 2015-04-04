package swifthorseman.com.stormy.weather;


import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Day implements Parcelable {
    private long time;
    private String summary, icon, timezone;
    private double temperatureMax;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getTemperatureMax() {
        return (int) Math.round(temperatureMax);
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public int getIconId() {
        return Forecast.getIconID(icon);
    }

    public String getDayOfTheWeek() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        formatter.setTimeZone(TimeZone.getTimeZone(timezone));
        Date datetime = new Date(time * 1000);
        return formatter.format(datetime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(time);
        dest.writeString(summary);
        dest.writeDouble(temperatureMax);
        dest.writeString(icon);
        dest.writeString(timezone);
    }

    private Day(Parcel in) {
        // the order is import in parcels
        time = in.readLong();
        summary = in.readString();
        temperatureMax = in.readDouble();
        icon = in.readString();
        timezone = in.readString();
    }

    public Day() {}

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel source) {
            return new Day(source);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };

}
