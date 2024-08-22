package com.nautbol.ip.models;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class TimeZone {
    @SerializedName("name")
    private String name;

    @SerializedName("offset")
    private int offset;

    @SerializedName("offset_with_dst")
    private int offsetWithDst;

    @SerializedName("current_time")
    private String currentTime;

    @SerializedName("current_time_unix")
    private double currentTimeUnix;

    @SerializedName("is_dst")
    private boolean isDst;

    @SerializedName("dst_savings")
    private int dstSavings;

    @SerializedName("dst_exists")
    private boolean dstExists;

    @SerializedName("dst_start")
    private DstEvent dstStart;

    @SerializedName("dst_end")
    private DstEvent dstEnd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffsetWithDst() {
        return offsetWithDst;
    }

    public void setOffsetWithDst(int offsetWithDst) {
        this.offsetWithDst = offsetWithDst;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public double getCurrentTimeUnix() {
        return currentTimeUnix;
    }

    public void setCurrentTimeUnix(double currentTimeUnix) {
        this.currentTimeUnix = currentTimeUnix;
    }

    public boolean isDst() {
        return isDst;
    }

    public void setDst(boolean dst) {
        isDst = dst;
    }

    public int getDstSavings() {
        return dstSavings;
    }

    public void setDstSavings(int dstSavings) {
        this.dstSavings = dstSavings;
    }

    public boolean isDstExists() {
        return dstExists;
    }

    public void setDstExists(boolean dstExists) {
        this.dstExists = dstExists;
    }

    public DstEvent getDstStart() {
        return dstStart;
    }

    public void setDstStart(DstEvent dstStart) {
        this.dstStart = dstStart;
    }

    public DstEvent getDstEnd() {
        return dstEnd;
    }

    public void setDstEnd(DstEvent dstEnd) {
        this.dstEnd = dstEnd;
    }

    @NonNull
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
