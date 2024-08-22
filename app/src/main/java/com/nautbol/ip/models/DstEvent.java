package com.nautbol.ip.models;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class DstEvent {
    @SerializedName("utc_time")
    private String utcTime;

    @SerializedName("duration")
    private String duration;

    @SerializedName("gap")
    private boolean gap;

    @SerializedName("dateTimeAfter")
    private String dateTimeAfter;

    @SerializedName("dateTimeBefore")
    private String dateTimeBefore;

    @SerializedName("overlap")
    private boolean overlap;

    public String getUtcTime() {
        return utcTime;
    }

    public void setUtcTime(String utcTime) {
        this.utcTime = utcTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isGap() {
        return gap;
    }

    public void setGap(boolean gap) {
        this.gap = gap;
    }

    public String getDateTimeAfter() {
        return dateTimeAfter;
    }

    public void setDateTimeAfter(String dateTimeAfter) {
        this.dateTimeAfter = dateTimeAfter;
    }

    public String getDateTimeBefore() {
        return dateTimeBefore;
    }

    public void setDateTimeBefore(String dateTimeBefore) {
        this.dateTimeBefore = dateTimeBefore;
    }

    public boolean isOverlap() {
        return overlap;
    }

    public void setOverlap(boolean overlap) {
        this.overlap = overlap;
    }

    @NonNull
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
