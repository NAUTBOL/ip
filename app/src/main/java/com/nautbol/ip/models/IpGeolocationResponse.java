package com.nautbol.ip.models;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class IpGeolocationResponse {

    @SerializedName("ip")
    private String ip;

    @SerializedName("continent_code")
    private String continentCode;

    @SerializedName("continent_name")
    private String continentName;

    @SerializedName("country_code2")
    private String countryCode2;

    @SerializedName("country_code3")
    private String countryCode3;

    @SerializedName("country_name")
    private String countryName;

    @SerializedName("country_name_official")
    private String countryNameOfficial;

    @SerializedName("country_capital")
    private String countryCapital;

    @SerializedName("state_prov")
    private String stateProv;

    @SerializedName("state_code")
    private String stateCode;

    @SerializedName("district")
    private String district;

    @SerializedName("city")
    private String city;

    @SerializedName("zipcode")
    private String zipcode;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("is_eu")
    private boolean isEu;

    @SerializedName("calling_code")
    private String callingCode;

    @SerializedName("country_tld")
    private String countryTld;

    @SerializedName("languages")
    private String languages;

    @SerializedName("country_flag")
    private String countryFlag;

    @SerializedName("geoname_id")
    private String geonameId;

    @SerializedName("isp")
    private String isp;

    @SerializedName("connection_type")
    private String connectionType;

    @SerializedName("organization")
    private String organization;

    @SerializedName("country_emoji")
    private String countryEmoji;

    @SerializedName("currency")
    private Currency currency;

    @SerializedName("time_zone")
    private TimeZone timeZone;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public String getCountryCode2() {
        return countryCode2;
    }

    public void setCountryCode2(String countryCode2) {
        this.countryCode2 = countryCode2;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryNameOfficial() {
        return countryNameOfficial;
    }

    public void setCountryNameOfficial(String countryNameOfficial) {
        this.countryNameOfficial = countryNameOfficial;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

    public String getStateProv() {
        return stateProv;
    }

    public void setStateProv(String stateProv) {
        this.stateProv = stateProv;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public boolean isEu() {
        return isEu;
    }

    public void setEu(boolean eu) {
        isEu = eu;
    }

    public String getCallingCode() {
        return callingCode;
    }

    public void setCallingCode(String callingCode) {
        this.callingCode = callingCode;
    }

    public String getCountryTld() {
        return countryTld;
    }

    public void setCountryTld(String countryTld) {
        this.countryTld = countryTld;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public String getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(String geonameId) {
        this.geonameId = geonameId;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getCountryEmoji() {
        return countryEmoji;
    }

    public void setCountryEmoji(String countryEmoji) {
        this.countryEmoji = countryEmoji;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    @NonNull
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
