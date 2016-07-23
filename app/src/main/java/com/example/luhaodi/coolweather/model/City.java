package com.example.luhaodi.coolweather.model;

/**
 * Created by Lu Haodi on 2016/7/23.
 */
public class City {
    private int id;
    private String cityName;
    private String cityCode;
    private int provinceId;

    public void setId(int id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {

        return cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public int getId() {
        return id;
    }

    public int getProvinceId() {
        return provinceId;
    }
}
