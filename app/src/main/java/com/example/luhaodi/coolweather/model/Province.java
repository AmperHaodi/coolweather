package com.example.luhaodi.coolweather.model;

/**
 * Created by Lu Haodi on 2016/7/23.
 */
public class Province {
    private int id;
    private String province_name;
    private String provinceCode;

    public int getId() {
        return id;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

}
