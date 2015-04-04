package swifthorseman.com.stormy.weather;


import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hour implements Parcelable {
    private long time;
    private double temperature;
    private String icon, timezone, summary;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getTemperature() {
        return (int) Math.round(temperature);
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getIcon() {
        return icon;
    }


    public int getIconId() {
        return Forecast.getIconID(icon);
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

    public String getSummary() {
        return summary;
    }

    public String getHour() {
        SimpleDateFormat formatter = new SimpleDateFormat("h a");
        Date date = new Date(time * 1000);
        return formatter.format(date);
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public int describeContents() {
        return 0; // ignored
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(time);
        dest.writeDouble(temperature);
        dest.writeString(icon);
        dest.writeString(timezone);
        dest.writeString(summary);
    }

    private Hour(Parcel in) {
        time = in.readLong();
        temperature = in.readDouble();
        icon = in.readString();
        timezone = in.readString();
        summary = in.readString();
    }

    public Hour() {}

    public static final Creator<Hour> CREATOR = new Creator<Hour>() {
        @Override
        public Hour createFromParcel(Parcel source) {
            return new Hour(source);
        }

        @Override
        public Hour[] newArray(int size) {
            return new Hour[size];
        }
    };
}
