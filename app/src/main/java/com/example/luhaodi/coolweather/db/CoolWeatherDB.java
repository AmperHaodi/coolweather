package com.example.luhaodi.coolweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.luhaodi.coolweather.model.City;
import com.example.luhaodi.coolweather.model.County;
import com.example.luhaodi.coolweather.model.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lu Haodi on 2016/7/23.
 */
public class CoolWeatherDB  {

    public static final String DB_NAME = "cool_weather";

    public static final int VERSION = 1;

    private static CoolWeatherDB coolWeatherDB;
    private SQLiteDatabase db;

    /**
    私有化构造方法
     */
    private CoolWeatherDB(Context context){
        CoolWeatherOpenHelper dbhelper = new CoolWeatherOpenHelper(context,DB_NAME,null,VERSION);
        db = dbhelper.getWritableDatabase();
    }

    /**
    获取实例Instance
     */
    public synchronized static CoolWeatherDB getInstance(Context context){
        if(coolWeatherDB == null){
            coolWeatherDB = new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }

    /**
     * Province存储到数据库
     * @param province
     */
    public void saveProvince(Province province){
        if(province != null){
            ContentValues values = new ContentValues();
            values.put("province_name",province.getProvince_name());
            values.put("province_code",province.getProvinceCode());
            db.insert("Province",null,values);
        }
    }

    public List<Province> loadProvince(){
        List<Province> list = new ArrayList<>();
        Cursor cursor = db.query("Province",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvince_name(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);
            }while (cursor.moveToNext());
            if(cursor != null){
                cursor.close();
            }
        }
        return list;
    }

    /**
     * City存储到数据库
     * @param city
     */
    public void saveCity(City city){
        if(city != null){
            ContentValues values = new ContentValues();
            values.put("city_name",city.getCityName());
            values.put("city_code",city.getCityCode());
            values.put("province_id",city.getProvinceId());
            db.insert("City",null,values);
        }
    }

    public List<City> loadCity(int provinceId){
        List<City> list = new ArrayList<>();
        Cursor cursor = db.query("City",null,"province_id = ?",new String[]{String.valueOf(provinceId)},null,null,null);
        if(cursor.moveToFirst()){
            do{
                City city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                city.setProvinceId(provinceId);
                list.add(city);
            }while (cursor.moveToNext());
            if(cursor != null){
                cursor.close();
            }
        }
        return list;
    }

    /**
     * County存储到数据库
     * @param county
     *
     */
    public void saveCounty(County county){
        if(county != null){
            ContentValues values = new ContentValues();
            values.put("count_name",county.getCountyName());
            values.put("count_code",county.getCountyCode());
            values.put("city_id",county.getCityId());
            db.insert("Count",null,values);
        }
    }

    public List<County> loadCounties(int cityId){
        List<County> list = new ArrayList<>();
        Cursor cursor = db.query("County",null,"city_id = ?",new String[]{String.valueOf(cityId)},null,null,null);
        if(cursor.moveToFirst()){
            do{
                County county = new County();
                county.setId(cursor.getInt(cursor.getColumnIndex("id")));
                county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
                county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
                county.setCityId(cityId);
                list.add(county);
            }while (cursor.moveToNext());
            if(cursor != null){
                cursor.close();
            }
        }
        return list;
    }
}
